class Solution {
    public static int largestRectangleArea(int[] heights) {
        int numbers = heights.length;
        Set<Integer> uniques = new HashSet<>();
        for(int i : heights)    uniques.add(i);

        int uniqueNumbers = uniques.size();
        List<Integer> lowerBound = new ArrayList<>(numbers);

        int holder = Integer.MAX_VALUE;
        for(int i=0;i<numbers;i++){
            if(heights[i] < holder){
                holder = heights[i];
            }
            lowerBound.add(Math.min(holder, heights[i]));
        }
        holder = Integer.MAX_VALUE;
        for(int i=numbers-1;i>=0;i--){
            if(heights[i] < holder){
                holder = heights[i];
            }
            lowerBound.set(i, Math.min(holder, lowerBound.get(i)));
        }

        List<Integer> uniqueArray = new ArrayList<>(uniques);
        Collections.sort(uniqueArray, (a, b)->b-a);
        int res = 0;
        for(int i=0;i<uniques.size();i++){
            int biggestSteak = 0;
            int currentSteak = 0;
            for(int j = 0 ; j <numbers ; j++ ){
                //can we put a line of height uniqueArray.get(i) here ? put 1 / 0
                int val = (lowerBound.get(j) <= uniqueArray.get(i) && uniqueArray.get(i) <= heights[j])? 1 : 0;
                if(val == 1){
                    currentSteak++;
                    if(biggestSteak<currentSteak) biggestSteak = currentSteak;
                }else{
                    currentSteak = 0;
                }
            }
            int curRes = uniqueArray.get(i) * biggestSteak;
            if(curRes > res) res = curRes;
        }
        return res;
    }
}
