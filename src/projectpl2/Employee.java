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
public abstract class Employee {
    public static ArrayList<Employee> employeesList = new ArrayList<>();
    private int ID;
    private String username;
    private String password;
    
    Employee(int ID, String username, String password)
    {
        this.ID = ID;
        this.username = username;
        this.password = password;
        Employee.employeesList.add(this);
    }
    
    public int getID()
    {
        return this.ID;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public boolean checkPassword(String password)
    {
        return this.password.equals(password);
    }
    
    public static Employee getEmployee(int ID) throws InvalidIDException
    {
        for(Employee e: Employee.employeesList)
            if(e.getID() == ID)
                return e;
        throw new InvalidIDException("Invalid ID");
    }
    
    public abstract String getPerformance();
}
