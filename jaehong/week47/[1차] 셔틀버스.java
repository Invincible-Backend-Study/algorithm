import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        var pq = new PriorityQueue<Integer>();
        for(String table: timetable) pq.add(convert(table));
        
        var startTime = 540;
        var lastTime = 0;
        var total = 0; 
        
        for(int i = 0; i < n; i++){
            System.out.println(pq + " " + startTime + " " + total); 
            total = 0; 
            
            while(!pq.isEmpty()){
                var cur = pq.peek(); 
                if(cur <= startTime && total < m) {
                    pq.poll();
                    total++;
                }
                else break;
                lastTime = cur - 1; 
            }
            startTime += t; 
        }
        if(total < m) lastTime = startTime - t; 
        
        return String.format("%02d:%02d",lastTime / 60, lastTime %60);
    } 
    
    int convert(String input){
        var split = input.split(":");
        
        var h = Integer.parseInt(split[0]) * 60;
        var m = Integer.parseInt(split[1]);
        
        return h + m;
    }
}

