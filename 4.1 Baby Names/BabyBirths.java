/**
 * Print out total number of babies born, as well as for each gender, in a given CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import java.io.File;
import org.apache.commons.csv.*;

public class BabyBirths {
	public void printNames () {
		FileResource fr = new FileResource();
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			if (numBorn <= 100) {
				System.out.println("Name " + rec.get(0) +
						   " Gender " + rec.get(1) +
						   " Num Born " + rec.get(2));
			}
		}
	}

	public void totalBirths (FileResource fr) {
		int totalBirths = 0;
		int totalBoys = 0;
		int totalGirls = 0;
		int boysNames = 0;
                int girlNames = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			int numBorn = Integer.parseInt(rec.get(2));
			totalBirths += numBorn;
			if (rec.get(1).equals("M")) {
				totalBoys += numBorn;
				boysNames++;
			}
			else {
				totalGirls += numBorn;
				girlNames++;
			}
		}
		System.out.print("Total births: " + totalBirths +"\n" + "Total boys: " + totalBoys + "\n"
                   + "Total girls: " + totalGirls + "\n" + "Quantity boy`s names : " + boysNames +"\n" +
                "Quantity girl`s names : " + girlNames +"\n");
            }

	public void testTotalBirths () {
		//FileResource fr = new FileResource();
		FileResource fr = new FileResource("data/yob1900.csv");
		totalBirths(fr);
	}
	
	public int getRank (int year, String name, String gender) {
	    String fileName = "data/yob" + year + ".csv";
	    FileResource fr = new FileResource(fileName);
	    int rank = 0;
	    boolean found = false;
	    for (CSVRecord rec : fr.getCSVParser(false)) {
	         if (rec.get(1).equals(gender)){
	             if (rec.get(0).equals(name)){
	               rank += 1;
	               found = true;
	               break;
	             }
	             else{
	                 rank += 1;
	            }
	         }
	    }
	    if (found == true ) return rank;
	    else return -1;
	   }
	   
	public void testGetRank () {
	    int rank = getRank(1971,"Frank", "M");
	    System.out.println("Rank  = " + rank );
	}
	
	public String getName (int year, int rank, String gender) {
	    String fileName = "data/yob" + year + ".csv";
	    FileResource fr = new FileResource(fileName);
	    int count = 1;
	    String name = "";
	    boolean found = false;
	    for (CSVRecord rec : fr.getCSVParser(false)) {
	         if (rec.get(1).equals(gender)){
	             if (count == rank){
	               found = true;
	               name = rec.get(0);
	               break;
	             }
	             else{
	                 count += 1;
	            }
	         }
	    }
	    if (found == true ) return name;
	    else return "NO NAME";
	   }
	   
	   public void testGetName () {
	    String name = getName(1982, 450, "M");
	    System.out.println("Name = " + name );
	}
	
	public void whatIsNameInYear (String name, int year, int newYear, String gender) {
	    String fileName1 = "data/yob" + year + ".csv";
	    String fileName2 = "data/yob" + newYear + ".csv";
	    int rank = getRank (year, name, gender);
	    String newName = getName (newYear, rank, gender);
	    System.out.println("newName = " + newName );
	   }
	   
	   public void testWhatIsNameInYear () {
	    whatIsNameInYear ("Susan", 1972, 2014, "F");
	}
        
         public int yearOfHighestRank(String name, String gender){
         int rank = -1;
         int year = -1;
         int tempRank;
         DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
             int tempYear = parseYear(f.getName());
             tempRank = getRank(tempYear,name,gender);
             if((tempRank < rank || rank == -1) && tempRank != -1){
                 rank = tempRank;
                 year = tempYear;
             }
         }
         return year;
     }
     
     private int parseYear (String s){
         StringBuilder sb = new StringBuilder();
         for (int i = 0; i <s.length() ; i++) {
             if (Character.isDigit(s.charAt(i)))
                sb.append(s.charAt(i));
         }
       return Integer.parseInt(sb.toString());
     }
     
     public void testParseYear(){
         int year = parseYear("data/yob1900.csv");
         System.out.println(year);
        }
	
     public void testYearOfHighestRank(){
	    int year = yearOfHighestRank("Mich", "M");
	    System.out.println("Highest Rank is in year " + year);
	}
	
	
	public double getAverageRank(String name, String gender){
	    int cnt = 0;
            double total = 0;
	    DirectoryResource dr = new DirectoryResource();
         for (File f : dr.selectedFiles()) {
             cnt++;
             int tempYear = parseYear(f.getName());
             int rank = getRank(tempYear,name,gender);
             total += rank;
         }
         return total/cnt;
	   }

	   public void testGetAverageRank(){
	    double avg = getAverageRank("Robert", "M");
	    System.out.println("Average rank is " + avg);
	}
	
	public int getTotalBirthsRankedHigher(int year, String name, String gender){
	    int cnt=0;
	    //String fileName = "yob" + year + "short.csv";
	    //FileResource fr = new FileResource("testing/"+fileName);
	    FileResource fr = new FileResource("data/yob1990.csv");
	    for (CSVRecord rec : fr.getCSVParser(false)) {
	        if (rec.get(0).equals(name) && rec.get(1).equals(gender))
                     break;
                else if (rec.get(1).equals(gender))
                     cnt += Integer.parseInt(rec.get(2));
	   }
	   return cnt;
        }

        public void testGetTotalBirthsRankedHigher(){
	    int cnt = getTotalBirthsRankedHigher(1990, "Drew", "M");
	    System.out.println("TotalBirthsRankedHigher is " + cnt);
	}
}
