package Peaksoft.HibernateUtil;

import Peaksoft.first.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
        SessionFactory sessionFactory=buildSessionFactory();
        private static SessionFactory buildSessionFactory(){
           SessionFactory sessionFactory= new Configuration()
                   .configure("hibernate.cfg.xml")
                   .buildSessionFactory();

                return sessionFactory;
        }
         public static SessionFactory getSessionFactory(){
                return buildSessionFactory();
         }
         public static void close(){
                buildSessionFactory().close();
         }
        }

