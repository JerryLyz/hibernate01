package com.zhidi.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

	private static final SessionFactory FACTORY = buildSessionFactory();
	
	private static SessionFactory buildSessionFactory() {
		Configuration configure = new Configuration().configure();
		return configure.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configure.getProperties()).build()); 
	}
	
	public static SessionFactory getSessionFactory() {
		return FACTORY;
	}
}
