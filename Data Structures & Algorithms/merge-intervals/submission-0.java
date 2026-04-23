class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if(intervals == null || intervals.length == 0 || intervals[0].length != 2 ) return new int[][]{};

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int resPointer = 0;
        for(int[] slot : intervals){
            if(res.size() == 0 ){
                res.add(slot);
                resPointer++;
                continue;
            }
            if(slot[0] <= res.get(resPointer-1)[1]){
                //merge
                res.get(resPointer-1)[1] = Math.max(res.get(resPointer-1)[1], slot[1]);
            }else{
                //add new
                res.add(slot);
                resPointer++;
            }
        }
        return (int [][])res.toArray(new int [res.size()][]);
    }
}
