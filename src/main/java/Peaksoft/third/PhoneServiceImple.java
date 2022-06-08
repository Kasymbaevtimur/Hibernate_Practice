package Peaksoft.third;

import Peaksoft.HibernateUtil.HibernateUtil;
import Peaksoft.Model;
import Peaksoft.hibernateService.HibernateService;
import Peaksoft.second.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PhoneServiceImple implements HibernateService {

    @Override
    public void create(Model model) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added succesfully" + model);
    }


    @Override
    public Model getById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Model model = session.get(Phone.class, id);
        session.getTransaction().commit();
        session.close();

        return model;
    }


    @Override
    public List<Model> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> phone = session.createQuery(" FROM Phone").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + phone.size() + " phone");
        return phone;


    }

    public void update(Long id, String name, String company, int price) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        phone.setName(name);
        phone.setCompany(company);
        phone.setPrice(price);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");

    }


    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        session.delete(phone);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Phone").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Phone");
    }


}


