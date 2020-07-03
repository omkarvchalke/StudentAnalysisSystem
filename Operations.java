import org.hibernate.*;
import org.hibernate.cfg.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

import java.util.ArrayList;

class Operations
{
    Container c;
    
    
    public static boolean HbAdd(int rno, String name, int s1, int s2, int s3)
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact=cfg.buildSessionFactory();

        Session session=null;
        Transaction t=null;
        try
        {
            session=sfact.openSession();
            t=session.beginTransaction();
            
            Student s=new Student(rno,name,s1,s2,s3);

            session.save(s); //to save this Student Object into session
            t.commit(); //to save the data
            return true;
            
        }
        catch(Exception e)
        {
            t.rollback();
            JOptionPane.showMessageDialog(new JDialog(),"Error:"+e);
            return false;
        }
        finally
        {
            session.close();
            
        }
        
    }

    public static String HbView()
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact=cfg.buildSessionFactory();

        Session session=null;
        Transaction t=null;
        String msg="";

        try
        {
            
            session=sfact.openSession();
            
            List<Student> stu = new ArrayList<>();
            stu=session.createQuery("from Student").list();   //class name is there
            for(Student s : stu)
               msg=msg+("Rno: "+s.getRno()+" "+"\t Name: "+s.getName()+"\tSub1: "+s.getS1()+"\tSub2: "+s.getS2()+"\tSub3: "+s.getS3()+"\n");
        }
        catch(Exception e)
        {
             System.out.println("Issue: "+ e);
        }
        finally
        {
            session.close();
            
        }
        return msg;
    }

    public static boolean HbUpdate(int rno, String name, int s1, int s2, int s3)
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact=cfg.buildSessionFactory();

        Session session=null;
        Transaction t=null;
        try
        {
            session=sfact.openSession();
            t=session.beginTransaction();
            
            Student s=(Student)session.get(Student.class,rno); //downcasting : for using the attributes of student object
            if(s!=null)
            {
                s.setName(name);
                s.setS1(s1);
                s.setS2(s2);
                s.setS3(s3);
                
            }
            else
            JOptionPane.showMessageDialog(new JDialog(),"Rno: "+rno+" does not Exist!");
            
            
            session.update(s); //to update this Student Object into session
            t.commit(); //to save the data
            return true;
            
        }
        catch(Exception e)
        {
            t.rollback();
            return false;
        }
        finally
        {
            session.close();
            
        }
    }

    public static boolean HbDelete(int rno)
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact=cfg.buildSessionFactory();

        Session session=null;
        Transaction t=null;
        try
        {
            session=sfact.openSession();
            
            t=session.beginTransaction();
            
            
            
            Student s=(Student)session.get(Student.class,rno); //downcasting : for using the attributes of student object
            if(s!=null)
            {
                session.delete(s); //will delete the entire Obj
                
            }
            else
            {
                String msg=("Rno"+rno+" does not exist");
                JOptionPane.showMessageDialog(new JDialog(),msg);
                return false;
            }
            
            
             
            t.commit(); //to save the data
            return true; 
            
        }
        catch(Exception e)
        {
            t.rollback();
            JOptionPane.showMessageDialog(new JDialog(),"Error");
            return false;
            
        }
        finally
        {
            session.close();
            
        }
    }

   /* public static void HbCharts()
    {
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact=cfg.buildSessionFactory();

        Session session=null;
        Transaction t=null;

        try
        {
            
            session=sfact.openSession();
            
            //List<Student> stu = new ArrayList<>();
            String hql = "FROM Student S  ORDER BY S.avg DESC";
            Query query = session.createQuery(hql);
            
            t.commit();
        }
        catch(Exception e)
        {
             System.out.println("Issue: "+ e);
        }
        finally
        {
            session.close();
            
        }

    }*/
}