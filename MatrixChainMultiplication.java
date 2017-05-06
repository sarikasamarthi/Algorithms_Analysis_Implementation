//PROGRAM TO IMPLEMENT MATRIX CHAIN MULTIPLICATION IN JAVA.fOLLOWED THE ALGORITHM
import java.util.*;

public class MatrixChainMultiplication
{
	public static void main(String[] args) 
	{

		Scanner input = new Scanner(System.in);
		
		System.out.println( "ENTER ARRAY LENGTH:" );
        
		Scanner userInput=new Scanner(System.in);
		int len = userInput.nextInt();
        int m[][]=new int[len+len][len+len];
		int s[][]=new int[len+len][len+len];
        int c[] = new int[len+len]; 

		
        for (int i = 0 ; i < c.length-len; i++ ){
			System.out.println( "Enter element number " +(i+1));
			c[i] = userInput.nextInt();
        		}

		int M, N = 6;
	
		for(int l = 1; l <= N; l++)
			m[ l ][ l] = 0;
	
		for(int k = 1; k < N; k++)
			for(int l = 1; l<= N - k; l++)
			{
				int r = l + k;
				m[ l ][ r ] = 2147778;
				
				for(int i = l; i < r; i++)
				{
					M = m[ l][ i ] + m[ i + 1 ][ r ] + c[ l- 1 ] * c[ i ] * c[ r];
					
					if( M < m[ l ][ r ] )
					{
						m[ l ][ r ] = M;
						s[ l][ r ] = i;
					}
				}
			}


		System.out.println("\n************************************************ ");
		System.out.print("*                  M Matrix                    *\n");
		System.out.println("************************************************ \n\n");

		for(int i = 1; i <= 6; i++ )
		{
			for(int j = 1; j <= 6; j++ ){
				if(i <= j)
					System.out.print( m[ i ][ j ]+ "\t" );
				else
					System.out.print( "\t" );
			}
			System.out.println("\n");
		}
		
		System.out.print("\n************************************************ \n");
		System.out.print("*                  S Matrix                    *");
		System.out.print("\n************************************************ \n\n");

		for(int i = 1; i <= 6; i++ )
		{
			for(int j = 1; j <= 6; j++ ){
				if( i<=j )
					System.out.print( s[ i ][ j ]+ "\t" );
				else
					System.out.print( "\t" );
			}
			System.out.println("\n");
		}

	}
}
