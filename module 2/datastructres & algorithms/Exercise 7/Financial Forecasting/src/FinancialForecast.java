public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal; // base case: no more growth
        }
        return (1 + rate) * calculateFutureValue(principal, rate, years - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0;
        double growthRate = 0.05; // 5% per year
        int years = 10;

        double futureValue = calculateFutureValue(initialInvestment, growthRate, years);
        System.out.printf("Future value after %d years: %.2f\n", years, futureValue);
    }
}
