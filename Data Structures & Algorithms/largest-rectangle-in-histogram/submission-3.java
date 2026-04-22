class Solution {
    class Node {
        public int startPoint;
        public int height;
        public Node(int startPoint, int height){
            this.height = height;
            this.startPoint = startPoint;
        }
        @Override
        public String toString(){
            return " [ startPoint : "+ startPoint + " , height : " + height + " ] ";
        }
    }
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Node> stack = new Stack<>();
        for(int i=0;i < heights.length;i++) {
            if (stack.isEmpty() || stack.peek().height < heights[i]){
                stack.push(new Node(i, heights[i]));
//                System.out.print("Pushed");
//                System.out.println(stack);
            }else if (stack.peek().height > heights[i]){
                int start;
                do {
                    Node n = stack.pop();
                    start = n.startPoint;
//                    System.out.print("Popped");
//                    System.out.println(stack);
                    int area = (i - n.startPoint) * n.height;
//                    System.out.println("Area : " + area);
                    if (res < area) {
                        res = area;
                    }
                }
                while(!stack.isEmpty() && stack.peek().height > heights[i]);
                stack.push(new Node(start, heights[i]));
//                System.out.print("Pushed");
//                System.out.println(stack);
            }
        }
        while(!stack.isEmpty()){
            Node n = stack.pop();
//            System.out.print("Popped");
//            System.out.println(stack);
            int area = (heights.length - n.startPoint) * n.height;
//            System.out.println("Area : " + area);
            if (res < area) {
                res = area;
            }
        }

        return res;
    }
}
