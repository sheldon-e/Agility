/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author sheldon
 */
public class Task {
    private String name;
    private String description;
    private char jotai; 

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
     * @return the jotai
     */
    public char getJotai() {
        return jotai;
    }

    /**
     * @param jotai the jotai to set
     */
    public void setJotai(char jotai) {
        this.jotai = jotai;
    }
    
}
