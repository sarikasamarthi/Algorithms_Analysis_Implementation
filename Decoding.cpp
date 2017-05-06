//PROGRAM TO IMPLEMENT HUFFMAN'S DECODING USING VARIABLE LENGTH METHOD.THE USER SHOULD ENTER TOTAL NUMBER OF DIFFERENT CHARACTERS.AFTER THAT THE USER SHOULD ENTER THE CHARACTER AND THE CODE FOR EACH CHARACTER.THEN THE USER SHOULD ENTER THE ENCODED STRING AND HE GETS THE OUTPUT OF THE DECODED FORM.
#include<iostream>
#include<map>

using namespace std;

int main(){    
      int i,j,k,a,b,n;
      char c;   
      string s,t,ans; 
      
      map <string, char> mymap; 
      map <string, char> :: iterator it;  
                    
      cout << "Enter the no. different types of characters: ";   
      cin >> n;    
      
      for( i = 0; i < n; i++ ) {   
           cout << "Enter the " << i+1 << " character and its code: "; 
           cin >> c >> s;       
           mymap[s] = c;    
      }    
      
      cout << "Enter the encoded string: "; 
      cin >> s;     
      
      t = "";   
      ans = "";  
      
      for( i = 0; i < s.size(); i++ ) {       
      
           t += " "; 
           t[t.size()-1] = s[i]; 
           it = mymap.find(t);       
                                  
           if( it != mymap.end() ) { 
               
               c = mymap[t]; 
               ans += " "; 
               ans[ans.size()-1] = c; 
               t = "";   
           }   
      }     
      
      cout << "Deocde value:"<<ans ;
      
      return 0;
}
