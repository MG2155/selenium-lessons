import com.sun.org.apache.xpath.internal.operations.Bool;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;

public class testt {
    public static void main(String[] args) {
        String s;
        String s1;


        s = "rgba(204, 0, 0, 1)";
        s1 = s.replaceAll("[rgba(,)]", "");
        System.out.println("Result is: <" + s1 + ">");

        int[] numbers = Arrays.stream(s1.split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int num: numbers
             ) {
            System.out.println(num);

        }

    }
}
