/**
 * Reads a chosen CSV file of country exports and prints each country that exports coffee.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
	public void listExporters(CSVParser parser, String exportOfInterest) {
		//for each row in the CSV File
		for (CSVRecord record : parser) {
			//Look at the "Exports" column
			String export = record.get("Exports");
			//Check if it contains exportOfInterest
			if (export.contains(exportOfInterest)) {
				//If so, write down the "Country" from that row
				String country = record.get("Country");
				System.out.println(country);
			}
		}
	}

	public void whoExportsCoffee() {
		FileResource fr = new FileResource();
		CSVParser parser = fr.getCSVParser();
		listExporters(parser, "coffee");
	}
	
	public void countryInfo(CSVParser parser, String country) {
	    for (CSVRecord record : parser) {
			String country1 = record.get("Country");
			if (country1.contains(country)) {
			    String exports = record.get("Exports");
			    String value = record.get("Value (dollars)");
			    System.out.println(country + ": " + exports + ": " + value);
			}
			
		}
	}
	
	public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
	    for (CSVRecord record : parser) {
			String exports = record.get("Exports");
			if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
				String country = record.get("Country");
				System.out.println(country);
			}
		}
	}
	
	public void numberOfExporters(CSVParser parser, String exportItem) {
	    int count = 0;
	    for (CSVRecord record : parser) {
			String exports = record.get("Exports");
			if (exports.contains(exportItem)) {
				String country = record.get("Country");
				System.out.println(country);
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	public void bigExporters(CSVParser parser, String amount) {
	    for (CSVRecord record : parser) {
			String value = record.get("Value (dollars)");
			if (value.length() >("$"+amount).length() ) {
				String country = record.get("Country");
				System.out.println(country + " : " + value);

			}
		}
	}
	
	public void tester() {
	        FileResource fr = new FileResource();
                CSVParser parser = fr.getCSVParser();
                //countryInfo(parser, "Nauru");
                //parser = fr.getCSVParser();
                //listExportersTwoProducts(parser, "cotton", "flowers");
                //parser = fr.getCSVParser();
                //numberOfExporters(parser, "cocoa");
                bigExporters(parser, "999,999,999,999");
	   }
}
