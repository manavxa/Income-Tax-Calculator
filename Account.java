/*Author: Manav Arora 
 *Student No: 3365762
 *Date: 29/04/2022
 *Description: Account Class
 */ 

public class Account {
    private double weeklyExpense;
    private double rate;
    private double amount;
    private int numberOfWeeks;
    private double total;

    private double investmentAmount; // variable for storing monthly investment amount

    public Account() {
        weeklyExpense = 0;
        rate = 0.0;
        amount = 0.0;
        numberOfWeeks = 0;
        investmentAmount = 0;
    }


    //set and get methods for weekly expense
    public void setWeeklyExpense(double newWeeklyExpense) {
        weeklyExpense = newWeeklyExpense;
    }

    public double getWeeklyExpense() {
        return weeklyExpense;
    }


    // Set and Get Interest rate
    public void setRate(double newRate) {
        rate = newRate;
    }

    public double getRate() {
        return rate;
    }


    // Set and Get Number of Weeks ( Investment Period )
    public void setNumberOfWeeks(int newNumberOfWeeks) {
        numberOfWeeks = newNumberOfWeeks;
    }

    public int getNumberOfWeeks() {
        return numberOfWeeks;
    }


    // Set and Get Monthly Investment Amount
    public void setAmount(double newAmount) {
        amount = newAmount;
    }

    public double getAmount() {
        return amount;
    }

    // Set and Get method for setting investment amount
    public void setMonthlyInvestment(double newinvestmentAmount) {
        investmentAmount = newinvestmentAmount;
    }

    public double getMonthlyInvestment() {
        return investmentAmount;
    }

    // Calculating total investment, accordingly.
    public void calcInvestment(int incrementingLength) {

        double monthlyRate = (1 + ((rate / 52) * 4) / 100);

        if (incrementingLength < 4) {
            if (investmentAmount != 0) {
                if (incrementingLength % 4 != 0) {

                    switch (incrementingLength % 4) {
                        case 1:
                            investmentAmount = (((total + amount * 4) * monthlyRate) + amount * 1);

                            break;

                        case 2:
                            investmentAmount = (((total + amount * 4) * monthlyRate) + amount * 2);
                            break;

                        case 3:
                            investmentAmount = (((total + amount * 4) * monthlyRate) + amount * 3);
                            break;
                    }
                }
            } else {
                switch (incrementingLength) {
                    case 1:
                        investmentAmount = amount * 1;
                        break;

                    case 2:
                        investmentAmount = amount * 2;
                        break;

                    case 3:
                        investmentAmount = amount * 3;
                        break;
                }

            }
        } else {


            if (incrementingLength % 4 == 0) {
                if (investmentAmount == 0) {
                    investmentAmount = amount * 4 * monthlyRate;
                    setMonthlyInvestment(investmentAmount);
                } else if (incrementingLength > 4 && incrementingLength % 4 == 0) {

                    total = investmentAmount;
                    investmentAmount = (total + amount * 4) * monthlyRate;
                    setMonthlyInvestment(investmentAmount);
                }
            }

            else if (incrementingLength % 4 != 0) {

                switch (incrementingLength % 4) {
                    case 1:
                        investmentAmount = (((total + amount * 4) * monthlyRate) + amount * 1);
                        break;

                    case 2:
                        investmentAmount = (((total + amount * 4) * monthlyRate) + amount * 2);
                        break;

                    case 3:
                        investmentAmount = (((total + amount * 4) * monthlyRate) + amount * 3);
                        break;
                }
            }
        }

    }
}