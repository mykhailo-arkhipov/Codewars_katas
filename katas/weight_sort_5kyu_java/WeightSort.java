package WeightSort_5kyu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightSort {

    public static void main(String[] args) {
        System.out.print(orderWeight("103 123 4444 99 2000"));
    }

    public static String orderWeight(String strng) {

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int o1Weight = 0, o2Weight = 0;
                char[] o1Chars = o1.toCharArray();
                char[] o2Chars = o2.toCharArray();
                for (char c1 : o1Chars){
                    o1Weight += Character.getNumericValue(c1);
                }
                for (char c2 : o2Chars){
                    o2Weight += Character.getNumericValue(c2);
                }
                if (o1Weight == o2Weight){
                    return o1.compareTo(o2);
                }
                return Integer.compare(o1Weight, o2Weight);
            }
        };
        ArrayList<String> arrayList = new ArrayList<>();
        char[] chars = strng.toCharArray();
        StringBuilder stringValue = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isDigit(c)) {
                stringValue.append(c);
            }
            else {
                arrayList.add(stringValue.toString());
                stringValue = new StringBuilder();
            }
        }
        arrayList.add(stringValue.toString());

        return arrayList.stream().sorted(comparator).collect(Collectors.joining(" "));
    }
}