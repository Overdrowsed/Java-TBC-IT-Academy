import java.util.regex.Pattern;

public class Phone {
    public static void main(String[] args) throws Exception{
        String number = "(+995) [599] 12-34-56";

        number = number.replaceAll("[\\[\\]\\s\\-()]+", "");
        number = number.substring(4);

        System.out.println(Pattern.compile("^5\\d{8}$").matcher(number).find());
    }
}
