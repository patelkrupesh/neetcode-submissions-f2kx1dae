class Solution {
    public int trap(int[] height) {    
        int len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int min = 0;
        
        for(int i=0;i<height.length ; i++){
            if(height[i]>min) min = height[i];            
            left[i] = min;
        }
    
        min = 0;
        for(int i=height.length-1; i>=0 ; i--){
            if(height[i]>min) min = height[i];
            right[i] = min;
        }
        
        int answer = 0;
        for(int i=1;i<height.length-1 ; i++){
            answer += Math.min(left[i], right[i]) - height[i];
        }
        return answer;
    }
}
