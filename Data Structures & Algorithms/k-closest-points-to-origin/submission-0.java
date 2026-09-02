class Solution {
    public class Node{
            Double distance;
            int[] point;
            public Node(Double distance, int[] point){
                this.distance = distance;
                this.point = point;
            }
    }
    
    Queue<Node> q = new PriorityQueue<>(Comparator.comparingDouble((Node a) -> a.distance));
    int [] ZERO_ZERO = {0, 0};
        
    public int[][] kClosest(int[][] points, int k) {
        for(int [] point : points){
            q.add(new Node(getDistance(point, ZERO_ZERO), point));
        }
        int[][] result = new int[k][2];        
        for(int index = 0 ; index < k ; index ++){
            int [] point = q.poll().point;
            result[index][0] = point[0];
            result[index][1] = point[1];
        }
        return result;
    }
    private Double getDistance(int[] pointA, int [] pointB){
        int xA = pointA[0];
        int yA = pointA[1];
        int xB = pointB[0];
        int yB = pointB[1];
        int sq = ((xA - xB)*(xA - xB)) + ((yA - yB)*(yA - yB));
        return Math.sqrt(Math.abs(sq));
    }
}
