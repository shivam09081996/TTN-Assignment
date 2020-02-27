package collections;

import java.util.*;

class SortByValue implements Comparator<Integer>{

    private final Map<Integer, Integer> indexMap;
    private final Map<Integer, Integer> freqMap;

    SortByValue(Map<Integer, Integer> freqMap, Map<Integer, Integer> indexMap){
        this.indexMap = indexMap;
        this.freqMap = freqMap;
    }

    public int compare(Integer o1, Integer o2){
        if(freqMap.get(o1) > freqMap.get(o2))
            return -1;
        else if(freqMap.get(o1) < freqMap.get(o2))
            return 1;
        else{
            return indexMap.get(o1) - indexMap.get(o2);
        }
    }
}

public class Question7 {


    public static void main(String[] args) {

        Integer arr[] = {1,1,1,1,1,2,2,2,2,3,3,3,4,4,5,5,5,7,8,8,9,9,9};

        // make the frequency map for the array - value->frequency
        Map<Integer, Integer> freqMap = new HashMap<>();

        // stores value -> minIndex
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i=0; i<arr.length; i++){

            int element = arr[i];

            if(freqMap.containsKey(element)){
                int freq = freqMap.get(element);
                freq++;
                freqMap.put(element, freq);
            }
            else{
                freqMap.put(element, 1);
            }

            if(!indexMap.containsKey(element)){
                indexMap.put(element, i);
            }


        }


        Arrays.sort(arr, new SortByValue(freqMap, indexMap));

        for(Integer val : arr){
            System.out.print(val + ", ");
        }
        System.out.println();

    }
}
