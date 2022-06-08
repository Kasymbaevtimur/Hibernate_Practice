package Peaksoft.first;

import Peaksoft.HibernateUtil.HibernateUtil;
import Peaksoft.Model;
import Peaksoft.first.entity.Student;
import Peaksoft.hibernateService.HibernateService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.management.Query;
import java.util.List;

public class StudentImple implements HibernateService {

    @Override
    public  void create(Model model) {
        Session session=HibernateUtil.getSessionFactory().openSession();
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
             Model model = session.get(Student.class, id);
            session.getTransaction().commit();
            session.close();

        return model;
    }


    @Override
    public List<Model> read() {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            List<Model> students = session.createQuery(
                    "FROM Student").getResultList();
                    session.getTransaction().commit();
            session.close();
            System.out.println("Finded " + students.size() + " student");
            return students;



        }

        public  void update(Long id,String name,String lastName,int age){
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            Student student= session.get(Student.class, id);
            student.setName(name);
            student.setLastName(lastName);
            student.setAge(age);
            session.getTransaction().commit();
            session.close();
            System.out.println("Successfully updated!");

        }


         @Override
        public  void deleteById(Long id){
            SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            Student  student=session.get(Student.class,id);
            session.delete(student);
            session.getTransaction().commit();
            session.close();
        }


    public  void deleteAll() {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.createQuery("DELETE FROM Student").executeUpdate();
                session.getTransaction().commit();
        session.close();
         System.out.println("Successfully deleted all datas in Student");
    }


}






