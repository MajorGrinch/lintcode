public class LoadBalancer {
    int n = 0;
    Map<Integer, Integer> pos = new HashMap<>();
    List<Integer> array = new ArrayList<>();
    Random rand = new Random();

    public LoadBalancer() {
        // Initialize your data structure here.
    }

    // @param server_id add a new server to the cluster
    // @return void
    public void add(int server_id) {
        // Write your code here
        if(!pos.containsKey(server_id)){
            array.add(server_id);
            pos.put(server_id, n);
            n++;
        }
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        if(pos.containsKey(server_id)){
            int last = array.get(n-1);
            int rmIdx = pos.get(server_id);
            
            pos.put(last, rmIdx);
            array.set(rmIdx, last);
            
            pos.remove(server_id);
            array.remove(n-1);
            n--;
        }
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        return array.get(rand.nextInt(n));
    }
}