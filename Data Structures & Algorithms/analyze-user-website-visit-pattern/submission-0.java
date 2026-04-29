class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = timestamp.length;
        if(username.length != n || website.length!= n){
            return new ArrayList<>();
        }
        List<int[]> timeslots = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            timeslots.add(new int []{timestamp[i], i});
        }
        timeslots.sort((a, b) -> (a[0] - b[0]));

        Map<String, List<String>> history = new HashMap<>();
        for(int[] arr : timeslots){
            int index = arr[1];
            history.computeIfAbsent(username[index], k-> new ArrayList<>())
                .add(website[index]);
        }

        // for(Map.Entry<String, List<String>> entry : history.entrySet()){
        //     System.out.println("user : " + entry.getKey() + "  -> " + entry.getValue().toString());
        // }
        Map<String, Integer> counterMap = new HashMap<>();
        for(String user : history.keySet()){
            Set<String> h = new HashSet<>();
            List<String> list = history.get(user);
            if(list.size() < 3) continue;

            for(int i = 0 ; i < list.size()-2; i++){
                for(int j = i+1 ; j < list.size()-1; j++){
                    for(int k = j+1 ; k < list.size(); k++){
                        h.add(list.get(i)+"#"+list.get(j)+"#"+list.get(k));
                    }
                }
            }
            // for(String entry : h){
            //     System.out.println("user : " + user + "  -> " + entry.toString());
            // }
            
            for(String entry : h){
                counterMap.put(entry, counterMap.getOrDefault(entry, 0)+1);
            }
        }
        int max = 0 ;
        String ans = "";
        for(Map.Entry<String, Integer> entry : counterMap.entrySet()){
            // System.out.println(entry.getKey() + " : " + entry.getValue());
            if(entry.getValue() > max || 
            (entry.getValue() == max) && (entry.getKey().compareTo(ans) < 0)){
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        return Arrays.asList(ans.split("#"));
    }
}