/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc;

import classes.Todo;
import dal.DataConnect;

/**
 *
 * @author sheldon
 */
public class TraditionalConnectTest {
    public static void main(String args[]) {
        Todo t = new Todo();
        DataConnect dc = new DataConnect();
        
        t.setName("Throw something");
        t.setStatus('o');
        t.setTypeid('t');
        dc.insertToDo(t);
    }
}
