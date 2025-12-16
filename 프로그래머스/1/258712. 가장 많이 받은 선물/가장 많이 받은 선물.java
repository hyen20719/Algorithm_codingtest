import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;
        
        Map<String,Integer> idxMap = new HashMap<>();
        Map<String,Map<String, Integer>> giftMap = new HashMap<>();
        Map<String,Integer> levelMap = new HashMap<>();
        
        // 사람리스트
        for(int i=0; i<len; i++){
            idxMap.put(friends[i], i);
            levelMap.put(friends[i], 0);
        }
        
        // 선물 준사람 (받은사람 :갯수)
        for(String gift : gifts){
            String[] g = gift.split(" ");
            String giver = g[0];
            String receiver = g[1];
            
            giftMap.putIfAbsent(giver, new HashMap<>());
            Map<String, Integer> recevMap = giftMap.get(giver);
            recevMap.put(receiver, recevMap.getOrDefault(receiver,0)+1);
            //선물 지수
            levelMap.put(giver, levelMap.get(giver)+1);
            levelMap.put(receiver, levelMap.get(receiver)-1);
            
        }
       // System.out.println(giftMap);
        
        // 다음 달 선물 갯수
        int[] nextGift = new int[len];
        
        // 친구 쌍 비교
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                String a = friends[i];
                String b = friends[j];
                
                // a에게 아무도 안 준경우를 대비해서 getOrDefault(해시맵 생성) 사용
                // a가 b에게 안 준 경우 내부 map에 없기때문에 0으로 처리
                int aToB = giftMap.getOrDefault(a, new HashMap<>()).getOrDefault(b,0);
                int bToA = giftMap.getOrDefault(b, new HashMap<>()).getOrDefault(a,0);
                
               // System.out.println(a+", " + b + ", " + aToB);
                
                if(aToB > bToA){ // a가 더 많이 준 경우
                    nextGift[i]++;
                }else if(aToB < bToA){ //b가 더 많이 준 경우
                    nextGift[j]++;   
                }else{
                    // 선물 준 횟수 동일시 선물지수로 비교
                    if(levelMap.get(a) > levelMap.get(b)){
                        nextGift[i]++;
                    }else if(levelMap.get(a) < levelMap.get(b)){
                        nextGift[j]++;
                    }
                }
            }
        }
        
        //System.out.println(Arrays.toString(nextGift));
        
        for(int n : nextGift){
            answer = Math.max(answer, n);
        }
        
        return answer;
    }
}