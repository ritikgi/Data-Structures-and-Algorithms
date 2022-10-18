//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] array = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.MissingNumber(array, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int MissingNumber(int arr[], int n) {
        /*
        Sort and search
        Arrays.sort(arr);
        int missing=0;
        for(int i =0;i<arr.length;i++)
        {
            if(arr[i] != i+1)
            {
                missing= i+1;
            }
        }
        return missing;
        */
        
        
        //Better Approach HashMap method we can use 
         
        
        //better approach --> sum of natural number but integer Overflow can be possible
        int realSum = n*(n+1)/2;
        int currSum = 0;
        for(int i =0; i<arr.length;i++)
        {
            currSum += arr[i];
        }
        return realSum-currSum;
        
        
        // Best Approach - XOR approach 
        
        
        
        
        
        
        
        
        
    }
}
