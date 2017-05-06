import java.util.*;

public class MergeSort{

       public static int counter = 0;
		public static void main(String args[]){
		            System.out.print("Enter the array size:");
					//Getting array size using standard input from the user
					Scanner userInput = new Scanner(System.in);
					int arrayLength = userInput.nextInt();
					//Array for the numbers to be storted
					int array[] = new int[arrayLength];
					System.out.print("\nUnsorted array:");
					for(int i=0;i<arrayLength;i++){
					       //Random function inserts the numbers into the array
							array[i]=(int)(Math.random()*20);
							//Print the array
							System.out.print(array[i]+" ");
					}
		            mergeSort(array,0,arrayLength-1);
					System.out.print("\nSorted array:");
					//Sorted elements of the array
					for(int i=0;i<arrayLength;i++){
					       System.out.print(array[i]+" ");
					}
					//counting the number of steps
					System.out.print("Counting number of steps:"+counter);
		}
public static void mergeSort(int[] array,int low,int high){
          int mid;
		    if(low<high){
			    mid = (low+high)/2;
				counter++;
				//Dividing the array using mergesort recursively into two halfs.Onw half from the beginning to the middle and other half from middle to the end
			    mergeSort(array,low,mid);
				mergeSort(array,mid+1,high);
				//Merge function merge the sorted array tohether into one.
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
	counter++;
   }
   //The remaining part is the left over elements of the array
   if(left<=mid){
     while(left<=mid){
	   temp[k]=array[left];
	   left=left+1;
	   k=k+1;
	   counter++;
	 }
   }else  if(right<=high){
     while(right<=high){
	   temp[k]=array[right];
	   right=right+1;
	   k=k+1;
	   counter++;
	 }
   }
   //Move all the sorted elements back to the array.
   for(int m=0;m<temp.length;m++)
     array[low+m]=temp[m];
	 /*int n1 = mid-low+1;
	 int n2 = high-mid;
	 int i,j;
	 int leftArray[] = new int[100];
	 int rightArray[] = new int[100];
     for(i=0; i<n1; i++){
             leftArray[i] = array[low+i-1];
     }
     for(j=0; j<n2;j++){
             rightArray[j] = array[mid+j];
     }
	 leftArray[n1+1] = 9999;
	 leftArray[n2+1] = 9999;
	 i = 0;
     j = 0;
     for (int k=low; k<=high; k++){
				if(leftArray[i]<=rightArray[j]){
						array[k] = leftArray[i++];
				}else{
                       array[k] = rightArray[j++];
				 }
	 }	*/	
}
}