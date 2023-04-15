package Data_Visualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class teststring {
	static String[] entity;
	static String[][] KT;
	public static void main(String[] args){
		String[] line, column = null;
		// TODO Auto-generated method stub
		String data = "Name, t1, t2, t3\nA, 31, 32, 33\nB, 50, 23, 78\nC, 90, 12, 24\nD, 34, 56, 78\n";		
		//column = {"Name", "t1", "t2", "t3"}
		//row_deet = {{"A", "31", "32", "33"}, {"B", "50", "23", "78"}, {"C", "90", "12", "24"}, {"D", "34", "56", "78"}}

		// Split the data by the newline character to get each row

		// Create a list to hold the data from each column
		List<String[]> list = new ArrayList<>();

		// Loop through each row and split it by the comma character
//		try (Scanner scanner = new Scanner(data)) {
//		    // Loop through each row
//		    while (scanner.hasNextLine()) {
//		        String row = scanner.nextLine();
//
//		        // Split the row by the comma character to get each value
//		        String[] values = row.split(",");
//
//		        // Loop through each value and add it to the corresponding column array
//		        for (int i = 0; i < values.length; i++) {
//		            // If this is the first row, create a new array for the column
//		            if (list.size() <= i) {
//		                list.add(new String[0]);
//		            }
//		            // Add the value to the column array
//		            list.set(i, Arrays.copyOf(list.get(i), list.get(i).length + 1));
//		            list.get(i)[list.get(i).length - 1] = values[i];
//		        }
//		    }
//		}
		String[] lines = data.split("\n");
		int numRows = lines.length;
		int numCols = lines[0].split(",").length;

		String[][] d1 = new String[numRows][numCols];
		String[] firstCol = new String[numRows];

		for (int i = 0; i < numRows; i++) {
		    String[] parts = lines[i].split(",");
		    firstCol[i] = parts[0]; // extract first column value
		    for (int j = 0; j < numCols; j++) {
		        d1[i][j] = parts[j];
		    }
		}

		System.out.println("Data array:");
		for (String[] row : d1) {
		    System.out.println(Arrays.toString(row));
		}

		System.out.println("First column array:");
		System.out.println(Arrays.toString(firstCol));





//		String[][] d1 = new String[list.size()][];
//		for (int i = 0; i < list.size(); i++) {
//		    String[] arr = list.get(i);
//		    d1[i] = Arrays.copyOfRange(arr, 1, arr.length);
//		}
//		System.out.println("\n"+Arrays.deepToString(d1));

		// Print the contents of each column
//		for (int i = 0; i < list.size(); i++) {
//		    System.out.println("Column " + i + ": " + String.join(", ", list.get(i)));
//		}
	}
}



