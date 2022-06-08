package Peaksoft.fourth;

import Peaksoft.HibernateUtil.HibernateUtil;
import Peaksoft.Model;
import Peaksoft.hibernateService.HibernateService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class FootballPlayerServiceImple implements HibernateService {

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
        Model model = session.get(FootballPlayer.class, id);
        session.getTransaction().commit();
        session.close();

        return model;
    }


    @Override
    public List<Model> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> footballer = session.createQuery(" FROM FootballPlayer ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + footballer.size() + " footballer");
        return footballer;


    }

    public void update(Long id, String name, String lastName, int age, String team) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FootballPlayer footballer = session.get(FootballPlayer.class, id);
        footballer.setName(name);
        footballer.setLastName(lastName);
        footballer.setAge(age);
        footballer.setTeam(team);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");

    }


    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        FootballPlayer footballer= session.get(FootballPlayer.class, id);
        session.delete(footballer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM FootballPlayer ").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in FootballPlayer");
    }


}


