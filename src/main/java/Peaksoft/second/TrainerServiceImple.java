package Peaksoft.second;

import Peaksoft.HibernateUtil.HibernateUtil;
import Peaksoft.Model;
import Peaksoft.hibernateService.HibernateService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TrainerServiceImple implements HibernateService {

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
        Model model = session.get(Trainer.class, id);
        session.getTransaction().commit();
        session.close();

        return model;
    }


    @Override
    public List<Model> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> trainer = session.createQuery(
                "FROM Trainer ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + trainer.size() + " student");
        return trainer;


    }

    public void update(Long id, String name, String lastName, int age, String sport, String team) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Trainer trainer = session.get(Trainer.class, id);
        trainer.setName(name);
        trainer.setLastName(lastName);
        trainer.setAge(age);
        trainer.setSport(sport);
        trainer.setTeam(team);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");

    }


    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Trainer trainer = session.get(Trainer.class, id);
        session.delete(trainer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Trainer").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in Trainer");
    }


}


