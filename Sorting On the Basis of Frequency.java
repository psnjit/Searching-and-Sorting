import java.io.*;
import java.util.*;

public class Solution 
{
    public static void main(String[] args) throws IOException
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            int n= Integer.parseInt(br.readLine());
            
            String input[]= br.readLine().split(" ");
            
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i]=Integer.parseInt(input[i]);
            
            HashMap<Integer, Integer> hm= new HashMap<>();
            ArrayList<Integer> al= new ArrayList<>(); 
            //ArrayList is needed because HashMap cannot be sorted, so we put all the elements from array to the arraylist and
            //sort it as the same order as the hashmap hm would be sorted.
            
            for(int i: arr)
            {
                   int val=hm.getOrDefault(i, 0)+1;
                    hm.put(i, val);
                    al.add(i);
            }
            Collections.sort(al, new CustomComparator(hm));
            for(int i:al)
                System.out.print(i+" ");
            System.out.println();
        }
    }
}
 //a custom comparator class for sorting first on the basis of frequency incase freqency is same sort on the basis of value
class CustomComparator implements Comparator<Integer>
{
        private HashMap <Integer, Integer> res= new HashMap<>();
        CustomComparator(HashMap<Integer, Integer> hm)
        {this.res=hm;}
        @Override
        public int compare(Integer a, Integer b) 
        {
            int fcount= res.get(a).compareTo(res.get(b));
            int vcount= a.compareTo(b);
        
            if(fcount==0)
                return vcount;
            else 
                return fcount;
        } 
}
