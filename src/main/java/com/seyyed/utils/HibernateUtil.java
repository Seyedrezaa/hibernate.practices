package com.seyyed.utils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class HibernateUtil {

    private static volatile SessionFactory instance;

    private HibernateUtil() {
    }

    public static synchronized SessionFactory getSessionFactory() {
        if (instance == null) {
            synchronized (HibernateUtil.class) {
                if (instance == null) {
                    try {
                        StandardServiceRegistry standardRegistry =
                                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
                        Metadata metaData =
                                new MetadataSources(standardRegistry).getMetadataBuilder().build();
                        instance = metaData.getSessionFactoryBuilder().build();
                    } catch (Throwable th) {
                        System.err.println("Enitial SessionFactory creation failed" + th);
                        throw new ExceptionInInitializerError(th);
                    }
                }
            }
        }
        return instance;
    }
}
