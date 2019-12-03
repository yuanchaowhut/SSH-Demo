package cn.com.egova.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {
	private static Configuration cfg = null;
	private static SessionFactory factory = null;
	private static Session session = null;
	static {
		cfg = new Configuration().configure();
		factory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build());
	}

	public static void createDB() {
		if (cfg == null) {
			cfg = new Configuration().configure();
		}
		SchemaExport se = new SchemaExport(cfg);
		// ��һ������ �Ƿ�����ddl�ű� �ڶ������� �Ƿ�ִ�е����ݿ���.
		se.create(true, true);
	}

	
	public static Session getSession() {
		if (factory == null) {
			factory = cfg
					.buildSessionFactory(new StandardServiceRegistryBuilder()
							.applySettings(cfg.getProperties()).build());
		}
		session = factory.openSession();
		return session;
	}

	
	public static void closeSession() {
		if (session != null && session.isOpen()) {
			session.close();
		}
	}
}
