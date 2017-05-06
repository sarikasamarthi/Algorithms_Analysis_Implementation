//PROGRAM IMPLEMENTING MAXIMUM SUB_ARRAY PROBLEM USING DIVIDE AND CONQUER METHOD TO COMPARE SHARES FOR GIVEN COMPANIES USING JAVA PROGRAMMING LANGUAGE
import java.util.*;
//import java.io.*;
public class MaxSubArr{
	public static void main(String args[]) {
				System.out.print("ENTER NUMBER OF COMPANIES,WHOSE SHARES ARE TO BE COMPARED:");
				
				//USER INPUTS TOTAL COMPANIES
				Scanner userInput = new Scanner(System.in);
				int arrayLength = userInput.nextInt();
				
				System.out.println();
				System.out.println();
				System.out.println("ENTER NUMBER OF DAYS OF THE SHARES DATA TO BE COMPARED:");
				int totalDays = userInput.nextInt();
			  
			  //PRICE VARIABLE HOLDS TOTAL COMPANIES SHARES DATA FOR ONE COMPLETE MONTH.
				int[][] price = new int[arrayLength+10][totalDays+10];
				
			 //EACH COMPANY PROVIDES RANGE,USING RANDOM METHOD WHICH GENERATES RANDOM VALUES WITHIN THE SPECIFIED RANGE
				for(int i=0;i<arrayLength;i++){
							
							System.out.println("\n\n\nENTER THE RANGE MIN AND MAX:BASED ON WHICH SHARE VALUES ARE RANDOMLY GENERATED FOR"+" "+(i+1)+" "+"COMPANY:");
						  	int max = userInput.nextInt();
							int min = userInput.nextInt();
							
							for(int j=0;j<totalDays;j++){
										int temp=min + (int)(Math.random() * ((max - min) + 1));
										price[i][j]=temp;
							}
				}
				
			 //DISPLAYING THE SHARE PRICES FOR ALL THE GIVEN COMPANIES.
				for(int i=0;i<arrayLength;i++){
							
							System.out.println("\n\n\nDISPLAYING RANDOM SHARE VALUES GENERATED FOR"+" "+(i+1)+" "+"COMPANY:");
							System.out.println();
							
							for(int j=0;j<totalDays;j++){
										System.out.print(price[i][j]+" ");
							}
				}
				
			  //JUST A TRIAL CHECK WITH VALUES
				/*int[][] price ={{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97},
							{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97},
							{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97},
							{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97},
							{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97}
						};*/
						
			  //CALCULATING CHANGE IN THE PRICE VALUE FROM THE PREVIOUS DAY FOR ALL 30 DAYS		
				int[][] a = new int[arrayLength+10][totalDays+10];
				for(int j=0;j<arrayLength;j++){
									for(int k=0;k<totalDays-1;k++){
													if(price[j][k]<price[j][k+1])
																	a[j][k]=price[j][k+1]-price[j][k];
													else
																	a[j][k]=price[j][k+1]-price[j][k];
				  
									}
				}
			   
			  //DISPLAYING CHANGE IN THE VALUE FOR ALL 30DAYS AND FOR ALL COMPANIES
				for(int m=0;m<arrayLength;m++){
									System.out.println("\n\n\nCHANGE IN THE SHARE VALUE FOR"+" "+(m+1)+" "+"COMPANY IS:");
									System.out.println();
									System.out.println();
									for(int l=0;l<totalDays-1;l++)
													System.out.print(a[m][l]+" ");
				}
			 
			 //ACTUAL DIVIDE AND CONQUER METHOD FOR MAXIMUM SUBARRAY STARTS HERE.INDIVIDUALLY CALCULATING MAXMIMUM SUBARRAY AND STORING THE RESULTS IN RESULTS ARRAY
				int[] companyResults = new int[arrayLength];//VARIABLE TO COMPARE ALL COMPANIES MAXIMUM SUBARRAY VALUE AND DECIDE THE COMPANY WITH HIGH SHARE VALUE.
				for(int n=0;n<arrayLength;n++){
									int result[] = FindMaximumSubArray(a[n],0,a[n].length-1);
									
									companyResults[n]=result[2];
																
									System.out.println();
									System.out.println("\nMAXIMUM SUB_ARRAY FOR"+" "+(n+1)+" "+"COMPANY");  
									System.out.println();									
									System.out.println("\n\nLOWER INDEX FOR THE MAXIMUM SUB_ARRAY IS:"+" " + result [0]);  
									System.out.println("\n\nHIGHER INDEX FOR MAXIMUM SUB_ARRAY IS:"+" " + result [1]); 
									System.out.println("\n\nTOTAL SUM FOR THE MAXIMUM SUB_ARRAY IS:"+" "+ result [2]);   
								  
				}
				
				int maximum=0;
				for(int i=0;i<arrayLength;i++){
							 maximum=i;
							for(int j=1;j<arrayLength-1;j++){
									if(companyResults[maximum]<companyResults[j])
									  maximum=j;
							}
				}
				System.out.println("COMPANY WITH HIGHEST MAXIMUM SUBARRAY VALUE IS COMPANY"+" "+(maximum+1)+" "+"with value: "+companyResults[maximum]);
	}
	
  //THIS METHOD DIVIDES THE ARRAY IN TO TWO HALFS AND CHECKS FOR MAXIMUM SUBARRAY IN EACH DIVIDED PART
	public static int[] FindMaximumSubArray(int[] a,int low,int high){
				
				//CONDITION IF ONLY ONE ELEMENT IS PRESENT
				if( high == low){ 
									int[] result = {low, high, a[low]}; //base case: only one element 
													return result; 
				}else{ 
									
								  //CALCULATE MID VALUE TO DIVIDE TH EARRAY INTO SUB ARRAYS
								    int mid = (low + high) /2;  
									
								  //RECURSIVE METHOD WHICH DIVIDES THE COMPLETE ARRAY FROM LOW TO MID AND MID+1 TO HIGH
									int[] result1 = FindMaximumSubArray (a, low, mid);   
									int[] result2 = FindMaximumSubArray (a, mid+1, high);
									
								  //REAL CODING HAPPENS IN FINDMAXSROSSINGSUBARRAY METHOD,WHICH CHECKS FOR THE MAXIMUM SUBARRAY FROM LOW TO HIGH
									int[] result3 = FindMaxCrossingSubArray(a, low, mid, high); 
									
								 //CHECKING WHERE THE MAXIMUM SUBARRAY IS PRESENT.IT WILL BE EITHER IN THE RANGE LOW TO MID OR MID+1 TO HIGH OR LOW TO HIGH.THE RESULT VALUES ON ALL THE RANGES ARE GIVEN BY THREE DIFFERENT METHODS AND THE VALUES ARE COMPARED TO FINALISE THE MAXIMUM SUBARRAY VALUE.
									if( result1[2] >= result2[2] && result1[2] >= result3[2] ){
													return result1; 
									}else if (result2[2] >= result1[2] && result2[2] >= result3[2]){ 
													return result2; 
									 }else{ 
													return result3;
									  } 
				 }  
	}
	public static int[] FindMaxCrossingSubArray(int[] a,int low,int mid,int high){
	
			   //EFTMAXIMUM SET TO MINIMUM VALUE.IN MY CASE -999
				 int leftSum = -999;
				 int sum = 0; 
				 int maxLeft = -1; 
			     int maxRight = -1; 
			  //CALULATING MAXIMUM SUBARRAY FROM MID TO LOW.AND ASSIGNING MAXLEFT WHICH IS MAX INDEX TO I+1,SINCE IN MY PROGRAM MY INDEXES STARTS FROM ZERO 
				 for(int i = mid; i > low; i--){ 
								sum += a[i]; 
								if (sum > leftSum){  
												leftSum = sum; 
												maxLeft = i+1; 
								} 
				 } 
				 
			  //THIS PART IS SIMILAR TO ABOVE PART EXCEPT THE RANGE I SMID+1 TO HIGH
				 int rightSum = -999; 
				 sum = 0; 
				 for(int j = mid+1; j < high; j++){ 
								sum += a[j];
								if (sum > rightSum){ 
												rightSum = sum;
												maxRight = j+1; 
								} 
				 }

			   //RESULT ARRAY WILL HAVE LEFT MAXINDEX AND RIGHT MAXINDEX AND THE SUM OF THE MAXIMUM SUBARRAY 
				 int[] result =  {maxLeft, maxRight, leftSum + rightSum};
				
			  //THIS METHOD RETURNS THE RESULT VALUE.
				 return result;         
	}
}