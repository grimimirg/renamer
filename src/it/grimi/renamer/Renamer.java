/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.grimi.renamer;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author agrimandi
 */
public class Renamer
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        final JFrame window = new JFrame("Files Renamer");
        window.setSize(new Dimension(475, 420));
        window.setLocation(100, 100);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final Label pathLabel = new Label("Path: ");
        pathLabel.setBounds(10, 10, 40, 25);

        final TextField pathField = new TextField();
        pathField.setBounds(50, 10, 300, 25);

        final Label findLabel = new Label("Find: ");
        findLabel.setBounds(10, 40, 40, 25);

        final TextField findField = new TextField();
        findField.setBounds(50, 40, 120, 25);

        final Label subsLabel = new Label("Replace: ");
        subsLabel.setBounds(170, 40, 50, 25);

        final TextField subsField = new TextField();
        subsField.setBounds(230, 40, 120, 25);

        final JCheckBox removeCheck = new JCheckBox("Remove");
        removeCheck.setSelected(false);
        removeCheck.setBounds(360, 45, 100, 15);

        final TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setBounds(10, 75, 450, 270);

        final Button goButton = new Button("Go");
        goButton.setBounds(10, 360, 100, 25);

        Button chiudiButton = new Button("Exit");
        chiudiButton.setBounds(360, 360, 100, 25);

        Button browseButton = new Button("Browse...");
        browseButton.setBounds(360, 10, 100, 25);

        removeCheck.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (removeCheck.isSelected())
                {
                    subsField.setEnabled(false);
                } else
                {
                    subsField.setEnabled(true);
                }
            }
        });

        goButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                outputArea.setText("");
                if (pathField.getText().equals(null) || pathField.getText().equals("") || findField.getText().equals(null)
                        || findField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Fill in all required fields!", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else
                {
                    goButton.setEnabled(false);
                    Tovarishch t = new Tovarishch();
                    t.rename(removeCheck.isSelected(), pathField.getText(), findField.getText(), subsField.getText(), outputArea);
                }
                goButton.setEnabled(true);
            }
        });

        chiudiButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                window.dispose();

            }
        });

        browseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser pathChooser = new JFileChooser();
                pathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                pathChooser.setAcceptAllFileFilterUsed(false);
                pathChooser.showOpenDialog(window);

                if (pathChooser.getSelectedFile() != null)
                {
                    pathField.setText(pathChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });

        Button uselessButton = new Button("");
        uselessButton.setBounds(10, 20, 300, 25);

        window.getContentPane().add(pathLabel);
        window.getContentPane().add(pathField);

        window.getContentPane().add(findLabel);
        window.getContentPane().add(findField);
        window.getContentPane().add(subsLabel);
        window.getContentPane().add(subsField);

        window.getContentPane().add(removeCheck);

        window.getContentPane().add(goButton);
        window.getContentPane().add(chiudiButton);
        window.getContentPane().add(browseButton);
        window.getContentPane().add(outputArea);

        window.getContentPane().add(uselessButton);

        uselessButton.setVisible(false);

        window.setVisible(true);
    }
    
}
