// Delete Frame

import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DeleteFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnDelete,btnBack;       
    DeleteFrame()
    {
        c=getContentPane();
        c.setLayout(new FlowLayout());

        lblRno = new JLabel("Enter Roll No To be Deleted:");
        txtRno=new JTextField(15);
        btnDelete= new JButton("Delete");
        btnBack= new JButton("Back");
        
        c.add(lblRno);
        c.add(txtRno);
        c.add(btnDelete);
        c.add(btnBack);

        ActionListener e1 = (ae) -> { MainFrame a = new MainFrame(); dispose();};
        btnBack.addActionListener(e1);

        ActionListener e2 = (ae) -> {
            try
            {
                int rno=Integer.parseInt(txtRno.getText());
                if(String.valueOf(rno)== null)
                    JOptionPane.showMessageDialog(new JDialog(), "Enter all details");
                if(rno > 0)
                {
                    Operations op=new Operations();
                    boolean x= op.HbDelete(rno);
                    if(x==true)
                    {
                        JOptionPane.showMessageDialog(new JDialog(), "Student Record Deleted");
                        txtRno.setText("");
                    }
                    else
                    txtRno.setText("");

                }
                else
                {
                    JOptionPane.showMessageDialog(new JDialog(), "Please Enter Valid Rno.");
                    txtRno.setText("");

                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(new JDialog(), "Please Enter Valid Rno.");
                txtRno.setText("");
            }
        };
        btnDelete.addActionListener(e2);

        setTitle("DELETE");
        setSize(240,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

