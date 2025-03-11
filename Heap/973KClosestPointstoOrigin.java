import java.util.*;

public class KClosestPointstoOrigin {
    public static void main(String[] args) {
        int ar[][] = {{3,3},{5,-1},{-2,4},{7,7}, {9,9}, {11,11}};
        Solution s = new Solution();
        s.kClosest(ar, 2);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<>((a,b) -> b.getKey() - a.getKey());
        for(int i = 0; i<points.length; i++){
            int distance = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            p.add(new AbstractMap.SimpleEntry<>(distance, i));
            if(p.size() > k)
                p.poll();
        }
        int[][] res = new int[k][2];
        System.out.println(p);
        return res;
    }
}
