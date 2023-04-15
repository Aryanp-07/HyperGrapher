package Data_Visualizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.sql.*; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet
{
	static String[] entity;
	static String[] row, line; 
	static String[][] KT;
	static String s;
	private static final long serialVersionUID = 1L;

    public HelloForm() {super();}
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String fileinput = request.getParameter("fileinput");
		String graphtype = request.getParameter("graphtype");
		String data = request.getParameter("file-output");
		//System.out.println(data);
		List<String[]> list = new ArrayList<>();
        String splitBy = ",";  
        int count=0;
        int k;
        line = data.split("\\R");
        String[] lables = line[0].split(splitBy);
        try (Scanner scanner = new Scanner(data)) {
		    // Loop through each row
		    while (scanner.hasNextLine()) {
		        String row = scanner.nextLine();

		        // Split the row by the comma character to get each value
		        String[] values = row.split(",");

		        // Loop through each value and add it to the corresponding column array
		        for (int a = 0; a < values.length; a++) {
		            // If this is the first row, create a new array for the column
		            if (list.size() <= a) {
		                list.add(new String[0]);
		            }
		            // Add the value to the column array
		            list.set(a, Arrays.copyOf(list.get(a), list.get(a).length + 1));
		            list.get(a)[list.get(a).length - 1] = values[a];
		        }
		    }
		}
//        for(int i=0; i<line.length;i++)
//        {
//        	if(count<1)
//        	{
//        		row = line[i].split(splitBy);    // use comma as separator  
//        		System.out.println(row[0]+" "+row[1]+" "+row[2]+" "+row[3]);
//                count++;
//        	}
//        	else
//			{
//        		
//			}
//        }
        String[][] d1 = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
		    String[] arr = list.get(i);
		    d1[i] = Arrays.copyOfRange(arr, 1, arr.length);
		}
		
		for(int i=1;i<lables.length;i++)
		{
			System.out.print(lables[i]+" ");
		}
		System.out.println();
		for (int p = 0; p < d1.length; p++) {
			 for(int q=0;q<d1[p].length;q++) {
		           System.out.print(d1[p][q]+"\t");
		}
		}
		System.out.println();
		for(int i=0;i<d1.length;i++)
		{
			System.out.println(Arrays.deepToString(d1[i])+",");
		}
		//System.out.println("\n"+Arrays.deepToString(d1[1]));
		System.out.println(d1.length+" "+d1[0].length);
     // Array of data
       // int[][] d1 = {{11, 22, 33, 44, 55,11},{12,23,34,45,56,12}, {45,22,87,65,76,56}};

        // Build datasets
        StringBuilder datasets = new StringBuilder();
        StringBuilder xaxis = new StringBuilder();
        
        for(int i=0;i<d1[0].length;i++)
		{
			xaxis.append("'"+d1[0][i]+"'");
			if(i<d1[0].length-1)
				xaxis.append(",");			
		}
//        for(int i=0; i<entity.length;i++)
//        {
//        	xaxis.append("[")
//        	.append(entity[i][1]);
//        	if (i < entity[i].length - 1) {
//                datasets.append(",");
//            	}
//        	xaxis.append("]");
//        }
//        
//        System.out.println(xaxis);
//        int w=1;
//        for (int i = 0; i < d1.length; i++) {
//          datasets.append("{");
//          if(w<row.length) {
//            datasets.append("label: '"+row[w]+"',");
//          }
//          else
//          {
//        	  datasets.append("label: '',");
//          }
//            datasets.append("backgroundColor: 'rgba(255, 99, 132, 0.2)',")
//            .append("borderColor: 'rgba(255, 99, 132, 1)',")
//            .append("data: [");
//            for(int j=0;j<d1[i].length;j++) {
//            datasets.append(d1[i][j]);
//          	if (j < d1[i].length - 1) {
//              datasets.append(",");
//          	}
//        	}
//            datasets.append("]")
//            .append("}");
//          if (i < d1.length - 1) {
//            datasets.append(",");
//          }
//          w++;
//        }
		//System.out.println(datasets.toString());
//		System.out.println("Path:"+fileinput+"\n"+"graph type:"+graphtype);
//		System.out.println("Data: "+data);
        Random random = new Random();
        int[] randomNumbers = new int[3];
		for(int o=1;o<d1.length;o++)
		{
			
	        
	        for (int i = 0; i < 3; i++) {
	            int randomNumber = random.nextInt(256) + 1; // generate a random number between 1 and 10
	            randomNumbers[i] = randomNumber; // add the number to the array
	        }
	        
			datasets.append("{")
			.append("label: ");
			datasets.append("'"+lables[o]+"',");
			datasets.append("backgroundColor: 'rgba("+randomNumbers[0]+","+randomNumbers[1]+","+randomNumbers[2]+","+0.5+")',")
          .append("borderColor: 'rgba("+randomNumbers[0]+","+randomNumbers[1]+","+randomNumbers[2]+","+1+")',")
          .append("data:");
			datasets.append(Arrays.deepToString(d1[o])+",");
			if(o<d1.length-1)
			{
				datasets.append("},");
			}
			else
			{
				datasets.append("}");
			}
		}
		System.out.println(datasets.toString());
		System.out.println(xaxis.toString());
		
		out.print("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "    <head>\r\n"
				+ "        <title>Landing Page</title>\r\n"
				+ "        <link rel=\"stylesheet\" href=\"Landing - Copy.css\">\r\n"
				+ "    </head>\r\n"
				+ "    <body>\r\n"
				+ "        <h1>Thanks for using <span>HyperGrapher</span>!</h1>\r\n"
				+ "        <p>Here is your data visualized</p>\r\n"
				+ "        <div>\r\n"
				+ "            <canvas id=\"myChart\"></canvas>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\r\n"
				+ "          \r\n"
				+ "          <script>\r\n"
				+ "            const ctx = document.getElementById('myChart');\r\n"
				+ "          \r\n"
				+ "            new Chart(ctx, {\r\n"
				+ "              type: '"+graphtype+"',\r\n"
				+ "              data: {\r\n"
				+ "                labels: ["+xaxis.toString()+"],\r\n"
				+ "                datasets: ["+datasets.toString()+"]\r\n"
				+ "              },\r\n"
				+ "              options: {\r\n"
				+ "                scales: {\r\n"
				+ "                  y: {\r\n"
				+ "                    beginAtZero: true\r\n"
				+ "                  }\r\n"
				+ "                }\r\n"
				+ "              }\r\n"
				+ "            });\r\n"
				+ "          </script>\r\n"
				+ "    </body>\r\n"
				+ "</html>");
		
	}


}

//{\r\n"
//		+ "                  label: '# of Votes',\r\n"
//		+ "                  data: [12, 19, 3, 5, 2, 3],\r\n"
//		+ "                  borderWidth: 1,\r\n"
//		+ "                  borderColor: '#FF6384',\r\n"
//		+ "                  backgroundColor: '#FFB1C1',\r\n"
//		+ "                }
