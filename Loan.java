package Exercises31_1_9;

//Implements Seriablizable to support object IO  
public class Loan implements java.io.Serializable {
private static double annualInterestRate;
private static int numberOfYears;
private static double loanAmount;
private java.util.Date loanDate;

/** Default constructor */
public Loan() {
 this(2.5, 1, 1000);
}

/** Construct a loan with specified annual interest rate,
   number of years and loan amount
 */
public Loan(double annualInterestRate, int numberOfYears,
   double loanAmount) {
 this.annualInterestRate = annualInterestRate;
 this.numberOfYears = numberOfYears;
 this.loanAmount = loanAmount;
 loanDate = new java.util.Date();
}

/** Return annualInterestRate */
public double getAnnualInterestRate() {
 return annualInterestRate;
}

/** Set a new annualInterestRate 
 * @return */
public static double setAnnualInterestRate(double tfannualInterestRate) {
 return annualInterestRate = tfannualInterestRate;
}

/** Return numberOfYears */
public int getNumberOfYears() {
 return numberOfYears;
}

/** Set a new numberOfYears 
 * @return */
public static double setNumberOfYears(double tfNumOfYears) {
 return numberOfYears = (int) tfNumOfYears;
}

/** Return loanAmount */
public static double getLoanAmount() {
 return loanAmount;
}

/** Set a newloanAmount 
 * @return */
public static double setLoanAmount(double tfloanAmount) {
 return loanAmount = tfloanAmount;
}

/** Find monthly payment */
public static double getMonthlyPayment() {
 double monthlyInterestRate = annualInterestRate / 1200;
 double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
   (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
 return monthlyPayment;    
}

/** Find total payment */
public static double getTotalPayment() {
 double totalPayment = getMonthlyPayment() * numberOfYears * 12;
 return totalPayment;    
}

/** Return loan date */
public java.util.Date getLoanDate() {
 return loanDate;
}
}