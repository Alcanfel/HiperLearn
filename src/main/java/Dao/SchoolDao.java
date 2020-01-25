package Dao;

import Entities.Child;
import Entities.School;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Set;

public class SchoolDao {
    public School findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(School.class,id);
    }

    public void save(School school){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(school);
        tx1.commit();
        session.close();
    }

    public void update(School school){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(school);
        tx1.commit();
        session.close();
    }

    public void delete(School school){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(school);
        tx1.commit();
        session.close();
    }

    public Child findChildByID(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Child.class, id);
    }
    public List<School> findAllSchool(){
        List<School> schools = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From School").list();
        return schools;
    }
    public List<Child> findAllChild(){
        List<Child> children = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Child").list();
        return children;
    }
}
