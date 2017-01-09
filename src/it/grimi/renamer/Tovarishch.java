/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.grimi.renamer;

import java.awt.TextArea;
import java.io.File;

/**
 *
 * @author agrimandi
 */
public class Tovarishch
{
    public void rename(boolean mode, String path, String stringToLookFor, String stringSubstitute, TextArea outputArea)
    {
        if (!mode)
        {
            File f = new File(path);
            File[] files = f.listFiles();

            for (File file : files)
            {
                String fileName = file.getName();

                if (fileName.contains(stringToLookFor))
                {
                    fileName = fileName.substring(stringToLookFor.length());

                    File newFile = new File(path + "\\" + stringSubstitute + fileName);
                    boolean ok = file.renameTo(newFile);

                    if (ok)
                    {
                        outputArea.append("OK - Old: " + fileName + " New: " + newFile.getName());

                    } else
                    {
                        outputArea.append("NOK - Filename: " + fileName + " [Check file permission or if it exists]");

                    }
                }
            }
        } else
        {
            File f = new File(path);
            File[] files = f.listFiles();

            for (File file : files)
            {
                String fileName = file.getName();

                if (fileName.contains(stringToLookFor))
                {
                    fileName = fileName.substring(stringToLookFor.length());

                    File newFile = new File(path + "\\" + fileName);
                    boolean ok = file.renameTo(newFile);

                    if (ok)
                    {
                        outputArea.append("OK - Old: " + fileName + " New: " + newFile.getName());

                    } else
                    {
                        outputArea.append("NOK - Filename: " + fileName + " [Check file permission or if it exists]");

                    }
                }
            }
        }

    }
}
