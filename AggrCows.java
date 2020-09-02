/* Aggressive cows SPOJ- https://www.spoj.com/problems/AGGRCOW/  Solved uisng Binary Search*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class aggrcows
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br= new BufferedReader(new InputStreamReader (System.in));
		int t=Integer.parseInt(br.readLine());
		while(t -- > 0)
		{
			String s[]= br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int k=Integer.parseInt(s[1]);
			int arr[]= new int[n];
			int l=Integer.MAX_VALUE, r=0;
			for(int i=0; i<n; i++)
			{
				arr[i]=Integer.parseInt(br.readLine());
				//System.out.println(arr[i]+"-");
			}
			Arrays.sort(arr);
			for(int i=0; i<n-1; i++)
			{
				int diff=arr[i+1]-arr[i];
				if(diff < l)
					l=diff;
			}
			r=arr[n-1];
			//System.out.print("l= "+l+"r= "+r+" ");
			int ans=0, mid;
			while(l<=r)
			{
				mid=(l+r)/2;
				//System.out.println("mid= "+mid);
				if(valid(arr, mid, k))
				{
					ans=mid;
					l=mid+1; //if mid is valid solution then check if mid+1 is also valid, As we need to get maximum of minimum distance between the cows
				}
				else
				r=mid-1;
			}
			System.out.println(ans);
		}
	}
	public static boolean valid(int arr[], int mid, int k)
	{
		int i=0, j=1, count=1;
		while(j<arr.length)
		{
			if((arr[j]-arr[i]) >= mid)//if ditance between the 2 cows is atleast mid
				{
					count++;
					i=j;
				}
			j++;
		}
		//System.out.println("count= "+count);
		return (count>=k);
	}
}
