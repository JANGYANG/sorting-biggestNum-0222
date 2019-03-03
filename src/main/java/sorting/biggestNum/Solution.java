package sorting.biggestNum;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Solution {
    public class Number implements Comparable<Number>{
        private String num;
        private int length;
        public Number(int num){
            this.num = String.valueOf(num);
            this.length = this.num.length();
        }

        @Override
        public int compareTo(Number newNum){
            if(this.num.equals(newNum.num)) return 0;
            return (Integer.parseInt(this.num + newNum.num) > Integer.parseInt(newNum.num + this.num))?-1:1;
        }

        public Integer getFirstNum() {return Integer.parseInt(this.num.substring(0, 1));}
        
    }

    public String solution(int[] numbers){

        String answer = "";

        String[] numberList = Arrays.stream(numbers)
            .mapToObj(num -> new Number(num))
            .collect(Collectors.groupingBy(Number::getFirstNum, Collectors.toCollection(LinkedList::new)))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
            .flatMap(x -> x.getValue().stream().sorted())
            .map(x -> x.num)
            .toArray(String[]::new);

        // Map<Object, Object> numberList = Arrays.stream(numbers)
        //     .mapToObj(num -> new Number(num))
        //     .collect(Collectors.groupingBy(Number::getFirstNum, Collectors.toCollection(LinkedList::new)))
        //     .entrySet().stream()
        //     .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
        //     // .map(x -> x.getValue().stream().sorted().collect(Collectors.toList()))
        //     .collect(Collectors.toMap(k -> k.getKey(), Map.Entry::getValue,
        //     (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        
        // for(Object k : numberList.keySet()){
        //     System.out.println(numberList.get(k));
        //     Collections.sort((List<Number>)numberList.get(k));
        //     for (Number n : (List<Number>)numberList.get(k)) {
        //         answer += n.num;
        //     }
        // }

        System.out.println(answer);

        answer = String.join("", numberList);
        answer = answer.replace("0", "").length() == 0 ? "0" : answer;
        return answer;

    }
}