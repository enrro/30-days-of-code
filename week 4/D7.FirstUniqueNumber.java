class FirstUnique {
    HashMap<Integer, Integer> map = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    
    public FirstUnique(int[] nums) {
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0) + 1);
            queue.offer(i);
        }
    }
    
    public int showFirstUnique() {
        while(!queue.isEmpty() && map.get(queue.peek()) > 1){
            queue.poll();
        }
        if(queue.isEmpty()){
            return -1;
        }
        //System.out.println(queue);
        return queue.peek();
    }
    
    public void add(int value) {
        queue.offer(value);
        map.put(value, map.getOrDefault(value,0) + 1);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */