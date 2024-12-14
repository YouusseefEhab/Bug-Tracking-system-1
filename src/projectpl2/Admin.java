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
public class Admin extends Employee {
    public static ArrayList<Admin> adminsList = new ArrayList<>();
    Admin(int ID, String username, String password)
    {
        super(ID, username, password);
        Admin.adminsList.add(this);
    }
    
    private void validateUsername(String username, File file) throws IOException, InvalidCredentialsException
    {
        if(username.length() < 1)
            throw new InvalidCredentialsException("Username can't be empty.");
        
        if(username.contains(" "))
            throw new InvalidCredentialsException("Username can't have spaces.");
        
        for(Employee e : Employee.employeesList)
        {
            if(e.getUsername().equals(username))
                throw new InvalidCredentialsException("Username already taken.");
        }
    }
    
    private void validatePassword(String password) throws InvalidCredentialsException
    {
        if(password.length() < 8)
            throw new InvalidCredentialsException("Password has to be atleast 8 characters.");
        
        if(password.contains(" "))
            throw new InvalidCredentialsException("Password can't have spaces.");
    }
    
    public Employee addAccount(File file, String job, String username, String password) throws IOException, InvalidCredentialsException
    {
        validateUsername(username, file);
        validatePassword(password);
            
        if(job.equals("Admin"))
        {
            Admin admin = new Admin(Employee.employeesList.get(Employee.employeesList.size() - 1).getID() + 1, username, password);
            FileWriter fw = new FileWriter(file, true);
            fw.write("Admin\n" + admin.getID() + "\n" + admin.getUsername() + "\n" + password + "\n");
            fw.close();
            return admin;
        }
        else if(job.equals("Tester"))
        {
            Tester tester = new Tester(Employee.employeesList.get(Employee.employeesList.size() - 1).getID() + 1, username, password);
            FileWriter fw = new FileWriter(file, true);
            fw.write("Tester\n" + tester.getID() + "\n" + tester.getUsername() + "\n" + password + "\n");
            fw.close();
            return tester;
        }
        else if(job.equals("Developer"))
        {
            Developer dev = new Developer(Employee.employeesList.get(Employee.employeesList.size() - 1).getID() + 1, username, password);
            FileWriter fw = new FileWriter(file, true);
            fw.write("Developer\n" + dev.getID() + "\n" + dev.getUsername() + "\n" + password + "\n");
            fw.close();
            return dev;
        }
        else if(job.equals("PM"))
        {
            PM pm = new PM(Employee.employeesList.get(Employee.employeesList.size() - 1).getID() + 1, username, password);
            FileWriter fw = new FileWriter(file, true);
            fw.write("PM\n" + pm.getID() + "\n" + pm.getUsername() + "\n" + password + "\n");
            fw.close();
            return pm;
        }
        else
        {
            throw new InvalidCredentialsException("Jobs: 'Admin'/'Tester'/'Developer'/'PM'.");
        }
    }
    
    @Override
    public String getPerformance()
    {
        return "No Performance Available for This Employee.\n";
    }
}
