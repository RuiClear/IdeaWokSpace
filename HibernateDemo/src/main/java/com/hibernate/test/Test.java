package com.hibernate.test;

import com.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Created by RuiClear on 2018/1/2.
 */
public class Test {
    public static void main(String[] args) {
        SessionFactory sessionFactory =null;
        Configuration configuration = new Configuration().configure();
        configuration.addClass(Student.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
