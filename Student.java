//hibernate class

class Student
{
    private int rno,s1,s2,s3;
    private double avg;
    private String name;

    public Student() //default Constructor
    {
        rno=0;
        name="";
        s1=0;
        s2=0;
        s3=0;
    }
    public Student(int rno, String name, int s1, int s2, int s3) //parameterized Constructor
    {
        this.rno=rno;
        this.name=name;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
    }

    public int getRno() //Accessor or Getter
    { return rno; }
    public void setRno(int rno) //Mutator or Setter
    {   this.rno=rno;  }

    public String getName() 
    { return name; }
    public void setName(String name) 
    {   this.name=name;  }

    public int getS1() 
    { return s1; }
    public void setS1(int s1) 
    {   this.s1=s1;  }

    public int getS2() 
    { return s2; }
    public void setS2(int s2) 
    {   this.s2=s2;  }

    public int getS3() 
    { return s3; }
    public void setS3(int s3) 
    {   this.s3=s3;  }
    
    /*public Student(int rno, String name, int s1, int s2, int s3, double avg) //parameterized Constructor
    {
        this.rno=rno;
        this.name=name;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.avg=avg;
    }

    public double getAvg() //Accessor or Getter
    { return avg; }
    public void setAvg(double avg) //Mutator or Setter
    {   this.avg=avg;  }*/
   

    
}