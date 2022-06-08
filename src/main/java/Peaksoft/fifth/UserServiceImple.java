package Peaksoft.fifth;

import Peaksoft.HibernateUtil.HibernateUtil;
import Peaksoft.Model;
import Peaksoft.first.entity.Student;
import Peaksoft.hibernateService.HibernateService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserServiceImple implements HibernateService {
    @Override
    public  void create(Model model) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(model);
        session.getTransaction().commit();
        session.close();
        System.out.println("Added succesfully"+ model);
    }


    @Override
    public Model getById(Long id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Model model = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();

        return model;
    }


    @Override
    public List<Model> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Model> user = session.createQuery(
                "FROM User").getResultList();
        session.getTransaction().commit();
        session.close();
        System.out.println("Finded " + user.size() + " user");
        return user;



    }

    public  void update(Long id,String name,int age){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        User user= session.get(User.class, id);
        user.setName(name);
        user.setAge(age);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated!");

    }


    @Override
    public  void deleteById(Long id){
        SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }


    public  void deleteAll() {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM User").executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all datas in User");
    }


}
