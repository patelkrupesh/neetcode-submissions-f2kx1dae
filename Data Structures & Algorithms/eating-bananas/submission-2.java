class Solution {
    private boolean isValid(int[] piles, int hours, int bananasPerHour){
        int counter = 0;
        for(int n : piles){
            counter += ( n + bananasPerHour - 1 ) / bananasPerHour;
        }
        return counter <= hours;
    }

    private int binarySearch(int[] piles, int h, int l, int r) {
        int mid = (l + r) / 2;
        if(l>=r) return r;
        if(isValid(piles, h, mid)){
            return binarySearch(piles, h, l, mid);
        }else{
            return binarySearch(piles, h, mid+1, r);
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        int finalRes = 0;
        int n = piles.length;
        if(n == 0 || h <= 0) return 0;
        List<Integer> list = new ArrayList<Integer>(n);
        for (int i : piles) {
            list.add(i);
        }
        Collections.sort(list);
        return binarySearch(piles, h, 1, list.get(list.size()-1));
    }
}
