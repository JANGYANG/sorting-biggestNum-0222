/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

[3, 30, 34, 5, 9]   ->	9534330
 */
package sorting.biggestNum;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        for(int i = 0; i < 1; i++){

            int[] numbers = new Random().ints(100000,0,1001).toArray();
            // System.out.println(numbers.length);
            // int[] numbers = {10, 101, 0, 1, 0, 1, 11, 9, 99, 90, 909, 999, 98, 987};
            // int[] numbers = {10,11, 101, 1, 0};
            // int[] numbers = {12, 121, 1};
            // int[] numbers = {11, 121, 112,212,21,22};
            // int[] numbers = {111,1,11,0,101,10};
            // int[] numbers = {212, 21, 2, 222};
            String x = s.solution(numbers);
            // x = x.replace(",", "").replace("0","").length() == 0 ? "0" : x;
            System.out.println("x : " + x);

            // System.out.println("mLn : " + Answer.makeLargeNumber(numbers).replace(",", ""));

            // System.out.println("N : " + Answer.num(numbers));

            // String y = Answer.makeLargeNumber(numbers);
            // if(!x.replace(",", "").equals(y.replace(",", ""))){
            //     System.out.println("Different");
            //     System.out.println("a : " + x + " " + x.replace("," ,""));
            //     System.out.println("b : " + y + " " + y.replace(",",""));
            // }

        }

        System.out.println("End");
    }
    
    public static String solution2(int[] numbers){

        List<String> answer = Arrays.stream(numbers)
            .boxed()
            .map(x -> Integer.toString(x))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        for(int i = answer.size() - 1; i > 0; i--){
            for(int j = i - 1; j >= 0; j--){
                if(Integer.parseInt(answer.get(i).substring(0,1)) <= Integer.parseInt(answer.get(j).substring(0, 1))){
                    Double temp = Double.parseDouble(String.join("", answer));
                
                    Collections.swap(answer, i, j);

                    Double newTemp = Double.parseDouble(String.join("", answer));
                    if(newTemp > temp){
                        continue;
                    }else{
                        Collections.swap(answer, i, j);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return String.join(",", answer);
    }


    public static LinkedList<String> findBigNum(LinkedList<String> result, Map<Object, LinkedList<Integer>> nums, Integer recentIdx){
        Map.Entry<Object,LinkedList<Integer>> entry = nums.entrySet().iterator().next();
        if(result.isEmpty()){
            result.add(String.valueOf(entry.getValue().pop()));
        }
        if(entry.equals(null)){
            return result;
        }else{
            String orgNum = result.get(recentIdx);

            String newNum = String.valueOf(entry.getValue().peek());

            if(orgNum.length() > newNum.length()){
                for(int i = 0; i < orgNum.length(); i++){
                    newNum += newNum.substring(0, 1);
                }
            }else if(orgNum.length() < newNum.length()){
                for(int i = 0; i < newNum.length(); i++){
                    orgNum += orgNum.substring(0, 1);
                }
            }

            if(Integer.parseInt(orgNum) < Integer.parseInt(newNum)){

            }

            findBigNum(result, nums, recentIdx);
        }
        return result;
        
    }

}
