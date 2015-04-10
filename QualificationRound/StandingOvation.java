/*
 * Author: Lakshya Chaudhary 
 */

import fileHandler.*;
import java.io.IOException;
import reusableMethods.*;
import java.util.*;

/*
 * Class StandingOvation:-
 * 
 * For detailed explanation of problem, please visit:-
 * https://code.google.com/codejam/contest/6224486/dashboard
 * 
 */

public class StandingOvation{
	
	public static void main(String [] args) throws IOException{
		
		/*
		 * **************************************************************
		 * **************************************************************
		 * Specify the Input File location and Output File location below
		 * **************************************************************
		 * **************************************************************
		 */
		
		String input_File_Name = "Problems\\StandingOvation-small.in";
		String output_File_Name = "Problems\\StandingOvation-small-result.out";
		
		/*
		 * **************************************************************
		 * **************************************************************
		 */
		
		List<String> data = new ArrayList<String>();
		int number_Of_Test_Cases;
		int size_Of_Test_Case = 1;
		
		// Below I am using the ReadFile class to read the Input file and getting a String ArrayList
		try{
			ReadFile file = new ReadFile(input_File_Name);
			data = file.OpenFile();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		number_Of_Test_Cases = Integer.parseInt(data.get(0));
		data.remove(0);
		TestCases testCases = new TestCases(data,number_Of_Test_Cases,size_Of_Test_Case);

		
		int caseCounter;
		List<String> outputList = new ArrayList<String>();
		
		
		/*
		 * Test case counter started,
		 * The folowing loop iterates over all the test cases one by one
		 * 
		 */
		
		for(caseCounter=0;caseCounter<number_Of_Test_Cases;caseCounter++){
			
			List<String> testCase = testCases.getCase(caseCounter);
			String s = testCase.get(0);
			String [] s2 = s.split(" ");
			int sMax = Integer.parseInt(s2[0]);
			
			
			List<Integer> temp = new ArrayList<Integer>();
			s = s2[1];
			
			int i;
			for(i=0;i<=sMax;i++){
				temp.add(Character.getNumericValue(s.charAt(i)));
			}
			
			int frndCount=0;
			for(i=0;i<temp.size();i++){
				if(temp.get(i)>0){
					//System.out.print(Integer.toString(sumTill(temp,i)));
					int diff = i-sumTill(temp,i)-frndCount;
					if(diff>0){
						frndCount = frndCount+diff;
					}
				}
			}
			System.out.println("\n"+Integer.toString(frndCount));
			//System.out.println(Integer.toString(temp.get(0)));
			
			
			
			/*int i;
			int sMax = 
			List<Integr> tempResult = new ArrayList<Integer>();
			for(i=0;i<vector1.size();i++){
				tempResult.add(vector1.get(i) * vector2.get(vector2.size()-i-1));
			}
			
			long result = customList.getSumedList(tempResult);
			System.out.println(Long.toString(result));*/
			
			/*int i;
			for(i=0;i<vector1.size();i++){
				System.out.println(Long.toString(vector1.get(i)));
			}*/
			
			outputList.add("Case #" + (caseCounter+1) + ": " + Integer.toString(frndCount));
		}	
		System.out.println(Integer.toString(outputList.size()));
		int i;
		for(i=0;i<outputList.size();i++){
			System.out.println(outputList.get(i));
		}
		
		//Below I am using the WriteFile class to write the solution line by line into an output file.
		WriteFile writeFile = new WriteFile(output_File_Name);
		writeFile.writeContent(outputList);
	}
	
	static int sumTill(List<Integer> l,int index){
		int i,sum=0;
		for(i=0;i<index;i++){
			sum = sum +l.get(i);
		}
		return sum;
	}
}