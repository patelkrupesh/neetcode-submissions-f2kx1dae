class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length != speed.length || position.length == 0) return 0;

        List<Integer> l = new ArrayList<>();
        for(int i = 0 ; i < position.length; i++){
            l.add(i);
        }

        // sort by position
        Collections.sort(l, (a, b) -> position[b] - position[a]);

        /*        
        take the nearest to target - calculate steps - add to steps set - +1
        prev max = steps
        take 2nd - calculate steps , if <= prev max no update
        if > prev max , prev max = steps , update +1
        */

        double curr_max = 0;
        int res = 0;        
        for(int n : l){
            int dis = target - position[n];
            // need to take this as double
            //example pos- 8 , speed - 4, takeas 0.5 hour to reach target 10
            //        pos- 7 , speed - 4, takeas 0.75 hour to reach target 10
            // So res will be ++ by 2.
            double steps = (double)dis / speed[n];
            // System.out.println("position : "+position[n]+" miles, speed :"+speed[n]+" mph, distance from target : "+ dis + " miles, " +
                    // "and steps reqruied : " + steps +" hours.");
            if(steps <= curr_max){
                // do nothing
            }else{
                // add this car fleet to result
                curr_max = steps;
                res++;                
            }
        }
        return res;
    }
}
