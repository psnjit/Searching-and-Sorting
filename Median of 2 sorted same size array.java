//=================IMPORTANT Announcement==================
//𝐒𝐨𝐥𝐯𝐞𝐝 𝐍𝐎𝐓 𝐮𝐬𝐢𝐧𝐠 𝐁𝐈𝐍𝐀𝐑𝐘 𝐒𝐄𝐀𝐑𝐂𝐇
//𝐓𝐡𝐢𝐬 𝐦𝐞𝐭𝐡𝐨𝐝 𝐰𝐨𝐫𝐤𝐬 𝐛𝐲 𝐟𝐢𝐫𝐬𝐭 𝐠𝐞𝐭𝐭𝐢𝐧𝐠 𝐦𝐞𝐝𝐢𝐚𝐧𝐬 𝐨𝐟 𝐭𝐡𝐞 𝐭𝐰𝐨 𝐬𝐨𝐫𝐭𝐞𝐝 𝐚𝐫𝐫𝐚𝐲𝐬 𝐚𝐧𝐝 𝐭𝐡𝐞𝐧 𝐜𝐨𝐦𝐩𝐚𝐫𝐢𝐧𝐠 𝐭𝐡𝐞𝐦.

import java.util.*;
import java.lang.*;
import java.io.*;
import java.lang.*;

public class Solution {
	public static void main (String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t -- > 0)
		{
		    int n=Integer.parseInt(br.readLine());
		    String s1[]=br.readLine().split(" ");
		    int arr1[]= new int[n];
		    for(int i=0; i<s1.length; i++)
		    {
		        arr1[i]=Integer.parseInt(s1[i]);
		    }
		    String s2[]=br.readLine().split(" ");
		    int arr2[]= new int[n];
		    for(int i=0; i<s2.length; i++)
		    {
		        arr2[i]=Integer.parseInt(s2[i]);
		    }
		    double res=getMedian(arr1, arr2, 0, n-1, 0, n-1);
		    System.out.println(res);
		}
	}
	public static double getMedian(int arr1[], int arr2[], int l1, int r1, int l2, int r2)
	{
		//incase given array is of length 1
	    if((arr1.length==1) || (arr2.length==1))
	    {
	        return (arr1[0]+arr2[0])/2.0;
	    }
	    //when the given array is of length 1 or subarray size becomes 2
	    if((r1-l1==1)||(r2-l2==1))
	    {
	        return (Math.max(arr1[l1],arr2[l2])+Math.min(arr1[r1],arr2[r2]))/2;
	    }
	    //calculating median of each array
	    float m1=median(arr1, l1, r1);
	    float m2=median(arr2, l2, r2);
	    //these 2 medians are equal
	    if(m1==m2)
	        return m1;
	    //if m1<m2, then median must lie between (right of m1 and r1) and (l2 and left of m2)
	    if(m1<m2)
	        return getMedian(arr1, arr2, (l1+r1+1)/2, r1, l2, (r1+l2+1)/2);
	    else
	    	//if m1>m2, then median must lie between (l1 and left of m1) and (right of m2 and r2)
	        return getMedian(arr1, arr2, l1, (l1+r1+1)/2, (r2+l2+1)/2, r2);
	}
	public static float median(int arr[], int l, int r)
	{
	    int n=(r+l);
	    //incase n is even return average of mid 2
	    if(n%2==0)
	    {
	        return (arr[n/2]+arr[n/2+1])/2;
	    }
	  //else return mid element
	    else
	    {
	        return (arr[n/2]);
	    }
	}
}
