//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            long a[] = new long[(int)(n)];
            long b[] = new long[(int)(n)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                b[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.minValue(a, b, n));
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {

    public long minValue(long a[], long b[], long n) 
    {
        // Your code goes here
        long total=0;
        int low=0,high=(int)(n-1);
        //sorting array1 in desecnding order
        Arrays.sort(a);
        while(low<high)
        {
            long temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
        
        //sorting array 2 in acsending order
        Arrays.sort(b);
        
        for(int i =0; i<n;i++)
        {
            total += a[i]*b[i];
        }
        return total;

    }
}