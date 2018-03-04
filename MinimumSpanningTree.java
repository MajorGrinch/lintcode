/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    HashMap<String, Integer> idMap = new HashMap<>();
    int cityN = 0;
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        List<Connection> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(connections.size() * 2);
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2){
                int diff = c1.cost - c2.cost;
                if(diff != 0){
                    return diff;
                }else if(c1.city1.equals(c2.city1)){
                    return c1.city2.compareTo(c2.city2);
                }else{
                    return c1.city1.compareTo(c2.city1);
                }
            }
        });
       for(Connection conn : connections){
           int u = name2ID(conn.city1);
           int v = name2ID(conn.city2);
           if(uf.find(u) != uf.find(v)){
               uf.union(u ,v);
               ans.add(conn);
           }
       }
       if(ans.size() == cityN -1){
           return ans;
       }else{
           return new ArrayList<>();
       }
    }
    
    int name2ID(String name){
        if(idMap.containsKey(name)){
            return idMap.get(name);
        }else{
            idMap.put(name, cityN++);
            return cityN-1;
        }
    }
      
    class UnionFind{
        int[] s;
        public UnionFind(int n){
            s = new int[n];
            Arrays.fill(s, -1);
        }
        public int find(int x){
            if(s[x] < 0){
                return x;
            }
            return s[x] = find(s[x]);
        }
        public void union(int a, int b){
            int fa_a = find(a);
            int fa_b = find(b);
            if(s[fa_a] < s[fa_b]){
                s[fa_a] += s[fa_b];
                s[fa_b] = fa_a;
            }else{
                s[fa_b] += s[fa_a];
                s[fa_a] = fa_b;
            }
        }
    }
}