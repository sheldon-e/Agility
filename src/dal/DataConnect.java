/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import classes.DB;
import classes.AgileLogger;
import classes.Todo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author sheldon
 */
public class DataConnect {

    public static final Logger LOGGER = Logger.getLogger(DataConnect.class.getName());
    ArrayList<Todo> todoList = new ArrayList();
    Todo todo;
    PreparedStatement prepStmt = null;
    ResultSet resltSt = null;
    Logger agility = AgileLogger.loggerHandler(LOGGER);

    /**
     * Data Connection Method
     */
    private Connection getConnect() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("configs/dbconfig.xml");
        DB db = (DB) applicationContext.getBean("dbcbean");
        try {
//            String host = "jdbc:postgresql://localhost:5432/agility";
//            String usr = "postgres";
//            String pwd = "8g8smJJ&pp";
//            Class.forName("org.postgresql.Driver");
              String host = db.getHost();
              String usr = db.getUsr();
              String pwd = db.getPwd();
              Class.forName(db.getDriver());
            return DriverManager.getConnection(host, usr, pwd);
        } catch (ClassNotFoundException ex) {
            agility.log(Level.SEVERE, "Data Connect driver not found.", ex);
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, "Unable to connect to database. Please check connection settings", ex);
        }
        return null;
    }

    /**
     * Accepts Todo and pushes it to the Database
     *
     * @param td
     * @return
     */
    public Boolean insertToDo(Todo td) {
        try {
            String insertToDo = "INSERT INTO public.goal (description,status,name,typeid,timestamp,id)" + "VALUES (?,?,?,?,?,?);";
            PreparedStatement ps = getConnect().prepareStatement("SELECT MAX(id) FROM public.goal;");
            ResultSet rs = ps.executeQuery();
            int nextid = 0;
            while (rs.next()) {
                nextid = rs.getInt("max") + 1;
            }
            prepStmt = getConnect().prepareStatement(insertToDo);
            prepStmt.setString(1, "TODO");
            prepStmt.setString(2, String.valueOf(td.getJotai()));
            prepStmt.setString(3, td.getName());
            prepStmt.setString(4, String.valueOf(td.getTypeid()));
            prepStmt.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
            prepStmt.setInt(6, nextid);
            prepStmt.execute();
            prepStmt.close();
            getConnect().close();
            JOptionPane.showMessageDialog(null, "ToDo Saved");
            return true;
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Insert Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (prepStmt != null) {
                    try {
                        prepStmt.close();
                    } catch (SQLException ex) {
                        agility.log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex, "Insert Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                getConnect().close();
            } catch (SQLException ex) {
                agility.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Insert Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    public Boolean updateToDo(Todo td) {
        try {
            String update = "UPDATE public.goal SET name = ? WHERE id = " + "'" + td.getId() + "'";
            prepStmt = getConnect().prepareStatement(update);
            prepStmt.setString(1, td.getName());
            prepStmt.executeUpdate();
            prepStmt.close();
            getConnect().close();
            JOptionPane.showMessageDialog(null, "ToDo Updated");
            return true;
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Update Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (prepStmt != null) {
                    try {
                        prepStmt.close();
                    } catch (SQLException ex) {
                        agility.log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex, "Update Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                getConnect().close();
            } catch (SQLException ex) {
                agility.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Update Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    public Boolean completeToDo(Todo td) {
        try {
            String update = "UPDATE public.goal SET status = 'c' WHERE id = " + "'" + td.getId() + "'";
            prepStmt = getConnect().prepareStatement(update);
            //prepStmt.setString(1, "c");
            prepStmt.executeUpdate();
            prepStmt.close();
            getConnect().close();
            JOptionPane.showMessageDialog(null, "ToDo Updated" + td.getId() +" " +td.getName());
            return true;
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error Updating TODO", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (prepStmt != null) {
                    try {
                        prepStmt.close();
                    } catch (SQLException ex) {
                        agility.log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex, "Error Updating TODO", JOptionPane.ERROR_MESSAGE);
                    }
                }
                getConnect().close();
            } catch (SQLException ex) {
                agility.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Error Updating TODO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }
    
        public Boolean completeToDo(String name) {
        try {
            String update = "UPDATE public.goal SET status = ? WHERE name = " + "'" + name + "'";
            prepStmt = getConnect().prepareStatement(update);
            prepStmt.setString(1, "c");
            prepStmt.executeUpdate();
            prepStmt.close();
            getConnect().close();
            JOptionPane.showMessageDialog(null, "ToDo Updated");
            return true;
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error Updating TODO", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (prepStmt != null) {
                    try {
                        prepStmt.close();
                    } catch (SQLException ex) {
                        agility.log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, ex, "Error Updating TODO", JOptionPane.ERROR_MESSAGE);
                    }
                }
                getConnect().close();
            } catch (SQLException ex) {
                agility.log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Error Updating TODO", JOptionPane.ERROR_MESSAGE);
            }
        }
        return false;
    }

    public Boolean deleteToDo(Todo td) {
        try {
            String delete = "delete from public.goal where id = ?";

            prepStmt = getConnect().prepareStatement(delete);
            prepStmt.setInt(1, td.getId());
            prepStmt.execute();
            prepStmt.close();
            getConnect().close();
            return true;
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error Deleting TODO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public Boolean deleteToDo(String name) {
        try {
            String delete = "delete from public.goal where name = ?";

            prepStmt = getConnect().prepareStatement(delete);
            prepStmt.setString(1, name);
            prepStmt.execute();
            prepStmt.close();
            getConnect().close();
            return true;
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error Deleting TODO", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public int recordCount(String stmt){
        int count =0;
        try {
            String get = stmt;
            prepStmt = getConnect().prepareStatement(get);
            resltSt = prepStmt.executeQuery();
            while (resltSt.next()){
                count = resltSt.getInt("count");
            }
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ResultSet getTodoList() {
        try {
            String get = "SELECT name FROM public.goal where typeid = 't' and status = 'o'";
            prepStmt = getConnect().prepareStatement(get);
            resltSt = prepStmt.executeQuery();
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
        }
        return resltSt;
    }
    
    public ArrayList<Todo> getToDoList() {
        try {
            String get = "SELECT * FROM public.goal where typeid = 't' and status = 'o'";
            prepStmt = getConnect().prepareStatement(get);
            resltSt = prepStmt.executeQuery();
            while (resltSt.next()) {
                Todo to = new Todo();
                to.setName(resltSt.getString("name"));
                to.setStatus((resltSt.getString("status").charAt(0)));
                todoList.add(to);
            }
            resltSt.close();
            prepStmt.close();
            getConnect().close();
        } catch (SQLException ex) {
            agility.log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepStmt != null) {
                    prepStmt.close();
                }
            } catch (SQLException ex) {
                agility.log(Level.SEVERE, null, ex);
            }
        }
        return todoList;
    }
}
