package com.seyyed;

import com.seyyed.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

public class HibernateTest {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        User User = new User();
        User.setInfo("Ramin");
        User.setCode("220");

        //User.setId(34L);
        session.save(User);

        NativeQuery<com.seyyed.User> nq = session.createNativeQuery("SELECT * FROM user WHERE info = ':info'", User.class);
        nq.setParameter("info", "Ramin");
        User uInfo = nq.getSingleResult();
        System.out.println(uInfo);
        session.getTransaction().commit();



    }
}
