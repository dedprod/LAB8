public class Main {
    public static int num1 = 1;
    public static int num2 = 1;
    public static int den1 = 1;
    public static int den2 = 1;

    public static void main(String[] args) {
        Rebuild.Reconstruction();
        System.out.println("Дроби:");
        SimpleFractions Fr1 = new SimpleFractions(num1, den1);
        SimpleFractions Fr2 = new SimpleFractions(num2, den2);
        System.out.println(" ");
        if (Rebuild.operation.contains("+")) {
            SimpleFractions.sum(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.sum(Fr2);
        }
        if (Rebuild.operation.contains("-")) {
            SimpleFractions.min(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.min(Fr2);
        }
        if (Rebuild.operation.contains("*")) {
            SimpleFractions.multiply(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.multiply(Fr2);
        }
        if (Rebuild.operation.contains(":")) {
            SimpleFractions.divide(Fr1, Fr2);
            System.out.println("Способ с одним аргументом");
            Fr1.divide(Fr2);
        }
    }
}