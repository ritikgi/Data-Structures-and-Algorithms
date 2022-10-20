//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    String compareTwoString(String a, String b){
        String prefix = "";
        int i=0;
        while(i < a.length() && i<b.length())
        {
            if(a.charAt(i) == b.charAt(i))
            {
                prefix += a.charAt(i);
                i++;
            }
            else{
                break;
            }
        }
        return prefix;
    }
    
    String longestCommonPrefix(String arr[], int n){
        // code here
        String pre = arr[0];
        for(int i =1; i<n;i++)
        {
            pre = compareTwoString(pre,arr[i]);
        }
        if(pre == "") return "-1";
        return pre;
    }
}