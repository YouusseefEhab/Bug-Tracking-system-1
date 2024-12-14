/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpl2;

import java.io.*;
import java.util.*;

/**
 *
 * @author mena1
 */
public class Tester extends Employee {
    public static ArrayList<Tester> testersList = new ArrayList<>();
    Tester(int ID, String username, String password)
    {
        super(ID, username, password);
        Tester.testersList.add(this);
    }
    
    public Bug openBug(File bugsFile, File emailsFile, String name, String type, String priority, String level, String projectName, Developer assignedDev)
    {
        Bug bug = new Bug(name, type, priority, level, projectName, new Date(), "Open", this, assignedDev);
        addBugToFile(bug, bugsFile);
        String emailContent = "New bug found in project " + bug.getProjectName() + " was assigned to you.";
        Email email = new Email(this, assignedDev, emailContent);
        addEmailToFile(email, emailsFile);
        return bug;
        
    }
    
    private void addBugToFile(Bug bug, File file)
    {
        try
        {
            FileWriter fw = new FileWriter(file, true);
            fw.append(bug.getName() + "\n" + 
                      bug.getType() + "\n" +
                      bug.getPriority() + "\n" +
                      bug.getLevel() + "\n" +
                      bug.getProjectName() + "\n" +
                      bug.getDateCreated().getTime() + "\n" +
                      bug.getStatus() + "\n" +
                      bug.getCreator().getID() + "\n" +
                      bug.getAssignedDev().getID() + "\n");
            fw.close();
        }catch(Exception ex){}
    }
    
    private void addEmailToFile(Email email, File file)
    {
        try
        {
            FileWriter fw = new FileWriter(file, true);
            fw.append(email.getSender().getUsername() + "\n" + 
                      email.getReceiver().getUsername() + "\n" +
                      email.getContent() + "\n");
            fw.close();
        }catch(Exception ex){}
    }
    
    @Override
    public String getPerformance() {
        int numOfBugsCreated = 0;
        for(Bug bug : Bug.bugsList)
            if(bug.getCreator().getID() == super.getID())
                numOfBugsCreated++;
        
        float participation = ((float)numOfBugsCreated / (float)Bug.bugsList.size()) * 100;
        
        return "Tester: " + super.getUsername() + "\n" +
                "Total Bugs Created: " + Bug.bugsList.size() + "\n" +
                super.getUsername() + "'s Created Bugs: " + numOfBugsCreated + "\n" +
                super.getUsername() + "'s Participation in Creating Bugs: " + participation + "%" + "\n";
    }
}
