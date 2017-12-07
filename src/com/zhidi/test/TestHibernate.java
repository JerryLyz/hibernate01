package com.zhidi.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.zhidi.entity.Student;

public class TestHibernate {

	public static void main(String[] args) {
		//读取核心配置文件
		Configuration configure = new Configuration().configure();//读取核心xml
		
		//获取服务注册器支持对象
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
		//将核心配置文件中的配置属性加载到StandardServiceRegistryBuilder对象中
		ssrb.applySettings(configure.getProperties());
		
		//创建服务注册器
		StandardServiceRegistry serviceRegistry = ssrb.build();
		
		//通过Configuration对象创建会话工厂
		SessionFactory factory = configure.buildSessionFactory(serviceRegistry);
		
		Student student = new Student();
		student.setStuName("admin");
		student.setStuAge(25);
		//获取会话对象
		Session session = factory.getCurrentSession();
		
		add(student, session);
		
		//Student stu = (Student)query(1,session);
		//System.out.println(stu);
	}

	/*private static Object query(int id, Session session) {
		//开启事务
		Transaction bt = session.beginTransaction();
		//查询对象
		Object object = session.get(Student.class, 1);
		//提交事务
		bt.commit();
		return object;
	}*/

	public static void add(Student student, Session session) {
		//开启事务
		Transaction bt = session.beginTransaction();
		//保存对象
		session.save(student);
		//提交事务
		bt.commit();
	}

}
