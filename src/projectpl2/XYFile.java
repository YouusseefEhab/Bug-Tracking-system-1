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
public class XYFile {
    private String filePath;
    private File file;
    
    XYFile(String filePath) throws IOException
    {
        this.filePath = filePath;
        this.file = new File(this.filePath);
        this.file.createNewFile();
    }
    
    public String getPath()
    {
        return this.filePath;
    }
    
    public File getFile()
    {
        return this.file;
    }
}
