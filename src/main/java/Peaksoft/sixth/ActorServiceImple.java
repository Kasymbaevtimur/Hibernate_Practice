package Peaksoft.sixth;

import Peaksoft.HibernateUtil.HibernateUtil;
import Peaksoft.Model;
import Peaksoft.hibernateService.HibernateService;
import Peaksoft.second.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class ActorServiceImple implements HibernateService {

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
        Actor actor = session.get(Actor.class, id);
        session.getTransaction().commit();
        session.close();

        return actor;
    }


    @Override
    public List<Model> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> actor = session.createQuery(
                "FROM Actor ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + actor.size() + " actor");
        return actor;


    }

    public void update(Long id, String name, String lastName, int age, String film) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Actor actor = session.get(Actor.class, id);
        actor.setName(name);
        actor.setLastName(lastName);
        actor.setAge(age);
        actor.setFilm(film);

        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");

    }


    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Actor actor = session.get(Actor.class, id);
        session.delete(actor);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Actor").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Actor");
    }


}

