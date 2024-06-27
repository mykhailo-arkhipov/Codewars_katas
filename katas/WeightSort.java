import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightSort {

    public static void main(String[] args) {
        System.out.print(orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
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
                return Integer.compare(o1Weight, o2Weight);
            }
        };
        ArrayList<String> arrayList = new ArrayList<>();
        char[] chars = strng.toCharArray();
        StringBuilder stringValue = new StringBuilder();
        for (char c : chars){
            if (Character.isDigit(c)){
                stringValue.append(c);
            }
            else {
                arrayList.add(stringValue.toString());
                stringValue = new StringBuilder();
            }
        }

        return arrayList.stream().sorted(comparator).collect(Collectors.joining(" "));
    }
}