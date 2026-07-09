public class FinancialForecast {

    /**
     * Recursive method to predict future value based on a steady growth rate.
     * Formula: Future Value = Present Value * (1 + rate)^years
     */
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        // Base case: If 0 years left, the value remains the current present value
        if (years == 0) {
            return presentValue;
        }
        
        // Recursive step: Calculate next year's value, and reduce the years count by 1
        double nextYearValue = presentValue * (1 + growthRate);
        return predictFutureValue(nextYearValue, growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 10000.0; // Past/Present Data
        double expectedAnnualGrowth = 0.05; // 5% past growth rate
        int forecastYears = 10;
        
        double projectedValue = predictFutureValue(initialInvestment, expectedAnnualGrowth, forecastYears);
        System.out.printf("Projected value after %d years: $%.2f%n", forecastYears, projectedValue);
    }
}