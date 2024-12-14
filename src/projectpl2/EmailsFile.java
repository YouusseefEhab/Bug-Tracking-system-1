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
public class EmailsFile extends XYFile {
    EmailsFile(String filePath) throws IOException
    {
        super(filePath);
        createObjectsFromEmails();
    }
    
    private void createObjectsFromEmails()
    {
        Scanner reader = null;
        try
        {
            reader = new Scanner(super.getFile());
        }catch(FileNotFoundException ex){}
        if(reader.hasNext())
        {
            while(reader.hasNext())
            {
                try
                {
                    new Email(Employee.getEmployee(Integer.parseInt(reader.nextLine())),
                        Employee.getEmployee(Integer.parseInt(reader.nextLine())),
                        reader.nextLine());
                }catch(Exception ex){}   
            }
        }
    }
}
