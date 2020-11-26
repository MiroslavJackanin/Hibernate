package sk.it.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Person;
import sk.it.hibernate.entity.Phone;

public class CreatePerson {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Phone.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            Person person = new Person("Miro", "Miroslav");

            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
