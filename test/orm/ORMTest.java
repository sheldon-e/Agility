/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orm;

import entities.Goal;
import entities.Task;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sheldon
 */
public class ORMTest {
    public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AgilityPU");
        EntityManager em = emf.createEntityManager();
        
        Goal g = new Goal();
        Task t = new Task();
        Task tt = new Task();
        List<Task> td = new ArrayList();
        
        g.setName("Fill the thing over there");
        g.setDescription("Get water and fill it all the way up like nobody's business");
        g.setStatus('o');
        g.setTypeid('g');
        g.setDeadline(java.sql.Date.valueOf(LocalDate.parse("2017-05-06")));
        g.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
        t.setName("fill the pail till it overflowss");
        t.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
        t.setStatus('c');
        t.setGoal(g);
        tt.setName("empty the pail into whatevers it is you're filling");
        tt.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
        tt.setStatus('c');
        tt.setGoal(g);
        td.add(t);
        td.add(tt);
        g.setTask(td);
             
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
    }
}
