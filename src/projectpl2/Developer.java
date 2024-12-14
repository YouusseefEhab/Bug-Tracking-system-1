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
public class Developer extends Employee {
    public static ArrayList<Developer> developersList = new ArrayList<>();
    Developer(int ID, String username, String password)
    {
        super(ID, username, password);
        Developer.developersList.add(this);
    }
    
    public ArrayList<Bug> getAssignedBugs()
    {
        ArrayList<Bug> myBugs = new ArrayList<>();
        
        for(Bug bug : Bug.bugsList)
            if(bug.getAssignedDev().getID() == super.getID())
                myBugs.add(bug);
        
        return myBugs;
    }
    
    @Override
    public String getPerformance() {
        int numOfBugsInMyCode = 0;
        for(Bug bug : Bug.bugsList)
            if(bug.getAssignedDev().getID() == super.getID())
                numOfBugsInMyCode++;
        
        float participation = ((float)numOfBugsInMyCode / (float)Bug.bugsList.size()) * 100;
        
        return "Developer: " + super.getUsername() + "\n" +
                "Total Bugs Created: " + Bug.bugsList.size() + "\n" +
                super.getUsername() + "'s Code Bugs: " + numOfBugsInMyCode + "\n" +
                super.getUsername() + "'s Participation in Causing Bugs: " + participation + "%" + "\n";
    }
}
