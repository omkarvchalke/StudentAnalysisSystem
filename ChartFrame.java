// chart frame
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import java.util.Comparator;
import java.util.stream.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;
import java.io.*;

class ChartFrame extends JFrame
{
    ChartFrame()
    {
        DefaultCategoryDataset d1 = new DefaultCategoryDataset();
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sfact = cfg.buildSessionFactory();

        Session session=null;
        Transaction t = null;
        try{
            session = sfact.openSession();
	
            List<Student> stu = new ArrayList<>();
            HashMap<Integer, Double> average = new HashMap<>();
            stu = session.createQuery("from Student").list();
            for(Student s : stu){
            int rno = s.getRno();
            int s1 = s.getS1();
            int s2 = s.getS2();
            int s3 = s.getS3();
            double avg = ((s1+s2+s3)*1.0)/3.0 ;
            average.put(rno, avg);
	}
	
        Map<Integer, Double> sortedByValueDesc = average.entrySet()
        .stream()
        .sorted(Map.Entry.<Integer, Double>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey, 
               Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<Integer> rollno = new ArrayList<>();
        for ( Integer key : sortedByValueDesc.keySet() ) {
    		rollno.add(key);
        }

        int stu1 = rollno.get(0);
        int stu2 = rollno.get(1);
        int stu3 = rollno.get(2);

        Student s1 = (Student)session.get(Student.class, stu1);
        Student s2 = (Student)session.get(Student.class, stu2);
        Student s3 = (Student)session.get(Student.class, stu3);

        d1.addValue(s1.getS1(), s1.getName(), "Sub1");
        d1.addValue(s1.getS2(), s1.getName(), "Sub2");
        d1.addValue(s1.getS3(), s1.getName(), "Sub3");

        d1.addValue(s2.getS1(), s2.getName(), "Sub1");
        d1.addValue(s2.getS2(), s2.getName(), "Sub2");
        d1.addValue(s2.getS3(), s2.getName(), "Sub3");

        d1.addValue(s3.getS1(), s3.getName(), "Sub1");
        d1.addValue(s3.getS2(), s3.getName(), "Sub2");
        d1.addValue(s3.getS3(), s3.getName(), "Sub3");	
	
    JFreeChart chart = ChartFactory.createBarChart("Student Performance", "Subjects", "Marks", d1, PlotOrientation.VERTICAL, true, false, false);
    ChartPanel cp = new ChartPanel(chart);
    setContentPane(cp);

    setTitle("Marks Sheet");
    setSize(400,350);
    setLocationRelativeTo(null);
    setVisible(true);	
		
}catch(Exception e){
	JOptionPane.showMessageDialog(new JDialog(),"e "+e);	
}

finally
{
	session.close();
}
}
}
        
