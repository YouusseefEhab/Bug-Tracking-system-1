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
public class AccountsFile extends XYFile {
    AccountsFile(String filePath) throws IOException
    {
        super(filePath);
        createObjectsFromAccounts();
    }
    
    private void createObjectsFromAccounts()
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
                String job = reader.nextLine();
                if(job.equals("Admin"))
                {
                    new Admin(Integer.parseInt(reader.nextLine()), reader.nextLine(), reader.nextLine());
                }
                else if(job.equals("Tester"))
                {
                    new Tester(Integer.parseInt(reader.nextLine()), reader.nextLine(), reader.nextLine());
                }
                else if(job.equals("Developer"))
                {
                    new Developer(Integer.parseInt(reader.nextLine()), reader.nextLine(), reader.nextLine());
                }
                else if(job.equals("PM"))
                {
                    new PM(Integer.parseInt(reader.nextLine()), reader.nextLine(), reader.nextLine());
                }
            }
        }
    }
}
