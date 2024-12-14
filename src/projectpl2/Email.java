/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpl2;

import java.util.*;
import java.io.*;

/**
 *
 * @author mena1
 */
public class Email {
    public static ArrayList<Email> emailsList = new ArrayList<>();
    private Employee sender;
    private Employee receiver;
    private String content;

    public Email(Employee sender, Employee receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        Email.emailsList.add(this);
    }

    public Employee getSender() {
        return sender;
    }

    public Employee getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }
}
