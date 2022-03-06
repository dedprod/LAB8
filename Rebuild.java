import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rebuild {
    public static String operation;

    public static void Reconstruction() {
        String pattern2 = "^(-?\\d{1,10})/(-?\\d{1,10})( )[-+*:]( )(-?\\d{1,10})/(-?\\d{1,10})$";
        Pattern p = Pattern.compile(pattern2);
        Scanner data = new Scanner(System.in);
        System.out.println("Введите выражение состоящее из двух простых дробей вида: 'num/den (+,-,:,*) num2/den2'");
        String text = data.nextLine();
        data.close();
        Matcher m = p.matcher(text);
        if (m.matches() == true) {
            String[] parts = text.split("[/( )]+");
            Main.num1 = Integer.parseInt(parts[0]);
            Main.den1 = Integer.parseInt(parts[1]);
            Main.num2 = Integer.parseInt(parts[3]);
            Main.den2 = Integer.parseInt(parts[4]);
            operation = parts[2];
            System.out.println("Выражение введено верно.");
        } else {
            System.out.println("Введите выражение ещё раз, предварительно перезапустив программу.");
            System.exit(1);
        }
    }
}
