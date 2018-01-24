package com.hibernate.test;

import com.hibernate.entity.Student;
import com.hibernate.entity.Teacher;
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
        configuration.addClass(Teacher.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
       sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //save
        Teacher teacher1 = new Teacher("rong","Chinese");
        Teacher teacher2 = new Teacher("hua","Math");
        Student student = new Student("xiaoqiang","yuexi");
        student.getTeachers().add(teacher1);
        student.getTeachers().add(teacher2);
        session.save(student);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
