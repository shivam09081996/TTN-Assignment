package collections;

import java.util.*;

class myComparator implements Comparator<Map.Entry<String, Integer>> {

    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){

        return o1.getValue() - o2.getValue();
//        if(o1.getValue() > o2.getValue())
//            return 1;
//        else if(o1.getValue() < o2.getValue())
//            return -1;
//        return 0;
    }
}

public class Question4 {

    public static Map<String, Integer> sortByValue(Map<String, Integer> hmap){

        // convert hashmap to a linked list
        List<Map.Entry<String, Integer>> ll = new LinkedList<Map.Entry<String, Integer>>();

        // also need to convert hmap to a set of Map.Entry
        ll.addAll(hmap.entrySet());


        Collections.sort(ll, new myComparator());

        // convert linked list back to a LinkedMap because it preserves the order of insertion
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        for(Map.Entry<String,Integer> entry : ll){
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;

    }

    public static void main(String[] args) {

        Map<String, Integer> mp = new HashMap<>();

        mp.put("raghav", 100);
        mp.put("gunjan", 22);
        mp.put("mohit", 99);
        mp.put("raju", 101);
        mp.put("manish", 78);

        Map<String, Integer> sorted = sortByValue(mp);

        // print the sorted map
        for(Map.Entry<String,Integer> entry : sorted.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
