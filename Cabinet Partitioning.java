/*𝐂𝐚𝐛𝐢𝐧𝐞𝐭 𝐏𝐀𝐫𝐭𝐢𝐭𝐢𝐨𝐧𝐢𝐧𝐠 𝐮𝐬𝐢𝐧𝐠 𝐁𝐚𝐜𝐤𝐓𝐫𝐚𝐜𝐤𝐢𝐧𝐠 𝐚𝐩𝐩𝐫𝐨𝐚𝐜𝐡*/

import java.io.*;

public class Mathematics 
{
public static void main(String args[])
{
int arr[]= {3,5,2,7,1,9,4,8,10, 2, 7, 4};
int k=11;//no of people. So number of partition =k-1
solve(arr,arr.length, k, 0, 0);
System.out.println(ans);
}
static int ans=Integer.MAX_VALUE;
public static void solve(int arr[], int n, int k, int curAns, int index)
{
	if(k==1)
	{
		int sum=0;
		for(int i=index; i<n; i++)
		{
			sum+=arr[i];
		}
		curAns=(int)Math.max(curAns, sum);
		ans=(int)Math.min(ans,  curAns);
		return;
	}
	int sum=0;
	for(int i=index; i<(n-k+1); i++)
	{
		//System.out.println("i="+i+" n-k="+(n-k));
		sum+=arr[i];
		curAns=(int)Math.max(curAns, sum);
		solve(arr,n, k-1, curAns, i+1);
	}
}
}
