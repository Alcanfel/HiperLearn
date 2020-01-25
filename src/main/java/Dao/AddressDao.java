package Dao;

import Entities.TownShip;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AddressDao {
    public TownShip findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(TownShip.class,id);
    }

    public void save(TownShip townShip){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(townShip);
        tx1.commit();
        session.close();
    }

    public void update(TownShip townShip){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(townShip);
        tx1.commit();
        session.close();
    }

    public void delete(TownShip townShip){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(townShip);
        tx1.commit();
        session.close();
    }
}
