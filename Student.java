public class Student{
    
private String id, name;
private double t1, t2, as1, fa, total; //total is based on the percentages

public Student(){

}

public Student(String a, String b, double c, double d, double e, double f){
    id=a;
    name=b;
    t1=c;
    t2=d;
    as1=e;
    fa=f;
}

public String getId(){
    return id;
}

public double getT1(){
    return t1;
}

public double getT2(){
    return t2;
}

public double getAs1(){
    return as1;
}

public double getFa(){
    return fa;
}

public double getTotal(){
    return total;
}

public void setTotal(double t){
    total=t;
}

public String toString(){
    return id+" "+name+" "+t1+" "+t2+" "+as1+" "+fa+" "+total;
    }
}