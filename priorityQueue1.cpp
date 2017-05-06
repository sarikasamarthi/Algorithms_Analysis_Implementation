//PROGRAM TO IMPLEMENT PRIORITY QUEUE USING HEAP.INSERTING NODES INTO HEAP,MAXIMIZING THE HEAP AND EXTRACTING MAXIMUM NODE FROM THE HEAP AND DISPLAYING REMAINING NODES.NODES CONTAIN THE INFORMATION OF THE JOBNAME,JOBNO AND PRIORITY.BASED ON PRIORITY THE PROGRAM IS MANIPULATED
#include<iostream>

using namespace std;

//STRUCTURE FOR NODE WITH JOBNAME,JOBNO AND PRIORITY
struct Node{
              int jobNo;
              string jobName;
              int priority;
              Node *left;
              Node *right;
           };
           
//PROTOTYPE FOR THE FUNCTIONS THAT ARE BEEN USED IN THIS PROGRAM
void buildMaxHeap(struct Node[]);
void maxHeapify(struct Node[],int);
void heapExtractMax(struct Node[]);
void heapSort(struct Node[]);
void displayHeap(struct Node[],int);
void heapInsert(int);

//GLOBAL VARIABLES WHICH IS ACCESSIBLE FOR ALL THE FUNCTIONS
static int heapsize=0;
static int largest,n;

//CHAR ARRAY USED FOR JOBNAME,WHICH IS RANDOMLY GENERATED FROM THIS ARRAY
static const char alphanum[] = "0123456789"
                               "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                               "abcdefghijklmnopqrstuvwxyz";

//BUILDMAXHEAP BUILDS THE HEAP FROM LAST BUT NOT LEAST LEVEL,AND CALL THE FUNCTION MAXHEAPIFY WHICH FOLLOWS HEAP PROPERTY WHERE FIRST NODE IS THE MAXIMUM NODE AND THE PARENT NODE IS GREATER THAN CHILD NODES.
void buildMaxHeap(struct Node s[]){  
                        
                         n=heapsize-1;
                         cout<<"\nNumber of Nodes:"<<n;
                         for(int i=n/2;i>=0;i--){ 
										maxHeapify(s,i); 
                         }
} 

//MAXHEAPIFY WILL COMPARE ALL THE NODES AND SWAP THE NODES BASED ON THE CONDITION
void maxHeapify(struct Node sb[], int i){ 
                         
                         int left,right;
                         
                       //LEFT NODE TO THE PARENT IS AT 2i AND RIGHT NODE IS AT 2i+1
                         left=2*i; 
                         right=2*i+1; 
					
					  //CHECKING WITH LEFT NODE WITH THE PARENT NODE,WHETHER IT IS GREATER OR NOT
				        if(left <= n && sb[left].priority > sb[i].priority){ 
						        largest=left; 
                        }else{ 
						        largest=i; 
                         } 
         
			          //CHECKING WITH RIGHT NODE WITH THE PARENT NODE,WHETHER IT IS GREATER OR NOT
                        if(right <= n && sb[right].priority > sb[largest].priority){ 
												
								largest=right; 
				        } 
					
	                  //IF BOTH LEFT AND RIGHT IS GREATER THAN PARENT THEN SWAPN THE NODE AND RECURSIVELY EXECUTE MAXHEAPIFY METHOD
			            if(largest!=i){ 
									//SWAP THE NODES BETWEEN I AND LARGEST.SWAP ALL THE JOBNO,JOBNAME AND PRIORITY
									struct Node t;
                                    t.jobName=sb[i].jobName; 
    								sb[i].jobName=sb[largest].jobName; 
    								sb[largest].jobName=t.jobName; 
    								
    								t.jobNo=sb[i].jobNo;
    								sb[i].jobNo=sb[largest].jobNo;
    								sb[largest].jobNo=t.jobNo;
    								
    								t.priority=sb[i].priority;
    								sb[i].priority=sb[largest].priority;
    								sb[largest].priority=t.priority;
    								
    								maxHeapify(sb, largest); 
			            } 
} 

   
//SORT FUNCTION WILL BUILD HEAP AND SORT ALL THE NODES COMPLETELY.
void heapSort(struct Node sb[]){ 
                                    buildMaxHeap(sb); 
         
								    for(int i=n;i>0;i--){ 
									        //swap(0, i); 
									        
									        struct Node t;
                                    t.jobName=sb[0].jobName; 
    								sb[0].jobName=sb[i].jobName; 
    								sb[i].jobName=t.jobName; 
    								
    								t.jobNo=sb[0].jobNo;
    								sb[0].jobNo=sb[i].jobNo;
    								sb[i].jobNo=t.jobNo;
    								
    								t.priority=sb[0].priority;
    								sb[0].priority=sb[i].priority;
    								sb[i].priority=t.priority;
    								
    								
									        n=n-1; 
									        maxHeapify(sb, 0); 
			                        } 
}
                                
//HEAPEXTRACTMAX WILL DISPLAY HIGHEST PRIORITY JOB FROM THE QUEUE AND SEND IT TO THE EXECUTION                                                          
void heapExtractMax(struct Node sb[]){
                           if(heapsize==0){
                                           cout<<"\nHEAP UNDERFLOW";
                                           exit(0);
                           }
     
                           struct Node max;
                           max=sb[heapsize-1];
                           sb[heapsize-1]=sb[0];
                           
                           cout<<"\nHIGHEST PRIORITY JOB READY FOR EXECUTION IS:"<<"\n"<<max.jobName<<"        "<<max.jobNo<<"      "<<max.priority;
                          
                           heapsize=heapsize-1;
                           maxHeapify(sb,1);
}

//DISPLAYHEAP FUNCTION DISPLAY REST OF THE NODES OTHER THAN HIGHEST PRIORITY JOB WHICH JUST BEEN TAKEN OUT OF THE QUE FOR EXECUTION.
void displayHeap(struct Node sb[]){

                        cout<<"\nDISPLAYING REST OF THE JOBS REMAINING IN THE QUEUE READY FOR EXECUTION";
                        cout<<"\nJOBNAME"<<"           "<<"JOBNO"<<"           "<<"PRIORITY";
                        cout<<"\n";
                        
                        for(int i=0;i<heapsize;i++){
                                cout<<"\n"<<sb[i].jobName<<"          "<<sb[i].jobNo<<"         "<<sb[i].priority;
                                cout<<"\n";
                        }
}

/*void heapInsert(struct Node sb[],int k){
                    
                    char *temp;
                   // heapsize=0;
                    //Node sb[100];
                    cout<<heapsize<<sb[k].priority;
                    for(int i=0;i<k;i++){                               
                            sb[heapsize].jobNo=rand();
                                                                 
                            for (int j=0;j<k;++j) 
                                temp[j]= alphanum[rand() % (sizeof(alphanum) - 1)];
                                                                 
                                                                 
                            sb[heapsize].jobName=temp;
                            sb[heapsize].priority=rand();
                                                                
                            heapsize++;
                    }
}*/

int main()
          {
                     int arrayLength;
                    char *temp;
                     struct Node s[100];
                     int option=1;
                    // heapsize=0;
                    
                    //BASED ON USER CHOICE WHETHER IT IS INSERTION INTO HEAP,EXTRACTING MAXIMUM NODE OR DISPLAYING NODES IN THE QUEUE OR EXITING FROM THE QUEUE
                     while(option){
                                   cout<<"\nOPTION1:INSERT NODE";
                                   cout<<"\nOPTION2:BUILD MAX HEAP";
                                   cout<<"\nOPTION3:EXTRACT MAXIMUM NODE";
                                   cout<<"\nOPTION4:DISPLAY REMAINING NODES";
                                   cout<<"\nOPTION5:EXIT";
                                   cout<<"\nCHOOSE YOUR OPTION:";
                                   cin>>option;
                                   switch(option){
                                                 //CASE FOR NODE INSERTION INTO THE HEAP
                                                  case 1:
                                                         cout<<"\nENTER NUMBER OF JOBS IN PRIORITY QUEUE:";
                                                         cin>>arrayLength;
                                                         /*int max,min;
                                                         cout<<"\nENTER THE RANGE FOR CHOOSING PRIORITY NUMBER:";
                                                         cin>>max;
                                                         cin>>min;*/
                                                         
                                                         //heapInsert(s,arrayLength);
                                                       //INSERTING NODES IN TO THE HEAP WITH JOBNAME,JOBNO AND PRIORITY.JOBNAME,JOBNO AND PRIORITY ARE RANDOMLY GENERATED TO SAVE SOME TIME FROM ENTERING FROM THE KEYBOARD                                   
                                                         for(int i=0;i<arrayLength;i++){
                                                                 
                                                                 s[heapsize].jobNo=rand();
                                                                 
                                                                 for (int j = 0; j < arrayLength; ++j) 
                                                                         temp[j]= alphanum[rand() % (sizeof(alphanum) - 1)];
                                                                 
                                                                 
                                                                 s[heapsize].jobName=temp;
                                                                 s[heapsize].priority=rand();
                                                                 
                                                                 heapsize++;
                                                          }
                                                          break;
                                                  
                                                  //SORTING THE NODES IN THE HEAP                          
                                                  case 2:           
                                                          heapSort(s);
                                                          break;
                                                  
                                                  //EXTRACTING MAXIMUM NODE FROM THE QUEUE BASED ON PRIORITY                          
                                                  case 3:
                                                          heapExtractMax(s);
                                                          break;
                                                  //DISPLAY THE NODES IN THE HEAP                          
                                                  case 4: 
                                                          displayHeap(s);
                                                          break;
                                                  //EXITING FROM THE CHOICES                      
                                                  case 5:
                                                           exit(0);
                                                           break;
                                                  
                                                  //WRONG CHOICE CHOOSEN FROM THE USER         
                                                  default:
                                                                 
                                                           cout<<"\nPLEASE CHOOSE FROM EXISTING CHOICES";
                                                           break;
                                   }
                     }
                     return 0;
}



