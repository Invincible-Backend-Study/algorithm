import java.util.*;
class Solution {
    Map<String, String> melody = new HashMap<>(){{
            this.put("C#","c");
            this.put("D#","d");
            this.put("F#","f");
            this.put("G#","g");
            this.put("A#","a");
        	this.put("B#","b");
    }};
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        
        var maxTime = 0; 
        m = change(m);
        for(var musicInfo: musicinfos){
            var split = musicInfo.split(",");
            var time = getTime(split[0], split[1]);
            
            var music = change(split[3]);
            
            while(music.length() < time){
                music += music;
            }
            music = music.substring(0, time);
            
            if(music.contains(m)){
                if(maxTime < time){
                    maxTime = time;
                    answer = split[2];
                }
            }
        }
        
        
        return answer;
    }
    
    String change(String s){
        for(var e: melody.entrySet()){
            s = s.replace(e.getKey(), e.getValue());
        }
        return s;
    }
    
    int getTime(String t1, String t2){
        return getTime(t2) - getTime(t1);
    }
    int getTime(String t){
        var split = t.split(":");
        var h = Integer.parseInt(split[0]) * 60;
        var m = Integer.parseInt(split[1]);
        return h + m;
       	
        
    }
}
