/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

/**
 * Arrays.sort
 */
public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Arrays.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point a, Point b){
                int diff = eudicDis(a, origin) - eudicDis(b, origin);
                if(diff == 0){
                    diff = a.x - b.x;
                }
                if(diff == 0){
                    diff = a.y - b.y;
                }
                return diff;
            }
        });
        Point[] ans = new Point[k];
        for(int i = 0; i < k; i++){
            ans[i] = points[i];
        }
        return ans;
    }
    int eudicDis(Point a, Point b){
        return (a.x-b.x) * (a.x-b.x) + (a.y-b.y) * (a.y-b.y);
    }
}
/**
 * priority queue
 */
public class Solution {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(k, new Comparator<Point>(){
            @Override
            public int compare(Point a, Point b){
                int diff = eudicDis(b, origin) - eudicDis(a, origin);
                if(diff == 0){
                    diff = b.x - a.x;
                }
                if(diff == 0){
                    diff = b.y - a.y;
                }
                return diff;
            }
        });
        for(Point p : points){
            pq.offer(p);
            if(pq.size() > k){
                pq.poll();
            }
        }
        Point[] ans = new Point[k];
        int size = pq.size();
        for(int i = size-1; i >= 0; i--){
            ans[i] = pq.poll();
        }
        return ans;
    }
    int eudicDis(Point a, Point b){
        return (a.x-b.x) * (a.x-b.x) + (a.y-b.y) * (a.y-b.y);
    }
}