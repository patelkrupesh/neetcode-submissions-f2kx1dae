class MinStack {
    LinkedList<Integer> list;
    LinkedList<Integer> minList;
    
    public MinStack() {  
        this.list = new LinkedList<Integer>();      
        this.minList = new LinkedList<Integer>();      
    }
    
    public void push(int val) {
        list.addFirst(val);
        if(minList.isEmpty() || minList.get(0) >= val){
            minList.addFirst(val);
        }
    }
    
    public void pop() {        
        if(!minList.isEmpty() && minList.get(0).equals(list.get(0))){
            minList.removeFirst();
        }
        list.removeFirst();        
    }
    
    public int top() {
        if(list.size() == 0) return -1;
        return list.get(0);
    }
    
    public int getMin() {
        if(minList.size() == 0) return -1;
        return minList.get(0);
    }
}
