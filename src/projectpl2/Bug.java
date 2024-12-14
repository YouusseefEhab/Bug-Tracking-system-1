/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpl2;

import java.util.*;

/**
 *
 * @author mena1
 */
public class Bug {
    public static ArrayList<Bug> bugsList = new ArrayList<>();
    private int ID;
    private String name;
    private String type;
    private String priority;
    private String level;
    private String projectName;
    private Date dateCreated;
    private String status;
    private Tester creator;
    private Developer assignedDev;
    
    Bug(String name, String type, String priority, String level, String projectName, Date dateCreated, String status, Tester creator, Developer assignedDev)
    {
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.level = level;
        this.projectName = projectName;
        this.dateCreated = dateCreated;
        this.status = status;
        this.creator = creator;
        this.assignedDev = assignedDev;
        this.ID = Bug.bugsList.size() + 1;
        Bug.bugsList.add(this);
    }
    
    public int getID()
    {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getLevel() {
        return this.level;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public String getStatus() {
        return this.status;
    }
    
    public Tester getCreator() {
        return creator;
    }

    public Developer getAssignedDev() {
        return assignedDev;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAssignedDev(Developer assignedDev) {
        this.assignedDev = assignedDev;
    }

    @Override
    public String toString() {
        return "Bug: " + this.getName() + "\n" + 
                "ID: " + this.getID() + "\n" +
                "Type: " + this.getType() + "\n" +
                "Priority: " + this.getPriority() + "\n" +
                "Level: " + this.getLevel() + "\n" +
                "Project Name: " + this.getProjectName() + "\n" +
                "Date Created: " + this.getDateCreated() + "\n" +
                "Creator: " + this.getCreator().getUsername() + "\n" +
                "Assigned Developer: " + this.getAssignedDev().getUsername() + "\n" +
                "Status: " + this.getStatus() + "\n";
    }
}
