/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DELL
 */
public class EmployeeTable {
    public static void insertEmployee ( Employee stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(stu);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateEmployee( Employee stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6PU");
        EntityManager em = emf.createEntityManager();
         Employee fromDb = em.find( Employee.class, stu.getID());
        fromDb.setName(stu.getName());
        fromDb.setGPA(stu.getGPA());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
     public static void removeEmployee( Employee stu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ex6PU");
        EntityManager em = emf.createEntityManager();
         Employee fromDb = em.find( Employee.class, stu.getID());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
}
}
