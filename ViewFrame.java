//View Frame

import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;

class ViewFrame extends JFrame
{
Container c;
JButton btnBack;
TextArea taData;       
    ViewFrame()
    {
        c=getContentPane();
        c.setLayout(new FlowLayout());
        
        taData=new TextArea(10,25);
        btnBack= new JButton("Back");
        

        c.add(taData);
        c.add(btnBack);
        
        Operations op=new Operations();
        String data=Operations.HbView();
        taData.setText(data);

        
        
        ActionListener e1 = (ae) -> { MainFrame a = new MainFrame(); dispose();};
        btnBack.addActionListener(e1);

        setTitle("VIEW");
        setSize(270,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
