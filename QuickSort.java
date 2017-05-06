//PROGRAM TO IMPLEMENT QUICKSORT AND CALCULATE ACTUAL COMPUTING TIME IN TERMS OF COUNTING STEPS.ALSO INCLUDED MERGESORT AND HEAPSORT ALONG WITH THEIR COUNTING STEPS.USED SAME INPUT ARRAY FOR QUICKSORT,HEAPSORT AND MERGESORT FUNCTIONS,WHICH IS RANDOMLY GENERATED
import java.util.*;

class QuickSort{
	
	  //COUNTER FOR ACTUAL COUNTING FOR QUICKSORT
		public static int counter1 = 0;
		
	  //COUNTER FOR ACTUAL COUNTING FOR MERGESORT
		public static int counter2 = 0;
		
	  //COUNTER FOR ACTUAL COUNTING FOR HEAPSORT
		static int counter3=0;
		
	  //SOMEMORE GLOBAL VARIABLES FOR HEAPSORT FUNCTION
		static int[] a; 
		static int n;
		static int largest;
	  //static int left; 
	  //static int right;
				
				
		public static void main(String args[]){
	
				System.out.print("\nEnter the array size:");
			  
			  //GETTING INPUT FROM THE USER FOR ARRAY SIZE					
				Scanner userInput = new Scanner(System.in);
				int arrayLength = userInput.nextInt();
			  
			  //ARRAY FOR INPUT NUMBERS
				int array[] = new int[arrayLength];
				
				System.out.print("\nUnsorted array:");
				for(int i=0;i<arrayLength;i++){
			  //RANDOM FUNCTION INSERTS RANDOM NUMBERS INTO THE INPUT ARRAY
						array[i]=(int)(Math.random()*200);
					  //PRINT THE ARRAY
						System.out.print(array[i]+" ");
				}
				
			  //CALL THREE METHODS QUICKSORT,MERGESORT AND HEAPSORT,PROVIDED WITH SAME INPUT ARRAY FOR COMPARING ACTUAL COMPUTING
				quickSort(array,0,arrayLength-1);
				mergeSort(array,0,arrayLength-1);
				heapSort(array); 
				
				System.out.print("\nSorted array:");
			  //SORTED NUMBERS
				for(int i=0;i<arrayLength;i++){
					    System.out.print(array[i]+" ");
				}
				
			  //COUNTING STEPS FOR QUICKSORT,MERGESORT AND HEAPSORT
				System.out.print("\n QUICKSORT ACTUAL COUNTING:"+counter1);
				
				System.out.print("\n MERGESORT ACTUAL COUNTING:"+counter2);
				
				System.out.print("\n HEAPSORT ACTUAL COUNTING:"+counter3);
		}
		
	  //START OF QUICKSORT PROCEDURES:QUICKSORT AND PARTITION PROCEDURES
		public static void quickSort(int[] a,int low,int high){
		
				if(low<high){
				 
				  //COUNTER TO COUNT THE ACTUAL COMPUTING OF THE QUICKSORT
				    counter1++;
					
				  //CALLING PROCEDURE TO FIND PIVOT
					int p=partition(a,low,high);                       
				  
				  //CALLS ITSELF RECURSICELY
					quickSort(a,low,p-1);                             
					quickSort(a,p+1,high);			              
				}
		}
		
		public static int partition(int[] a,int low,int high){
				
				int p=low, pivot=a[high], loc;

				for(loc=low+1;loc<=high;loc++){
				
					counter1++;
						
					if(a[loc]<pivot){
								
						a[p]=a[loc];
						a[loc]=a[p+1];
						a[p+1]=pivot;

						p=p+1;
					}
				}
				return p;
		}//END OF QUICKSORT PROCEDURES
		
	  //START OF MERGESORT PROCEDURES:MERGESORT AND MERGE PROCEDURES
		public static void mergeSort(int[] array,int low,int high){
            
			int mid;
		    if(low<high){
			
				mid = (low+high)/2;
				counter2++;
				
			  //DIVIDING THE ARRAY RECURSIVELY.ONE HALF FROM STARING TO MIDDLE AND ANOTHER FROM MIDDLE TO END
				mergeSort(array,low,mid);
				mergeSort(array,mid+1,high);
			  //MERGE FUNCTION MERGE THE SORTED ARRAY TOGETHER INTO ONE
				merge(array,low,mid,high);
			}
		}
		
		public static void merge(int[] array,int low,int mid,int high){
			
			  //Used temp array to store sorted elements
				int temp[] = new int[high-low+1];
			  //Compare left half of the array with right half of the array,which ever side value is smaller ,increment their index by one.
				int left = low;
				int right = mid+1;
				int k=0;
				
				while(left<=mid && right <=high){
					
					if(array[left]<array[right]){
						
						temp[k]=array[left];
						left = left+1;
					}else{
						
						temp[k]=array[right];
						right=right+1;
					 }
					
					k=k+1;
					counter2++;
				}
				
			  //The remaining part is the left over elements of the array
				if(left<=mid){
				
					while(left<=mid){
						    
						temp[k]=array[left];
						left=left+1;
						k=k+1;
						counter2++;
					}
				}else  if(right<=high){
					
					while(right<=high){
						
						temp[k]=array[right];
						right=right+1;
						k=k+1;
						counter2++;
					}
				 }
   
			  //Move all the sorted elements back to the array.
				for(int m=0;m<temp.length;m++)
					array[low+m]=temp[m];	
		}//END OF MERGESORT PROCEDURES

	  //START OF HEAPSORT PROCEDURES:BUILDMAXHEAP,MAXHEAPIFY,SWAP AND HEAPSORT 
		public static void buildMaxHeap(int []a){ 
				
				n=a.length-1; 
				
				for(int i=n/2;i>=0;i--){ 
					
					counter3++;
					maxHeapify(a,i); 
				} 
		} 
     
	  //MAXHEAPIFY METHOD FOLLOWS PARENT TO BE GREATER THAN LEFT AND RIGHT NODES OTHERWISE SWAP THE NODES AND AGAIN CALL MAXHEAPIFY METHOD RECURSIVELY
		public static void maxHeapify(int[] a, int i){ 
	 
		  //LEFT NODE TO THE PARENT IS AT 2i AND RIGHT NODE IS AT 2i+1
			int left=2*i; 
			int right=2*i+1; 
					
		  //CHECKING WITH LEFT NODE WITH THE PARENT NODE,WHETHER IT IS GREATER OR NOT
			if(left <= n && a[left] > a[i]){ 
								             
			  //counter3++;
				largest=left; 
			}else{ 
				
				largest=i; 
			 } 
         
		  //CHECKING WITH RIGHT NODE WITH THE PARENT NODE,WHETHER IT IS GREATER OR NOT
			if(right <= n && a[right] > a[largest]){ 
				
			  //counter3++;
				largest=right; 
			} 
					
		  //IF BOTH LEFT AND RIGHT IS GREATER THAN PARENT THEN SWAPN THE NODE AND RECURSIVELY EXECUTE MAXHEAPIFY METHOD
			if(largest!=i){ 
			  
			  //counter3++;
				swap(i,largest);
				maxHeapify(a, largest); 
			} 
			
			counter3++;
		} 
     
	 
	  //SWAP METHOD WHICH SWAP THE NODES
		public static void swap(int i, int j){
								
			int t=a[i]; 
			a[i]=a[j]; 
			a[j]=t; 
		} 
     
	  //SORT METHOD CALLS BUILDMAXHEAP METHOD AND PERFORM SWAP IF NECESSARY AND REDUCE THE HEAPSIZE AND PERFORM MAXHEAPIFY
		public static void heapSort(int []a1){ 
			
			a=a1; 
			buildMaxHeap(a); 
         
			for(int i=n;i>0;i--){ 
				
				counter3++;
				swap(0, i); 
				n=n-1; 
				maxHeapify(a, 0); 
			} 
		} //END OF HEAPSORT PROCEDURES
				
}