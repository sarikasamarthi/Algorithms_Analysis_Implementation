 //IMPLEMENTATION OF HEAPSORT USING JAVA PROGRAMMING LANGUAGE.
 import java.util.*;
 public class HeapSort1
 { 
				static int[] a; 
				static int n; 
				static int left; 
				static int right;
				static int largest;
				static int counter=0;
				
			  //MAIN FUNCTION TAKES UNSORTED INPUT AND DISPLAYS SORTED ARRAY
				public static void main(String[] args) { 
			 
								// int []array={4,1,3,2,16,9,10,14,8,7}; 
		
								   System.out.print("Enter the array size:");
			  
								 //Getting array size using standard input from the user
								   Scanner userInput = new Scanner(System.in);
								   int arrayLength = userInput.nextInt();
								 //Array for the numbers to be storted
								   int array[] = new int[arrayLength];
		 
								   System.out.print("\nUnsorted array:");
								   System.out.println();
								   for(int i=0;i<arrayLength;i++){
													//Random function inserts the numbers into the array
													  array[i]=(int)(Math.random()*20);
													//Print the array
													  System.out.print(array[i]+" ");
									}
         
									sort(array); 
									
									System.out.println();
									System.out.print("\nSorted Array using Heapsort:");
									System.out.println();
									for(int i=0;i<arrayLength;i++){ 
													   System.out.print(array[i] + " "); 
									}
								
								  //COUNTING NUMBER OF STEPS USING HEAPSORT
								    System.out.println();
								    System.out.println("TOTAL STEPS:"+" "+counter);
				} 
	 
			  //BUILDMAXHEAP START BUILDING HEAP FROM HALF THE SIZE OF THE HEAPSIZE AND START MAXHEAPIFYING THE ARRAY
     
				public static void buildMaxHeap(int []a){ 
								n=a.length-1; 
								for(int i=n/2;i>=0;i--){ 
												    counter++;
													maxHeapify(a,i); 
								} 
				} 
     
			  //MAXHEAPIFY METHOD FOLLOWS PARENT TO BE GREATER THAN LEFT AND RIGHT NODES OTHERWISE SWAP THE NODES AND AGAIN CALL MAXHEAPIFY METHOD RECURSIVELY
				public static void maxHeapify(int[] a, int i){ 
	 
								//LEFT NODE TO THE PARENT IS AT 2i AND RIGHT NODE IS AT 2i+1
								  left=2*i; 
								  right=2*i+1; 
					
								//CHECKING WITH LEFT NODE WITH THE PARENT NODE,WHETHER IT IS GREATER OR NOT
								  if(left <= n && a[left] > a[i]){ 
												largest=left; 
								  }else{ 
												largest=i; 
								   } 
         
							    //CHECKING WITH RIGHT NODE WITH THE PARENT NODE,WHETHER IT IS GREATER OR NOT
								  if(right <= n && a[right] > a[largest]){ 
												counter++;
												largest=right; 
								  } 
					
								//IF BOTH LEFT AND RIGHT IS GREATER THAN PARENT THEN SWAPN THE NODE AND RECURSIVELY EXECUTE MAXHEAPIFY METHOD
								  if(largest!=i){ 
												counter++;
												swap(i,largest);
												maxHeapify(a, largest); 
								  } 
				} 
     
	 
			  //SWAP METHOD WHICH SWAP THE NODES
				public static void swap(int i, int j){
								
								int t=a[i]; 
								a[i]=a[j]; 
								a[j]=t; 
				} 
     
			  //SORT METHOD CALLS BUILDMAXHEAP METHOD AND PERFORM SWAP IF NECESSARY AND REDUCE THE HEAPSIZE AND PERFORM MAXHEAPIFY
				public static void sort(int []a1){ 
								a=a1; 
								buildMaxHeap(a); 
         
								for(int i=n;i>0;i--){ 
												counter++;
												swap(0, i); 
												n=n-1; 
												maxHeapify(a, 0); 
								} 
				} 
				
			  
 }
 