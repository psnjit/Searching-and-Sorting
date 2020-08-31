//https://www.interviewbit.com/courses/1/topics/4/problems/painters-partition-problem/previous_submissions/

public class Solution {
    public int paint(int A, int B, ArrayList<Integer> C) 
    {
        long r=0, l=Integer.MIN_VALUE, ans=0;
        long mod=10000003;
        for(int i:C)
        {
            if(i>l)
            l=i;
            r+=i;
        }
        long mid;
        while(l<=r)
        {
            mid=(l+r)/2;
            if(valid(C, mid, A))
            {
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return (int)((ans*B)%mod);
    }
    public boolean valid(ArrayList<Integer> al, long mid, int k)
    {
        int sum=0, count=0;
        for(int i=0; i<al.size(); i++)
        {
            if((sum+al.get(i))>mid)
            {
                count++;
                sum=al.get(i);
            }
            else
            {
               sum+=al.get(i);
            }
        }
        return (count<k);
    }
}
