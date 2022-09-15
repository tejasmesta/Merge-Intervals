class Solution {
    public int[][] merge(int[][] intervals) 
    {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        List<int[]> l = new ArrayList<>();    
        
        for(int interval[]:intervals)
        {
            int n = l.size()-1;
            if(l.size()==0)
            {
                l.add(interval);
            }
            else if(interval[0]>l.get(n)[0] && interval[1]<l.get(n)[1])
            {
                continue;
            }
            else if(interval[0]>=l.get(n)[0] && interval[0]<=l.get(n)[1])
            {
                int a[] = new int[2];
                a[0] = Math.min(interval[0],l.get(n)[0]);
                a[1] = Math.max(interval[1],l.get(n)[1]);
                l.remove(n);
                l.add(a);
            }
            else
            {
                l.add(interval);
            }
        }
                
        return l.toArray(new int[l.size()][]);
    }
}
