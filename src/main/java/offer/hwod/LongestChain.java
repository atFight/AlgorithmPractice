package offer.hwod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestChain {
    public static String longestChain(String a, String b) {
        Map<String, Integer> initMap = new HashMap<>();
        Map<Integer, String> convertMap = new HashMap<>();
        initMap.put("3", 0);
        initMap.put("4", 1);
        initMap.put("5", 2);
        initMap.put("6", 3);
        initMap.put("7", 4);
        initMap.put("8", 5);
        initMap.put("9", 6);
        initMap.put("10",7);
        initMap.put("J", 8);
        initMap.put("Q", 9);
        initMap.put("K", 10);
        initMap.put("A", 11);
        convertMap.put(0, "3");
        convertMap.put(1, "4");
        convertMap.put(2, "5");
        convertMap.put(3, "6");
        convertMap.put(4, "7");
        convertMap.put(5, "8");
        convertMap.put(6, "9");
        convertMap.put(7, "10");
        convertMap.put(8, "J");
        convertMap.put(9, "Q");
        convertMap.put(10, "K");
        convertMap.put(11, "A");


        String[] handCards = a.split("-");
        String[] outCards = b.split("-");

        int[] leaveCards = new int[]{4,4,4,4,4,4,4,4,4,4,4,4};
        for (String s: handCards) {
            if (!s.equals("2") && !s.equals("B") && !s.equals("C"))
                leaveCards[initMap.get(s)]--;
        }
        for (String s: outCards) {
            if (!s.equals("2") && !s.equals("B") && !s.equals("C"))
                leaveCards[initMap.get(s)]--;
        }

        int maxLength = 0;
        int curLength = 0;
        int maxCard = -1;

        for (int index = 0;index <= leaveCards.length; index++) {
            if (index < leaveCards.length && leaveCards[index] != 0) {
                curLength++;
            }else {
                if (curLength > 4 && maxLength <= curLength) {
                    maxLength = curLength;
                    maxCard = index;
                }
                curLength = 0;
            }
        }

        if (maxLength == 0) {
            return "NO-CHAIN";
        }
        int convertIndex = maxCard - 1;
        StringBuilder builder = new StringBuilder();
        for (int i = convertIndex; i > convertIndex - maxLength; i--) {
            builder.append(convertMap.get(i));
            builder.append("-");
        }
        return builder.reverse().toString().replace("01","10").substring(1);
    }

}
