package Peaksoft.seventh;

import Peaksoft.HibernateUtil.HibernateUtil;
import Peaksoft.Model;
import Peaksoft.hibernateService.HibernateService;
import Peaksoft.sixth.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CityServiceImple implements HibernateService {

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
        City city = session.get(City.class, id);
        session.getTransaction().commit();
        session.close();

        return city;
    }


    @Override
    public List<Model> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> city = session.createQuery(
                "FROM City ").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + city.size() + " city");
        return city;


    }

    public void update(Long id, String name, int population, String square) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        City city = session.get(City.class, id);
        city.setName(name);
        city.setPopulation(population);
        city.setSquare(square);


        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");

    }


    @Override
    public void deleteById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        City city = session.get(City.class, id);
        session.delete(city);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM City ").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in City");
    }


}
