//we take the smallest array or list of the 2. iterate over it.
//p1 will divide a and p2 will divide b
//P1 and P2, p1 will change on the basis of hi and lo. 
//p2 will change as p1 changes

public class Solution {
    // DO NOT MODIFY BOTH THE LISTS
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) 
    {
        if(a.size()>b.size())
            return findMedianSortedArrays(b, a);
        int lo=0, hi=a.size();
        int p1, p2;
        int la, lb, ra, rb;
        while(lo <= hi)
        {
            p1=(lo+hi)/2;
            p2=(a.size()+b.size()+1)/2-p1;
            la= (p1==0) ? Integer.MIN_VALUE : a.get(p1-1);
            lb= (p2==0) ? Integer.MIN_VALUE : b.get(p2-1);
            ra= (p1==a.size()) ? Integer.MAX_VALUE : a.get(p1);
            rb= (p2==b.size()) ? Integer.MAX_VALUE : b.get(p2);
            
            if(la<=rb && lb<=ra)
            {
                return median(a.size(), b.size(), la, ra, lb, rb);
            }
            else
            if(la > rb)
                hi=p1-1;
            else
                lo=p1+1;
        }
        return 0;
    }
    
    double median(int n, int m, int la, int ra, int lb, int rb)
    {
        if((n+m)%2==0)
            return (Math.max(la, lb)+Math.min(ra, rb))/2.0;
        else
            return (Math.max(la, lb));
    }
}
