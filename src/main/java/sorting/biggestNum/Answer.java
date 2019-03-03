package sorting.biggestNum;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Answer {
    
    public static String num(int[] n){
        int num=0;
        String n1="";
        for(int i = 0; i<n.length;i++){
            for(int j = 0; j<n.length;j++){
                if(n[i]>n[j]){
                    num = n[i];
                    n[i] = n[j];
                    n[j] = num;
                }
            }
        }

        return String.join(",",Arrays.stream(n).boxed().map(x->String.valueOf(x)).collect(Collectors.toList()));

    }
    public static String makeLargeNumber(int[] nums){
        
        String[] list = Arrays.stream(nums).boxed().map(x->String.valueOf(x)).collect(Collectors.toList()).toArray(new String[0]);

        for(int i = 0; i < list.length; i++) {
            for(int j = i; j < list.length; j++) {
                int preFirstNum = Integer.parseInt((list[i]).charAt(0)+""); 
                int nextFirstNum = Integer.parseInt((list[j]).charAt(0)+"");

                int result = Integer.parseInt(list[i]+list[j]) - Integer.parseInt(list[j]+list[i]);

                if( (preFirstNum  <  nextFirstNum)
                    || (preFirstNum == nextFirstNum && result < 0) ) {
                    String temp = list[i];
                    list[i] = list[j];
                    list[j] = temp; 
              }
            }
        }

        return String.join(",",list);
    }
}
