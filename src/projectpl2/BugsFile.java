/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpl2;

import java.io.*;
import java.util.*;
import java.text.*;
/**
 *
 * @author mena1
 */
public class BugsFile extends XYFile {
    
    BugsFile(String filePath) throws IOException
    {
        super(filePath);
        createObjectsFromBugs();
    }
    
    private void createObjectsFromBugs()
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
                    new Bug(reader.nextLine(),
                    reader.nextLine(),
                    reader.nextLine(), 
                    reader.nextLine(), 
                    reader.nextLine(), 
                    new Date(Long.parseLong(reader.nextLine())), 
                    reader.nextLine(), 
                    (Tester)Employee.getEmployee(Integer.parseInt(reader.nextLine())), 
                    (Developer)Employee.getEmployee(Integer.parseInt(reader.nextLine())));
                }catch(Exception ex){}
            }
        }
    }
}
