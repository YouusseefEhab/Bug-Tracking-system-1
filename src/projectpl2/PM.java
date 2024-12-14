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
public class PM extends Employee {
    public static ArrayList<PM> PMsList = new ArrayList<>();
    PM(int ID, String username, String password)
    {
        super(ID, username, password);
        PM.PMsList.add(this);
    }
    
    @Override
    public String getPerformance()
    {
        return "No Performance Available for This Employee.\n";
    }
    
    public String getEmployeePerformance(int ID) throws InvalidIDException
    {
        Employee employee = Employee.getEmployee(ID);
            return employee.getPerformance();
    }
}
