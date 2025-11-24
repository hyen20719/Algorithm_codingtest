import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();
        
        for(String r : records){
            String[] record = r.split(" ");
            String time = record[0];
            String car = record[1];
            String type = record[2];
            int minute = timeToMinutes(time);
            if(type.equals("IN")){
                inMap.put(car, minute);
            }else{ // 출차일때 
                int inTime = inMap.get(car);
                int parkedTime = minute - inTime;
                totalMap.put(car, totalMap.getOrDefault(car,0)+parkedTime);
                inMap.remove(car);
            }
        }
        
        // 출차 안된 차량은 23:59분으로 간주
        for(String car : inMap.keySet()){
            int inTime = inMap.get(car);
            int parkedTime = (23*60+59) - inTime;
            totalMap.put(car, totalMap.getOrDefault(car,0)+parkedTime);
        }
        
        // 결과 저장할 리스트
        List<Integer> result = new ArrayList<>();
        // 차량번호 오름차순 정렬
        List<String> carNumbers = new ArrayList<>(totalMap.keySet());
        Collections.sort(carNumbers);
        
        // 각 차량 요금 계산
        for(String car : carNumbers){
            int time = totalMap.get(car);
            int fee = calculate(fees, time);
            result.add(fee);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private int timeToMinutes(String time){
        String[] clock = time.split(":");
        return Integer.parseInt(clock[0]) *60 + Integer.parseInt(clock[1]);
    }
    
    private int calculate(int[] fees, int time){
        int baseTime = fees[0]; //기본시간
        int baseFee = fees[1]; // 기본요금
        int unitMinute = fees[2]; // 추가 요금 단위 시간
        int unitFee = fees[3]; // 추가요금
        
        if(time <= baseTime){
            return baseFee; // 기본시간 이내일 경우
        }
        
        // 초과시 
        int extraTime = time - baseTime;
        int extraFee = (int)Math.ceil(extraTime / (double) unitMinute)*unitFee;
        return baseFee+extraFee;
        
    }
    
}