//Update Frame

import java.util.*;
import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UpdateFrame extends JFrame
{
Container c;
JLabel lblRno,lblName,lblSub1,lblSub2,lblSub3;
JTextField txtRno,txtName,txtSub1,txtSub2,txtSub3;
JButton btnUpdate,btnBack;       
    UpdateFrame()
    {
        c=getContentPane();
        c.setLayout(new FlowLayout());

        lblRno = new JLabel("Roll No:");
        lblName = new JLabel("   Name:");
        lblSub1 = new JLabel("    Sub1:");
        lblSub2 = new JLabel("    Sub2:");
        lblSub3 = new JLabel("    Sub3:");

        txtRno=new JTextField(15);
        txtName=new JTextField(15);
        txtSub1=new JTextField(15);
        txtSub2=new JTextField(15);
        txtSub3=new JTextField(15);

        btnUpdate= new JButton("Update");
        btnBack= new JButton("Back");
        
        c.add(lblRno);
        c.add(txtRno);
        c.add(lblName);
        c.add(txtName);
        c.add(lblSub1);
        c.add(txtSub1);
        c.add(lblSub2);
        c.add(txtSub2);
        c.add(lblSub3);
        c.add(txtSub3);
        c.add(btnUpdate);
        c.add(btnBack);
        
        ActionListener e1 = (ae) -> { MainFrame a = new MainFrame(); dispose();};
        btnBack.addActionListener(e1);
    
        ActionListener e2 = (ae) -> { 
            try
            {
                int rno=Integer.parseInt(txtRno.getText());
                String name=txtName.getText();
                int s1=Integer.parseInt(txtSub1.getText());
                int s2=Integer.parseInt(txtSub2.getText());
                int s3=Integer.parseInt(txtSub3.getText());
                if(rno>0 && name.length()>=2 && 0<=s1 && s1<=100 && 0<=s2 && s2<=100 && 0<=s3 && s3<=100)
                {
                    Operations op=new Operations();
                    boolean x=op.HbUpdate(rno,name,s1,s2,s3);
                    if(x==true)
                        JOptionPane.showMessageDialog(new JDialog(), "Student Updated");
                    txtRno.setText("");
                    txtName.setText("");
                    txtSub1.setText("");
                    txtSub2.setText("");
                    txtSub3.setText("");
                }
                else
                    JOptionPane.showMessageDialog(new JDialog(), "Please Enter Valid Details");
                txtRno.setText("");
                txtName.setText("");
                txtSub1.setText("");
                txtSub2.setText("");
                txtSub3.setText("");
                
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(new JDialog(), "Please Enter Valid Details");
                txtRno.setText("");
                txtName.setText("");
                txtSub1.setText("");
                txtSub2.setText("");
                txtSub3.setText("");
            }
        };
        btnUpdate.addActionListener(e2);



        setTitle("UPDATE");
        setSize(270,250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
