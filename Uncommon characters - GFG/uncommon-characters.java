//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String A = sc.next();
                    String B = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.UncommonChars(A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        String ans ="" ;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(int i =0; i<A.length(); i++)
        {
            freq1[A.charAt(i) - 'a'] = 1;
        }
        for(int i =0; i<B.length(); i++)
        {
            freq2[B.charAt(i) - 'a'] = 1;
        }
        
        for(int i =0; i<26; i++)
        {
            if( (freq1[i]^freq2[i]) != 0)
            {
                ans += (char)('a'+i);
            }
        }
        return (ans.length()==0) ? "-1" : ans;
        }
}