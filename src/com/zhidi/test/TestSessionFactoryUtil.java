package com.zhidi.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zhidi.entity.Student;
import com.zhidi.util.SessionFactoryUtil;

public class TestSessionFactoryUtil {

	public static void main(String[] args) {
		SessionFactory factory = SessionFactoryUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Student student = (Student) session.get(Student.class, 3);
		//当对处于持久化状态的对象进行更改时，session对象会发出sql指令
		//数据库会执行sql语句
		//Hibernate会检测到处于持久化状态对象的改动，在当前操作完成时将对象数据写回数据库。开发者不需要手动执行UPDATE
		student.setStuName("木子李");
		student.setStuAge(21);
		
		session.getTransaction().commit();
	}

}
