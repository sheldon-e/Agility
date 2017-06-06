/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sheldon
 */
public class TodoTest {
    
    public TodoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Todo.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Todo instance = new Todo();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Todo.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Todo instance = new Todo();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Todo.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Todo instance = new Todo();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Todo.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Todo instance = new Todo();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Todo.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Todo instance = new Todo();
        char expResult = ' ';
        char result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Todo.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        char status = ' ';
        Todo instance = new Todo();
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreated method, of class Todo.
     */
    @Test
    public void testGetCreated() {
        System.out.println("getCreated");
        Todo instance = new Todo();
        Date expResult = null;
        Date result = instance.getCreated();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreated method, of class Todo.
     */
    @Test
    public void testSetCreated_0args() {
        System.out.println("setCreated");
        Todo instance = new Todo();
        instance.setCreated();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJotai method, of class Todo.
     */
    @Test
    public void testGetJotai() {
        System.out.println("getJotai");
        Todo instance = new Todo();
        char expResult = ' ';
        char result = instance.getJotai();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJotai method, of class Todo.
     */
    @Test
    public void testSetJotai() {
        System.out.println("setJotai");
        char jotai = ' ';
        Todo instance = new Todo();
        instance.setJotai(jotai);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreated method, of class Todo.
     */
    @Test
    public void testSetCreated_Date() {
        System.out.println("setCreated");
        Date created = null;
        Todo instance = new Todo();
        instance.setCreated(created);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Todo.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Todo instance = new Todo();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Todo.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Todo instance = new Todo();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeadline method, of class Todo.
     */
    @Test
    public void testGetDeadline() {
        System.out.println("getDeadline");
        Todo instance = new Todo();
        Date expResult = null;
        Date result = instance.getDeadline();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeadline method, of class Todo.
     */
    @Test
    public void testSetDeadline() {
        System.out.println("setDeadline");
        Date deadline = null;
        Todo instance = new Todo();
        instance.setDeadline(deadline);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTypeid method, of class Todo.
     */
    @Test
    public void testGetTypeid() {
        System.out.println("getTypeid");
        Todo instance = new Todo();
        char expResult = ' ';
        char result = instance.getTypeid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTypeid method, of class Todo.
     */
    @Test
    public void testSetTypeid() {
        System.out.println("setTypeid");
        char typeid = ' ';
        Todo instance = new Todo();
        instance.setTypeid(typeid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
