import java.util.Scanner;

public class DepositCalculator {

    public static void main(String[] args) {

    new DepositCalculator().run();
    }

    void run() {
      double resultAmount = 0;
      int period;
      int action;
      int amount;
      Scanner scanner = new Scanner(System.in);
      System.out.println("Введите сумму вклада в рублях:");
      amount = scanner.nextInt();
      System.out.println("Введите срок вклада в годах:") ;
      period = scanner.nextInt( );
      System.out.println("Выберите тип вклада: \n1 - вклад с обычным процентом  \n2 - вклад с капитализацией");
      action = scanner.nextInt();

        if (action == 1) {
            resultAmount = calculateSimplePercent(amount, 0.06, period);
        }
        else if (action == 2) {
            resultAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + resultAmount);
    }

    double calculateComplexPercent (double amount, double yearRate, int depositPeriod ) {
        double pay = amount * Math.pow( (1 + yearRate/ 12), 12 * depositPeriod );
        return rounding(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return rounding(amount + amount * yearRate * depositPeriod, 2);
    }

    double rounding(double value, int places) {
        double scale= Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

}


