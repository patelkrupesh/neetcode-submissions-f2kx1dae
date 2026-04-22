class Solution {
    public int largestRectangleArea(int[] heights) {
        int numbers = heights.length;
        Set<Integer> uniques = new HashSet<>();
        for(int i : heights)    uniques.add(i);

        int uniqueNumbers = uniques.size();
        List<List<Integer>> metrics= new ArrayList<>();
        for(int i=0;i<uniqueNumbers;i++){
            metrics.add(new ArrayList<>());
        }

//        List<Integer> leftSmallest = new ArrayList<>(numbers);
//        List<Integer> rightSmallest = new ArrayList<>(numbers);
        List<Integer> lowerBound = new ArrayList<>(numbers);
//        List<Integer> upperBound = new ArrayList<>(numbers);
        int holder = Integer.MAX_VALUE;
        for(int i=0;i<numbers;i++){
            if(heights[i] < holder){
                holder = heights[i];
            }
//            leftSmallest.add(holder);
//            rightSmallest.add(0);
            lowerBound.add(Math.min(holder, heights[i]));
//            upperBound.add(Math.max(holder, heights[i]));
        }
        holder = Integer.MAX_VALUE;
        for(int i=numbers-1;i>=0;i--){
            if(heights[i] < holder){
                holder = heights[i];
            }
//            rightSmallest.set(i, holder);
            lowerBound.set(i, Math.min(holder, lowerBound.get(i)));
//            upperBound.set(i, Math.max(holder, upperBound.get(i)));
        }

        // System.out.print("original");
        // System.out.println(Arrays.toString(heights));
        // System.out.print("lowerBound");
        // System.out.println(lowerBound);

        List<Integer> uniqueArray = new ArrayList<>(uniques);
        Collections.sort(uniqueArray, (a, b)->b-a);
        int res = 0;
        for(int i=0;i<uniques.size();i++){
            int biggestSteak = 0;
            int currentSteak = 0;
            for(int j = 0 ; j <numbers ; j++ ){
                //can we put a line of height uniqueArray.get(i) here ? put 1 / 0
                int val = (lowerBound.get(j) <= uniqueArray.get(i) && uniqueArray.get(i) <= heights[j])? 1 : 0;
                metrics.get(i).add(val);
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
        // System.out.println("metrics");
        // System.out.println("  " + Arrays.toString(heights));
        // for(int i=0;i<uniques.size();i++){
        //     System.out.print(uniqueArray.get(i) + " ");
        //     System.out.println(metrics.get(i));
        // }

        for(int i=0;i<uniques.size();i++){

        }

        return res;
    }
}
