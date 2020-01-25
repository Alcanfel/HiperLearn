package Dao;

import Entities.Child;
import Entities.School;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

public class ChildDao {
    public Session session;

    public ChildDao (){
        this.session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
    public Child findById(int id){
        return this.session.get(Child.class,id);
    }

    public void save(Child child){
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(child);
        tx1.commit();
    }

    public void update(Child child){
//        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(child);
        tx1.commit();


    }

    public void delete(Child child){
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(child);
        tx1.commit();
    }

    public List<Child> findAllChild(){
        List<Child> children = this.session.createQuery("From Child").list();
        return children;
    }

    public void close(){
        session.close();
    }
}
