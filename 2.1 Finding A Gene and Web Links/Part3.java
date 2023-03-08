 

import edu.duke.*;
import java.io.*;
import java.util.Scanner;

public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb ){
     int pos=stringb.indexOf(stringa);
     int l=stringa.length();
     //System.out.println(pos);
     if(stringb.indexOf(stringa,pos+l)>0)
     return true;
     else 
     return false;
    }
 
    void testing()
    {
     Scanner sc=new Scanner(System.in);
     String str=sc.nextLine();
     String str2=sc.nextLine();
        boolean t= twoOccurrences(str2, str);
     System.out.println(t);
     String last= lastPart(str2, str);
     System.out.println(last);
     sc.close();
    }
    
    String lastPart(String stringa, String stringb)
    {
        int pos=stringb.indexOf(stringa);
        int l=stringa.length();
     if(stringb.indexOf(stringa,pos+l)>0)
     return stringb.substring(pos+l);
     else 
     return stringb;
    }
    
    public static void main(String args[]) {
        Part3 p = new Part3();
        p.testing();

    }

 }
