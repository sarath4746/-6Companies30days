class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<Integer>> accessMap = new HashMap<>();
        
        for (List<String> entry : access_times) {
            String name = entry.get(0);
            String timeStr = entry.get(1);
            int time = Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(2, 4));
            accessMap.computeIfAbsent(name, k -> new ArrayList<>()).add(time);
        }
        
        List<String> result = new ArrayList<>();
        
        for (Map.Entry<String, List<Integer>> entry : accessMap.entrySet()) {
            String name = entry.getKey();
            List<Integer> times = entry.getValue();
            Collections.sort(times);
            
            for (int i = 0; i < times.size(); i++) {
                int start = times.get(i);
                int count = 1;
                
                for (int j = i + 1; j < times.size(); j++) {
                    int end = times.get(j);
                    if (end - start < 60) {
                        count++;
                        if (count >= 3) {
                            result.add(name);
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (count >= 3) break;
            }
        }
        
        return result;
    }
}