package edu.montgomerycollege.cmsc204.jbryant;

import javax.swing.*;

public class DriverFrame extends JFrame
{
    public DriverFrame() throws Exception
    {
        setTitle("Assignment 6");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DriverPanel panel = new DriverPanel();
        getContentPane().add(panel);
    }

    public static void main(String[] args) throws Exception
    {
        JFrame frame = new DriverFrame();
        frame.pack();
        frame.setVisible(true);
    }
}
