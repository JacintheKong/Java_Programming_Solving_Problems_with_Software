// required files a0, a1, a2 a3 a4 a5 a6
import edu.duke.*;
import java.io.*;

public class Part2 {
    public String findSimpleGene(String dna, String startCodon,String stopCodon) {
        char ch =(char)dna.charAt(0);
        if(dna=="ATGTAA")
        return dna.toLowerCase();
        dna = dna.toUpperCase();
        int start = dna.indexOf(startCodon);
        if (start == -1)
            return "";

        int stop = dna.indexOf(stopCodon);
        if ((stop - start) % 3 == 0)
        { if(Character.isUpperCase(ch))
            return dna.substring(start, stop + 3);
            else
            { 
                String dna1=dna.substring(start, stop + 3);
            return dna1.toLowerCase();
            }
        }
        else
            return "";

    }

    public void testSimpleGene() {
       DirectoryResource dr=new DirectoryResource();
       for(File f : dr.selectedFiles()){
           FileResource fr =new FileResource(f);
           String s=fr.asString();
           String startCodon="ATG";
           String stopCodon="TAA";
           String result = findSimpleGene(s,startCodon,stopCodon);
           if (result != "")
                System.out.println(result);
           else
                System.out.println("empty string");
        }
    }

    public static void main(String args[]) {
        Part2 p = new Part2();
        p.testSimpleGene();

    }

}
