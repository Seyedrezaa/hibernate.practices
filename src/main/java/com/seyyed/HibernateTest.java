package com.seyyed;

import com.seyyed.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateTest {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        User User = new User();
        User.setInfo("Ramin");
        User.setCode("220");
        //something new has been added


        //User.setId(34L);
        session.save(User);
        session.getTransaction().commit();

    }
}