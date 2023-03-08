 

import edu.duke.*;
import java.io.*;

public class Part4 {
   void first() {
     
      String url = "https://www.dukelearntoprogram.com/course2/data/manylinks.html"; // update to https
      URLResource ur = new URLResource(url);
      for (String s : ur.words()) {
         // searching youtube URL
         String str = s.toLowerCase();
         int pos=str.indexOf("youtube");
         if(pos!=-1)
         {
          String quote = "\"";
          int firstIndex = s.lastIndexOf(quote, pos);
          int secondIndex = s.indexOf(quote,pos+1);
          System.out.println(s.substring(firstIndex, secondIndex+1));
         /* if (firstIndex != -1) {
             String found1 = s.substring(firstIndex + 1);
             int secondIndex = found1.indexOf("\"");
             System.out.println(found1.substring(0, secondIndex));
          }*/
         }
      }
   }

   public static void main(String[] args) {
      Part4 w = new Part4();
      w.first();
   }
}
