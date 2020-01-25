package Dao;

import Entities.Passport;
import Entities.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PersonDao {
    public Person findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Person.class,id);
    }

    public void save(Person person){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(person);
        tx1.commit();
        session.close();
    }
    public void update(Person person){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(person);
        tx1.commit();
        session.close();
    }

    public void delete(Person person){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(person);
        tx1.commit();
        session.close();
    }
    public Passport findPassportById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Passport.class,id);
    }

    public List<Person> findAllPerson(){
        List<Person> personList = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Person").list();
        return personList;
    }
}
