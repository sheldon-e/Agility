/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author sheldon
 */
public class Todo extends Task{
    private int id;
    //private String name;
    //private char jotai;
    private char typeid;
    private Date created;
    //private String description;
    private Date deadline;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

//    /**
//     * @return the name
//     */
//    public String getName() {
//        return name;
//    }
//
//    /**
//     * @param name the name to set
//     */
//    public void setName(String name) {
//        this.name = name;
//    }

    /**
     * @return the status
     */
    public char getStatus() {
        return getJotai();
    }

    /**
     * @param status the status to set
     */
    public void setStatus(char status) {
        this.setJotai(status);
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     */
    public void setCreated() {
        this.setCreated(Date.from(Instant.MIN));
    }

//    /**
//     * @return the jotai
//     */
//    public char getJotai() {
//        return jotai;
//    }
//
//    /**
//     * @param jotai the jotai to set
//     */
//    public void setJotai(char jotai) {
//        this.jotai = jotai;
//    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

//    /**
//     * @return the description
//     */
//    public String getDescription() {
//        return description;
//    }
//
//    /**
//     * @param description the description to set
//     */
//    public void setDescription(String description) {
//        this.description = description;
//    }

    /**
     * @return the deadline
     */
    public Date getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the typeid
     */
    public char getTypeid() {
        return typeid;
    }

    /**
     * @param typeid the typeid to set
     */
    public void setTypeid(char typeid) {
        this.typeid = typeid;
    }
}
