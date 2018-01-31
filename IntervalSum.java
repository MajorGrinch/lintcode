/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */


public class Solution {
    /*
     * @param A: An integer list
     * @param queries: An query list
     * @return: The result list
     */
    public List<Long> intervalSum(int[] A, List<Interval> queries) {
        // write your code here
        long sum = 0;
        long[] sumA = new long[A.length+1];
        List<Long> res = new ArrayList<>();
        sumA[0] = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            sumA[i+1] = sum;
        }
        for(Interval query : queries){
            res.add(sumA[query.end+1] - sumA[query.start]);
        }
        return res;
    }
}