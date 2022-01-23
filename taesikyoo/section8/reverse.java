package section8;

import java.util.Objects;

public class reverse {

    public static void main(String[] args) {
        String s = reverse("awesome");
        System.out.println(s);
    }

    private static String reverse(String s) {
        if (Objects.equals(s, "")) {
            return s;
        }

        String reverse = reverse(s.substring(1));
        System.out.println(reverse);
        char i = s.charAt(0);
        System.out.println(i);
        return reverse + i;
    }

}
