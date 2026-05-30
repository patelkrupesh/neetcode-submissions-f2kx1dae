class TimeMap {
    public class Node{
        String value;
        int timestamp;
        public Node(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
        @Override 
        public String toString(){
            return "[ value : " + value + " , timestamp : "+ timestamp + "]";
        }
    }
    Map <String, List<Node>> map;

    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        int size = map.get(key).size();
        if(size == 0){
            map.get(key).add(new Node(value, timestamp));
            return;
        }
        Node n = map.get(key).get(size - 1);
        if(n.timestamp == timestamp){
            n.value = value;
            map.get(key).set(size - 1, new Node(value, timestamp));
        }else if (n.timestamp < timestamp){
            map.get(key).add(new Node(value, timestamp));
        } else{
            System.out.println("Invalid timestamp, it must be stictly in increasing order.");
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Node> list = map.get(key);
        if(list == null || list.size() == 0 ){
            return "";
        }
        String result = "";
        int right = list.size()-1 ;
        int left = 0;
        int mid ;
        while (left <= right){
            mid = (left + right )/2;
            if(list.get(mid).timestamp == timestamp)
                return list.get(mid).value;
            if(list.get(mid).timestamp < timestamp){
                result = list.get(mid).value;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return result;
    }
}
