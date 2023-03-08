
import edu.duke.*;
import java.io.*;

public class Part1 {
    public String findSimpleGene(String dna) {
        dna = dna.toUpperCase();
        int start = dna.indexOf("ATG");
        if (start == -1)
            return "";

        int stop = dna.indexOf("TAA");
        if ((stop - start) % 3 == 0)
            return dna.substring(start, stop + 3);
        else
            return "";

    }

    public void testSimpleGene() {
        String a[] = new String[5];
        a[0] = "cccatggggtttaaataataataggagagagagagagagttt";
        a[1] = "cccaggggtttaa";
        a[2] = "cccatggggttta";
        a[3] = "cccaggggttta";
        a[4] = "atggggttgtaa";
        for (int i = 0; i < 5; i++) {
            String result = findSimpleGene(a[i]);
            if (result != "")
                System.out.println(result);
            else
                System.out.println("empty string");
        }
    }

    public static void main(String args[]) {
        Part1 p = new Part1();
        p.testSimpleGene();

    }

}
