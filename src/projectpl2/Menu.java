/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpl2;


/**
 *
 * @author mena1
 */
public class Menu {
    public static String getAdminMenu()
    {
        return """
               1) Add Account
               2) Update Account
               3) Remove Account
               4) See All Bugs
               5) Exit
               Select an option ('1' / '2' / '3' / '4' / '5'): 
               """;
    }
    
    public static String getTesterMenu()
    {
        return """
               1) Open Bug
               2) My Open Bugs
               3) My Closed Bugs
               4) My Emails
               5) Exit
               Select an option ('1' / '2' / '3' / '4' / '5'): 
               """;
    }
    
    public static String getDeveloperMenu()
    {
        return """
               1) View Assigned Bugs
               2) Close Bug
               3) My Emails
               4) Exit
               Select an option ('1' / '2' / '3' / '4'): 
               """;
    }
    
    public static String getPMMenu()
    {
        return """
               1) See Employee Performance
               2) See Open Bugs
               3) See Closed Bugs
               4) Exit
               Select an option ('1' / '2' / '3' / '4'): 
               """;
    }
}
