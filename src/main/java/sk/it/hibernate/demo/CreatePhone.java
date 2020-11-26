package sk.it.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import sk.it.hibernate.entity.Person;
import sk.it.hibernate.entity.Phone;

public class CreatePhone {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Phone.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            int id = 1;
            Person person = session.get(Person.class, id);

            Phone phone1 = new Phone("samsung");
            Phone phone2 = new Phone("nokia");

            person.add(phone1);
            person.add(phone2);

            session.save(phone1);
            session.save(phone2);

            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
