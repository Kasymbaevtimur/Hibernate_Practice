package Peaksoft.hibernateService;

import Peaksoft.Model;

import java.util.List;

public interface HibernateService {

     void create(Model model);
     Model getById(Long id);
     List<Model>read();
     void deleteById(Long id);
     void deleteAll();



}
