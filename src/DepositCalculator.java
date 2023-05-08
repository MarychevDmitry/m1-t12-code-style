import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double deposit, double yearRate, int depositPeriod) {
        double value = deposit * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculatePercent(value, 2);
    }

    double calculateSimplePercent(double deposit, double yearRate, int depositPeriod) {
        return calculatePercent(deposit + deposit * yearRate * depositPeriod, 2);
    }

    double calculatePercent(double value, int position) {
        double exponentiation = Math.pow(10, position);
        return Math.round(value * exponentiation) / exponentiation;
    }

    void runProgram() {
        int deposit;
        int depositPeriod;
        int typeOfPercentFunction;
        double yearRate = 0.06;
        double depositWithPersents = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:");
        deposit = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfPercentFunction = scanner.nextInt();
        if (typeOfPercentFunction == 1) {
            depositWithPersents = calculateSimplePercent(deposit, yearRate, depositPeriod);
        } else if (typeOfPercentFunction == 2) {
            depositWithPersents = calculateComplexPercent(deposit, yearRate, depositPeriod);
        }
        System.out.println("Результат вклада: " + deposit
                + " за " + depositPeriod
                + " лет превратятся в " + depositWithPersents);
    }

    public static void main(String[] args) {
        new DepositCalculator().runProgram();
    }
}
