package com.ib.hibernateapp.service;

import com.ib.hibernateapp.model.Book;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil2 {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Properties databaseProperties = DatabaseConfig.getDatabaseProperties();
            Properties hibernateProperties = HibernateConfig.getHibernateProperties();
            
            Properties settings = new Properties();
            settings.putAll(databaseProperties);
            settings.putAll(hibernateProperties);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(settings)
                    .build();

            MetadataSources metadataSources = new MetadataSources(serviceRegistry)
                    .addAnnotatedClass(Book.class);

            MetadataBuilder metadataBuilder = metadataSources.getMetadataBuilder();

            SessionFactoryBuilder sessionFactoryBuilder = metadataBuilder.build().getSessionFactoryBuilder();

            return sessionFactoryBuilder.build();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

class DatabaseConfig {

    public static Properties getDatabaseProperties() {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.h2.Driver");
        settings.put(Environment.URL, "jdbc:h2:~/test");
        settings.put(Environment.USER, "sa");
        settings.put(Environment.PASS, "");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");
        return settings;
    }
}


class HibernateConfig {

    public static Properties getHibernateProperties() {
        Properties settings = new Properties();
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.HBM2DDL_AUTO, "create");
        settings.put(Environment.C3P0_MIN_SIZE, "5");
        settings.put(Environment.C3P0_MAX_SIZE, "20");
        settings.put(Environment.C3P0_TIMEOUT, "300");
        settings.put(Environment.C3P0_MAX_STATEMENTS, "50");
        settings.put(Environment.C3P0_IDLE_TEST_PERIOD, "3000");
        return settings;
    }
}



