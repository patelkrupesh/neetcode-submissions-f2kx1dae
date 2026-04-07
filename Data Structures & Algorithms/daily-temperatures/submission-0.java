class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i = 0;i+1 < temperatures.length;i++){
            if(temperatures[i]<temperatures[i+1]){
                int higher = i+1;
                for(int j=i; j>=0;j--){
                    if(result[j] == 0 && temperatures[j]<temperatures[i+1]){
                        result[j] = i+1-j;
                    }
                }
            }
        }
        return result;
    }
}
