//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int s = sc.nextInt();

            int[] m = new int[n];
            for (int j = 0; j < n; j++) {
                m[j] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(m, n, s);
            for(int ii = 0;ii<res.size();ii++)
                System.out.print(res.get(ii) + " ");
            System.out.println();
        }
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int left=0,right=0;
        int current_sum=0;
        ArrayList<Integer> ans = new ArrayList<>();
        if(s ==0) {
            ans.add(-1);
            return ans;
        }
        while(right<n && left<n)
        {
            current_sum += arr[right];
            if(current_sum == s)
            {
                ans.add(left+1);
                ans.add(right+1);
                // System.out.println(left);
                return ans;
            }
            // else if(current_sum < s)
            // {

            //     current_sum += arr[right];
            //     right++;
            //     // System.out.println(right);
            // }
              else if (current_sum > s){
                // System.out.println(left);
                current_sum -= arr[left];
                current_sum -= arr[right];
                left++;
                right--;
                // System.out.println(left);
            }
            right++;
        }
        ans.add(-1);
        return ans;
    }
}