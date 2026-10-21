import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("   INVESTMENT GROWTH CALCULATOR");
        System.out.println("================================");

        System.out.print("Initial investment ($): ");
        double principal = input.nextDouble();

        System.out.print("Annual interest rate (%): ");
        double rate = input.nextDouble();

        System.out.print("Number of years: ");
        int years = input.nextInt();

        if (principal < 0 || rate < 0 || years < 0) {
            System.out.println("Please enter non-negative values.");
        } else {
            double simpleInterest =
                principal * (rate / 100) * years;

            double simpleTotal = principal + simpleInterest;
            double compoundTotal = principal;

            System.out.println("\nYEAR-BY-YEAR GROWTH");

            for (int year = 1; year <= years; year++) {
                compoundTotal *= (1 + rate / 100);

                System.out.printf(
                    "Year %d: $%.2f%n",
                    year, compoundTotal
                );
            }

            double compoundGrowth = compoundTotal - principal;
            double difference = compoundTotal - simpleTotal;

            System.out.println("\n======= RESULTS =======");
            System.out.printf(
                "Simple interest value: $%.2f%n", simpleTotal);
            System.out.printf(
                "Compound interest value: $%.2f%n", compoundTotal);
            System.out.printf(
                "Simple interest earned: $%.2f%n", simpleInterest);
            System.out.printf(
                "Compound interest earned: $%.2f%n", compoundGrowth);
            System.out.printf(
                "Extra growth from compounding: $%.2f%n", difference);

            input.close();
        }
    }
}
