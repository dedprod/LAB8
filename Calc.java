import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calc {
    private int numerator;
    private int denominator;


    public Calc(int num, int den) {
        this.numerator = num;
        this.denominator = den;
        System.out.print(numerator + "/" + denominator + " ");
    }

    static void plus(Calc Fr1, Calc Fr2) {
        int numL = Fr1.numerator * Fr2.denominator + Fr1.denominator * Fr2.numerator;
        int denL = Fr1.denominator * Fr2.denominator;
        System.out.println("Сложение: " + numL + "/" + denL);
    }

    static void minus(Calc Fr1, Calc Fr2) {
        int numL = Fr1.numerator * Fr2.denominator - Fr1.denominator * Fr2.numerator;
        int denL = Fr1.denominator * Fr2.denominator;
        System.out.println("Вычитание: " + numL + "/" + denL);
    }

    static void multiply(Calc Fr1, Calc Fr2) {
        int numL = Fr1.numerator * Fr2.numerator;
        int denL = Fr1.denominator * Fr2.denominator;
        System.out.println("Умножение: " + numL + "/" + denL);
    }

    static void divide(Calc Fr1, Calc Fr2) {
        int numL = Fr1.numerator * Fr2.denominator;
        int denL = Fr1.denominator * Fr2.numerator;
        System.out.println("Деление: " + numL + "/" + denL);
    }

    /////////////////////////////////// 2 СПОСОБ ///////////////////////////////////////////////
    void sum(Calc Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x1 = 0;
        int y1 = 0;
        x1 = this.numerator * denom + this.denominator * nom;
        y1 = this.denominator * denom;
        System.out.println("Сложение: " + x1 + "/" + y1);
    }

    void min(Calc Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x2 = 0;
        int y2 = 0;
        x2 = this.numerator * denom - this.denominator * nom;
        y2 = this.denominator * denom;
        System.out.println("Вычитание: " + x2 + "/" + y2);
    }

    void multiply(Calc Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x3 = 0;
        int y3 = 0;
        x3 = this.numerator * nom;
        y3 = this.denominator * denom;
        System.out.println("Умножение: " + x3 + "/" + y3);
    }

    void divide(Calc Fr2) {
        int nom = Fr2.numerator;
        int denom = Fr2.denominator;
        int x = 0;
        int y = 0;
        x = this.numerator * denom;
        y = this.denominator * nom;
        System.out.println("Деление: " + x + "/" + y);
    }

    public static void main(String args[]) {
        int num1 = 1;
        int num2 = 1;
        int den1 = 1;
        int den2 = 1;
        String operation = null;
        String pattern2 = "([0-9]|[1-9][1-9]|-[1-9]|-[1-9][1-9]|-[1-9][0-9][0-9]|[1-9][0-9][0-9])/([1-9]|[1-9][1-9]|-[1-9]|-[1-9][0-9]|-[1-9][0-9][0-9]|[1-9][0-9][0-9])( )([+-:*])( )([0-9]|[1-9][1-9]|-[1-9]|-[1-9][1-9]|-[1-9][0-9][0-9]|[1-9][0-9][0-9])/([1-9]|[1-9][1-9]|-[1-9]|-[1-9][1-9]|-[1-9][0-9][0-9]|[1-9][0-9][0-9])";
        Pattern p = Pattern.compile(pattern2);
        Scanner data = new Scanner(System.in);
        System.out.println("Введите выражение состоящее из двух простых дробей вида: 'num/den (+,-,:,*) num2/den2'");
        String text = data.nextLine();
        data.close();
        Matcher m = p.matcher(text);
        if (m.matches() == true) {
            String[] parts = text.split("[/( )]+");
            operation = parts[2];
            num1 = Integer.parseInt(parts[0]);
            den1 = Integer.parseInt(parts[1]);
            num2 = Integer.parseInt(parts[3]);
            den2 = Integer.parseInt(parts[4]);
            System.out.println("Выражение введено верно.");
        }
        else {
            System.out.println("Введите выражение ещё раз, предварительно перезапустив программу.");
            System.exit(1);
        }
        System.out.println("Дроби:");
        Calc Fr1 = new Calc(num1, den1);
        Calc Fr2 = new Calc(num2, den2);
        System.out.println(" ");
        if (operation.contains("+")) {
            plus(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.sum(Fr2);
        }
        if (operation.contains("-")) {
            minus(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.min(Fr2);
        }
        if (operation.contains("*")) {
            multiply(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.multiply(Fr2);
        }
        if (operation.contains(":")) {
            divide(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.divide(Fr2);
        }
    }
}
