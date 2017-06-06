/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author sheldon
 */
@Entity
public class Goal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String name;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deadline;
    @Column(name="status")
    private char jotai;
    private char typeid;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name="timestamp")
    private Date created;
    
    @OneToMany(mappedBy="goal", cascade=CascadeType.ALL)
    private List<Task> task;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goal)) {
            return false;
        }
        Goal other = (Goal) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Goal[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

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
     * @return the state
     */
    public char getStatus() {
        return jotai;
    }

    /**
     * @param jotai the state to set
     * This method is used to set the status (Japanese jotai) of a goal. If you
     * are setting this from code please use the legal statuses: 
     * o => open; c => closed
     */
    public void setStatus(char jotai) {
        this.jotai = jotai;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * @return the task
     */
    public List<Task> getTask() {
        return task;
    }

    /**
     * @param task the task to set
     */
    public void setTask(List<Task> task) {
        this.task = task;
    }

    /**
     * @return the typeid
     */
    public char getTypeid() {
        return typeid;
    }

    /**
     * @param typeid the typeid to set
     * This method is used to set the type id of a goal. If you
     * are setting this from code please use the legal statuses: 
     * g => goal; t => todo
     */
    public void setTypeid(char typeid) {
        this.typeid = typeid;
    }
    
}
