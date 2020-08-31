public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) 
    {
        int l=0, r=a.size()-1;
        int mid=0;
        int ans=-1; 
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a.get(mid)==b)
            {
                return mid;
            }
            if(a.get(mid)<b)
                {ans=mid; l=mid+1;}         
            else
                r=mid-1;
        }
        return ans+1;
    }
}

/*
=====Another solution====
int l=0, r=a.size()-1;
int mid=0, ans=a.size();
        while(l<=r)
        {
            mid=(l+r)/2;
            if(a.get(mid)==b)
            {
                return mid;
            }
            if(a.get(mid)>b)
                {ans=mid; r=mid-1;}
            else
                l=mid+1;
        }
        return ans;
*/
