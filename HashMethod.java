//PROGRAM IN JAVA TI IMPLEMENT DIFFERENT HASH FUNCTIONS LIKE DIVISION METHOD,MULTIPLICATION METHOD AND QUADRATIC PROBING METHOD.USING HASH FUNCTION FOR STUDENTID'S.CALCULATING PRIME NUMBER FOR ARRAY SIZE.ENTERING THE STUDENTIID'S WHICH ARE GENERATED RANDOMLY.DISPLAYING THE STUDENTID'S WITH THE STRUCTURE.SEARCHING THE STUDENTID IN THE ARRAY
import java.util.*;
public class HashMethod extends StudentInfo{

	public static void main(String args[]){
		
	     int num1,num2,temp=0;
		 boolean flag=true;
		 
		 Scanner userInput = new Scanner(System.in);
		 System.out.println("\n PROGRAM TO FIND PRIME NUMBERS BETWEEN THE RANGE:");
         
		 System.out.println("\n ENTER FIRST +VE NUMBER:");
		 num1=userInput.nextInt();
         System.out.println("\n ENTER SECOND +VE NUMBER:");
         num2=userInput.nextInt();
		 
	   //LOOP FOR FINDING PRIME NUMBERS IN THE RANGE
		 for(int i=num1;i<=num2;i++){
				for(int j=2;j<i;j++){
                    flag=false;
					if(i%j==0){
						flag=true;
						break;
					}                            
				}
				if(flag==false)
					System.out.println("\n prime number"+" "+i);      
		}
		
		System.out.println("\nCHOOSE ARRAY SIZE(m) FROM THE PRIME NUMBERS WHICH IS NOT CLOSE TO POWER OF 2:");
		int m = userInput.nextInt();
		int n=150;//TOTAL NUMBER OF STUDENTS
		
	  //USER SELECTS THE OPTION BETWEEN THE THREE METHODS OR EITHER EXITS
		int option = 5;		
		while(true){
				
				System.out.println("\nOPTION1:DIVISION METHOD");
				System.out.println("\nOPTION2:MULTIPLICATION METHOD");
				System.out.println("\nOPTION3:QUADRATIC PROBING");
				System.out.println("\nOPTION4:EXIT");
				System.out.println("\nENTER YOUR CHOICE:");
				option = userInput.nextInt();
		
				switch(option){
				
					case 1 : divisionMethod(m,n);
							 break;
						 
					case 2 : multiplicationMethod(m,n);
						     break;
					
					case 3:  quadraticProbingMethod();
							 break;
				
					case 4 : System.exit(option);
						     break;
					
					default : System.out.println("\nPLEASE CHOOSE FROM EXISTING CHOICES");
						  break;
				}
		}
	}
	
  //MULTIPLICATION METHOD IS USED TO CALCULATE HASH FUNCTION WHICH USES EXTRA VARIABLE A
	public static void multiplicationMethod(int m,int n){
	
	    final double A = 0.6180339887;
		
		StudentInfo[] info = new StudentInfo[m];
		for(int i = 0; i < info.length; i++)
			info[i] = new StudentInfo();
		
		while(true){
		
		
			Random random = new Random();
			int studentId = random.nextInt(899999) + 100000;
			
			int key = (int) (m * (studentId * A % 1));
			
			info[key].hashStudent(studentId);
			
			n--;
			
			if(n == 0)
				break;
			
		}
			    
		for(int i = 0; i < info.length; i++){
			
			System.out.print("\nIndex " + i + " has ");
			info[i].printStudent();
		}
		
		int key = 0;
	
	    while(true){	
			
			int flag=1;
			
			Scanner input = new Scanner(System.in);
			System.out.println("\nDO YOU WANT TO SEARCH FOR STUDENTID:1/0");
			flag = input.nextInt();
			
			if(flag == 1){
				System.out.print("\n\n\nEnter a StudentID to search ");
		
				int id = input.nextInt();
		
				double val = 50000;

				for (int i = 0; i< val; i++){
			
					key = (int) (m * (id * A % 1));

					int a = info[key].searchStudent(id);

					if(a == 1){
						
						System.out.println("StudentID found");
						break;
					}else{
						
						System.out.println("StudentID not found");
						break;
					 }
		        }
			}
			if(flag == 0)
				break;
		}
	}//END OF MULTIPLICATION METHOD
	

  //DIVISION METHOD TO CALCULATE HASH FUNCTION,REST IS SIMILAR TO MULTIPLICATION METHOD
	public static void divisionMethod(int m,int n){
	
		StudentInfo[] info = new StudentInfo[m];
		for(int i = 0; i < info.length; i++)
			info[i] = new StudentInfo();
		
		while(true){
			
			Random random = new Random();
			int studentId = random.nextInt(899999) + 100000;
			int key = studentId % m;
			info[key].hashStudent(studentId);
			
			n--;
			
			if(n == 0)
				break;
			
		}
		
	  //FOR PRINTING STUDENT INFO IN HASH TABLE ALONG WITH LINKED LIST CONTAINING STUDENTINFO
		for(int i = 0; i < info.length; i++) 
		{
			System.out.print("\nIndex " + i + " has ");
			info[i].printStudent();
		}
		
		int key = 0;
		
	  //FROM HERE SEARCH FOR STUDENTID TAKES PLACE
		while(true){	
			
			int flag=1;
			
			Scanner input = new Scanner(System.in);
			System.out.println("\nDO YOU WANT TO SEARCH FOR STUDENTID:1/0");
			flag = input.nextInt();
			
			if(flag == 1){		
					System.out.print("\n\n\nEnter a StudentID to search ");
					int id = input.nextInt();
		
					double val = 50000;

					for (int i = 0; i < val; i++){
			
						key = id % m;

						int a = info[key].searchStudent(id);

						if(a == 1){
				
								System.out.println("StudentID found");
								break;
						}else{
								System.out.println("StudentID not found");
								break;
						 }
					}
			}
			if(flag == 0)
				break;
		}
	}//END OF DIVISION METHOD
	
  //START OF QUADRATIC PROBING METHOD WHICH DOESN'T USE LINKED LIST BUT DIRECTLY INSERTS DATA INTO THE TABLE BASED ON THE KEY AND REST IS SIMILAR TO ABOVE TWO METHODS
	public static void quadraticProbingMethod(){	
	    
		Scanner userInput = new Scanner(System.in);
		System.out.println("\nENTER TOTAL NUMBER OF STUDENTS:");
		int n1 = userInput.nextInt();
		System.out.println("\nENTER HASH TABLE SIZE:");
		int m1 = userInput.nextInt();
		
		StudentInfo[] info = new StudentInfo[m1];
		for(int i = 0; i < m1; i++)
			info[i] = new StudentInfo();
		
		while(true){
			
			Random random = new Random();
			int studentId = random.nextInt(899999) + 100000;
			
			int key = studentId%m1;
			
			int flag = info[key].quadraticHash(studentId);
			
			while(flag == 0 && key<=m1){
				
				key++;
				flag=info[key].quadraticHash(studentId);
				if(flag == 1)
					break;
			}
			if(flag == 1){
				
				n1--;
			}
			if(n1 <= 0)
				break;
			if(key == m1)
				key=0;
		}
		
		for(int i = 0; i < info.length; i++){
			System.out.print("\nIndex " + i + " has ");
			info[i].printStudent();
		}
		
		int key = 0;
		
		while(true){	
			
			int flag=1;
			
			Scanner input = new Scanner(System.in);
			System.out.println("\nDO YOU WANT TO SEARCH FOR STUDENTID:1/0");
			flag = input.nextInt();
			
			if(flag == 1){	
		
					System.out.print("\n\n\nEnter a StudentID to search ");
				
					int id = userInput.nextInt();
		
					double val = 50000;

					for (int i = 0; i < val; i++){
			
							key = id % m1;

							int a = info[key].searchQuadratic(id,m1);

							if(a == 1){
				
									System.out.println("StudentID found");
									break;
							}else{
				
									System.out.println("StudentID not found");
									break;
							 }
					}
			}
			if(flag == 0)
				break;
		}
		
	}//END OF QUADRATIC PROBING METHOD
}