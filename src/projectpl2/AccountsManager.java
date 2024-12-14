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
public class AccountsManager {
    private int numOfAccounts;
    private ArrayList<String> IDs = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<String> passwords = new ArrayList<>();
    private ArrayList<String> jobs = new ArrayList<>();
    public String accountsFilePath;
    private File accounts = null;
    private Scanner reader = null;
    private FileWriter writer = null;
    private int loggedInID;
    private int userListIdx;
    
    AccountsManager(String username, String password) throws InvalidCredentialsException
    {
        this.accountsFilePath = "./Accounts.dat";
        try {
            this.accounts = new File(this.accountsFilePath);
            this.accounts.createNewFile();
            this.reader = new Scanner(accounts);
        } catch (IOException ex) {}

        if(reader.hasNext())
        {
            while(reader.hasNext())
            {
                this.IDs.add(reader.nextLine());
                this.usernames.add(reader.nextLine());
                this.passwords.add(reader.nextLine());
                this.jobs.add(reader.nextLine());
            }
        }
        
        this.numOfAccounts = this.usernames.size();
        
        int resultIdx = -1;
        for(int i = 0; i < this.numOfAccounts; i++)
        {
            if(username.equals(this.usernames.get(i)) && password.equals(this.passwords.get(i)))
            {
                resultIdx = i;
                break;
            }
        }
        
        if(resultIdx == -1)
            throw new InvalidCredentialsException("Invalid Credentials.");
        
        this.loggedInID = Integer.parseInt(this.IDs.get(resultIdx));
        this.userListIdx = resultIdx;
    }
    
    public int getNumOfAccounts()
    {
        return this.numOfAccounts;
    }
    
    public int getID()
    {
        return this.loggedInID;
    }
    
    public String getJob()
    {
        return this.jobs.get(this.userListIdx);
    }
    
    private void addID()
    {
        this.IDs.add(String.valueOf(++this.numOfAccounts));
    }
    
    private void addUsername(String username) throws InvalidCredentialsException
    {
        if(username.contains(" "))
            throw new InvalidCredentialsException("Username can't have spaces.");
        
        if(username.length() < 1)
            throw new InvalidCredentialsException("Username can't be empty.");
        
        if(this.numOfAccounts > 0)
            for(int i = 0; i < this.numOfAccounts - 1; i++)
                if(this.usernames.get(i).equals(username))
                    throw new InvalidCredentialsException("Username Already Taken.");
        
        this.usernames.add(username);
    }
    
    private void addPassword(String password) throws InvalidCredentialsException
    {
        if(password.contains(" "))
            throw new InvalidCredentialsException("Password can't have spaces.");
        
        if(password.length() < 8)
            throw new InvalidCredentialsException("Password can't be less than 8 characters.");
        
        this.passwords.add(password);
    }
    
    private void addJob(String job) throws InvalidCredentialsException
    {
        if(!job.equals("Developer") && !job.equals("Tester") && !job.equals("PM") && !job.equals("Admin"))
            throw new InvalidCredentialsException("Jobs: Developer, Tester, PM, Admin.");
        
        this.jobs.add(job);
    }
    
    public void addAccount(String username, String password, String job) throws InvalidCredentialsException
    {
        try
        {
            this.writer = new FileWriter(accounts);
        }
        catch(IOException ex){}
        try
        {
            addID();
            addUsername(username);
            addPassword(password);
            addJob(job);
        }
        catch(Exception ex)
        {
            this.numOfAccounts--;
            throw ex;
        }
        finally
        {
            try
            {
                for(int i = 0; i < this.numOfAccounts; i++)
                {
                    this.writer.append(this.IDs.get(i) + "\n");
                    this.writer.append(this.usernames.get(i) + "\n");
                    this.writer.append(this.passwords.get(i) + "\n");
                    this.writer.append(this.jobs.get(i) + "\n");
                }
                this.writer.close();
            }
            catch(IOException ex){}
        }
    }
}