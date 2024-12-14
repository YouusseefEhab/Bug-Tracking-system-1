/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectpl2;

import java.io.*;
import java.util.*;
import java.lang.*;

/**
 *
 * @author mena1
 */
public class ProjectPL2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AccountsFile accountsFile = null;
        BugsFile bugsFile = null;
        EmailsFile emailsFile = null;
        Employee loggedInEmployee = null;
        try
        {
            accountsFile = new AccountsFile("./Accounts.dat");
            bugsFile = new BugsFile("./Bugs.dat");
            emailsFile = new EmailsFile("./Emails.dat");
        }
        catch(IOException ex){}
        
        while(true)
        {
            System.out.print("Do you wish to login? ('y' / 'n'): ");
            if(!input.nextLine().equals("y"))
                break;
            
            while(true)
            {
                System.out.print("Enter Username: ");
                String loggedInUsername = input.nextLine();
                System.out.print("Enter Password: ");
                String loggedInPassword = input.nextLine();
                boolean found = false;
                for(Employee e : Employee.employeesList)
                {
                    if(e.getUsername().equals(loggedInUsername)
                            && e.checkPassword(loggedInPassword))
                    {
                        loggedInEmployee = e;
                        found = true;
                        break;
                    }
                }
                if(found)
                    break;
                System.out.println("Invalid Credentials");
            }

            while(true)
            {
                if(loggedInEmployee instanceof Admin admin)
                {
                    String op;
                    System.out.println(Menu.getAdminMenu());
                    op = input.nextLine();
                    
                    if(op.equals("1"))
                    {
                        while(true)
                        {
                            System.out.print("Enter Username: ");
                            String username = input.nextLine();
                            System.out.print("Enter Password: ");
                            String password = input.nextLine();
                            System.out.print("Enter Job: ");
                            String job = input.nextLine();

                            try
                            {
                                admin.addAccount(accountsFile.getFile(), job, username, password);
                                System.out.println(username + " added succesfully.");
                                break;
                            }
                            catch(Exception ex)
                            {
                                boolean again = false;
                                System.out.println(ex.getMessage());
                                System.out.println("To try again enter 'y': ");
                                again = input.nextLine().equals("y");
                                if(!again)
                                    break;
                            }
                        }
                    }
                    else if(op.equals("2"))
                    {
                        
                    }
                    else if(op.equals("3"))
                    {
                        
                    }
                    else if(op.equals("4"))
                    {
                        
                    }
                    else
                        break;
                }
                else if(loggedInEmployee instanceof Tester)
                {
                    String op;
                    System.out.println(Menu.getTesterMenu());
                    op = input.nextLine();

                    if(op.equals("1"))
                    {
                        System.out.print("Enter Bug Name: ");
                        String name = input.nextLine();
                        System.out.print("Enter Bug Type: ");
                        String type = input.nextLine();
                        System.out.print("Enter Bug Priority: ");
                        String priority = input.nextLine();
                        System.out.print("Enter Bug Level: ");
                        String level = input.nextLine();
                        System.out.print("Enter Project Name: ");
                        String projectName = input.nextLine();
                        System.out.print("Enter ID of Developer to be assigned this bug: ");
                        int ID;
                        Employee e = null;
                       
                        while(true)
                        {
                            try
                            {
                                ID = Integer.parseInt(input.nextLine());
                                e = Employee.getEmployee(ID);
                                break;
                            }
                            catch(InvalidIDException ex)
                            {
                                System.out.println(ex.getMessage());;
                                System.out.print("Enter ID of Developer to be assigned this bug: ");
                            }
                            catch(NumberFormatException ex)
                            {
                                System.out.println("Please Enter Number.");
                                System.out.print("Enter ID of Developer to be assigned this bug: ");
                            }
                        }
                            
                        
                        
                        while(!(e instanceof Developer));
                        {
                            System.out.println("This is Not a Developer's ID.");
                            System.out.print("Enter ID of Developer to be assigned this bug: ");
                            ID = Integer.parseInt(input.nextLine());
                        }
                        Developer assignedDev = (Developer)e;
                        
                        Bug openedBug = ((Tester)loggedInEmployee).openBug(bugsFile.getFile(), emailsFile.getFile(), name, type, priority, level, projectName, assignedDev);
                        
                        System.out.println("Successfully Opened Bug:- \n\n" + openedBug.toString() + "\n\n");
                    }
                    else if(op.equals("2"))
                    {
                        
                    }
                    else if(op.equals("3"))
                    {
                        
                    }
                    else if(op.equals("4"))
                    {
                        
                    }
                    else
                        break;
                }
                else if(loggedInEmployee instanceof Developer)
                {
                    String op;
                    System.out.println(Menu.getDeveloperMenu());
                    op = input.nextLine();

                    if(op.equals("1"))
                    {
                        for(Bug bug : Bug.bugsList)
                            if(bug.getAssignedDev().getID() == loggedInEmployee.getID())
                                System.out.println(bug.toString() + "\n");
                    }
                    else if(op.equals("2"))
                    {
                        
                    }
                    else if(op.equals("3"))
                    {
                        
                    }
                    else
                        break;
                }
                else if(loggedInEmployee instanceof PM)
                {
                    String op;
                    System.out.println(Menu.getPMMenu());
                    op = input.nextLine();

                    if(op.equals("1"))
                    {
                        System.out.print("Enter Employee ID: ");
                        int ID;
                        while(true)
                        {
                            try
                            {
                                ID = Integer.parseInt(input.nextLine());
                                System.out.println(((PM) loggedInEmployee).getEmployeePerformance(ID));
                                break;
                            }
                            catch(InvalidIDException ex)
                            {
                                System.out.println(ex.getMessage());
                                System.out.print("Enter Employee ID: ");
                            }
                            catch(NumberFormatException ex)
                            {
                                System.out.println("Please Enter Number.");
                                System.out.print("Enter Employee ID: ");
                            }
                        }
                    }
                    else if(op.equals("2"))
                    {
                        
                    }
                    else if(op.equals("3"))
                    {
                        
                    }
                    else
                        break;
                }
            }
        }
    } 
}
