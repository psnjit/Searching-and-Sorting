// https://www.hackerrank.com/contests/smart-interviews/challenges/si-finding-the-floor/problem
//Binary Search usage

import java.io.*;
import java.util.*;

public class Solution {
    public static int search(int arr[], int k)
    {
        int l=0, r=arr.length-1, mid=0, value=Integer.MIN_VALUE;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(mid!=(arr.length-1))
            {
                if(arr[mid]<=k && arr[mid+1]>k)
                return arr[mid];
            }
            if(arr[mid]<k)
                l=mid+1;
            else if(arr[mid]>k)
                r=mid-1;
        }
        return value;
    }
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
            String input[]= br.readLine().split(" ");
            int arr[]= new int[input.length];
            for(int i=0; i<input.length; i++)
            {
                arr[i]=Integer.parseInt(input[i]);
            }
        Arrays.sort(arr);
        t=Integer.parseInt(br.readLine());
        while(t-- >0)
        {   
            int k=Integer.parseInt(br.readLine());
            //System.out.println(k);
            if(arr[arr.length-1]<=k)
                System.out.println(arr[arr.length-1]);
            else
                System.out.println(search(arr, k));
        }
    }
}
