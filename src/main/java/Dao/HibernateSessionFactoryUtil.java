package Dao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
//    private static SessionFactory sessionFactory;
//
//    private Dao.HibernateSessionFactoryUtil(){}
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null){
//            try {
//                Configuration configuration = new Configuration().configure();
//                configuration.addAnnotatedClass(Entities.Child.class);
//                configuration.addAnnotatedClass(Entities.School.class);
//                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//                sessionFactory = configuration.buildSessionFactory(builder.build());
//            } catch (Exception e){
//                e.getMessage();
//            }
//        }
//        return sessionFactory;
//    }
    private static final SessionFactory sessionFactory;

    static {
        try {

            Configuration config = new Configuration();
            sessionFactory = config.configure().buildSessionFactory();
        } catch (Throwable e) {
            System.err.println("Error in creating SessionFactory object."
                    + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
