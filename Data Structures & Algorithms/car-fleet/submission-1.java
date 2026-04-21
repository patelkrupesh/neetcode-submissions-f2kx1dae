class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length != speed.length || position.length == 0) return 0;

        List<Integer> l = new ArrayList<>();
        for(int i = 0 ; i < position.length; i++){
            l.add(i);
        }

        // sort by position
        Collections.sort(l, (a, b) -> position[b] - position[a]);

        // System.out.println(Arrays.toString(position));
        // System.out.println(Arrays.toString(speed));
        // System.out.println(l);

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
