//Main Frame

import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnView, btnUpdate, btnDelete , btnCharts;       
    MainFrame()
    {
        c=getContentPane();
        c.setLayout(null);

        btnAdd= new JButton("Add");
        btnAdd.setBounds(25,35,75,25); //(x,y,width,height)
        btnView= new JButton("View");
        btnView.setBounds(125,35,75,25);
        btnUpdate= new JButton("Update");
        btnUpdate.setBounds(25,80,75,25);
        btnDelete= new JButton("Delete");
        btnDelete.setBounds(125,80,75,25);
        btnCharts= new JButton("Charts");
        btnCharts.setBounds(75,125,75,25);

        c.add(btnAdd);
        c.add(btnView);
        c.add(btnUpdate);
        c.add(btnDelete);
        c.add(btnCharts);

        ActionListener e1 = (ae) -> { AddFrame a = new AddFrame(); dispose();};
        btnAdd.addActionListener(e1);
        
        ActionListener e2 = (ae) -> { ViewFrame a = new ViewFrame(); dispose();};
        btnView.addActionListener(e2);
        
        ActionListener e3 = (ae) -> { UpdateFrame a = new UpdateFrame(); dispose();};
        btnUpdate.addActionListener(e3);

        ActionListener e4 = (ae) -> { DeleteFrame a = new DeleteFrame(); dispose();};
        btnDelete.addActionListener(e4);
        
        ActionListener e5 = (ae) -> { 
            ChartFrame a= new ChartFrame();
            
        
            
            
            
            
            
            
            
            //dispose();
        };
		btnCharts.addActionListener(e5);
        
        
        
        
        
        setTitle("SMS");
        setSize(240,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

