/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> ans = new HashMap<>();
        Arrays.sort(results, (a, b)-> b.score - a.score);
        int[] map = new int[results.length];
        for(int i = 0; i < results.length; i++){
            if(map[results[i].id] == 0){
                ans.put(results[i].id, results[i].score * 1.0);
                map[results[i].id]++;
            }else if(map[results[i].id] < 5){
                ans.put(results[i].id, ans.get(results[i].id) + results[i].score);
                map[results[i].id]++;
            }
        }
        System.err.println(Arrays.toString(map));
        for(int key : ans.keySet()){
            ans.put(key, ans.get(key) / 5.0);
        }
        return ans;
    }
}
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> ans = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> hmap = new HashMap<>();
        for(Record r : results){
            if(!hmap.containsKey(r.id)){
                hmap.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq = hmap.get(r.id);
            if(pq.size() < 5){
                pq.offer(r.score);
            }else if(pq.peek() < r.score){
                pq.poll();
                pq.offer(r.score);
            }
        }
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry : hmap.entrySet()){
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double average = 0;
            for(int i = 0; i < 5; i++)
                average += scores.poll();
            average /= 5;
            ans.put(id, average);
        }
        return ans;
    }
}