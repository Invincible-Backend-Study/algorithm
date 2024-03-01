 
import java.util.*;
class Solution {
    
    Map<Integer, List<Path>> graph = new HashMap<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        for(var fare: fares){
            int c = fare[0];
            int d = fare[1];
            int f = fare[2]; 
            
            graph.putIfAbsent(c, new ArrayList<>());
            graph.putIfAbsent(d, new ArrayList<>());
            
            graph.get(c).add(new Path(d,f)); 
            graph.get(d).add(new Path(c,f));
        }
        var distA = dijkstra(a, n);
       	var distB = dijkstra(b, n);
       	var dist = dijkstra(s, n);
       	
        System.out.println(Arrays.toString(distA));
        System.out.println(Arrays.toString(distB));
        System.out.println(Arrays.toString(dist));
        var answer = dist[a] + dist[b];
        for(int i = 1; i <= n; i++) answer = Math.min(answer, (dist[i] + distA[i] + distB[i]));
        return answer;
    }
    
    int[] dijkstra(int s, int n){
        var cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        
        cost[s] = 0; 
        var pq = new PriorityQueue<Path>((p1,p2) -> p1.v - p2.v);
        pq.add(new Path(s, 0));
        while(!pq.isEmpty()){
            var cur = pq.poll();
            
            if(!graph.containsKey(cur.i)) continue; 
            for(var next: graph.get(cur.i)){
                if(cost[next.i] <= cur.v + next.v) continue;
                cost[next.i] = cur.v + next.v;
                pq.add(new Path(next.i, cost[next.i]));
            }
        }
        return cost;
    }
    
    
    static class Path{
        int i; 
        int v;
        
        public Path(int i, int v){
            this.i = i;
            this.v = v;
        }
    }
}
