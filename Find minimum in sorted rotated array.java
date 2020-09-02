// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/submissions/ LC (number of times a sorted array has been rotated(with slight modification)
class Solution {
    public int findMin(int[] arr) 
    {
        int l=0,n=arr.length, r=n-1;
	    int mid;
	    while(l <= r)
	    {
	    	if(arr[l]<arr[r]) // if already sorted
	    		return arr[l];
	        mid=(l+r)/2;
	        int prev=(mid-1+n)%n;
	        if(arr[mid]<=arr[prev]) //if pivot found
	            return arr[mid];
	        if(arr[l]<=arr[mid]) //discard left side
	            l=mid+1;
	        if(arr[mid]<=arr[r]) //discard right side
	            r=mid-1;
	     }
	    return 0;
    }
}
