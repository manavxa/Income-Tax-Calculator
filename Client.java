/*Author: Manav Arora 
 *Student No: 3365762
 *Date: 29/04/2022
 *Description: Account Class
 */ 
public class Client {
    private String name;
    private Account savingAccount;
    private double grossSalary;
    private double netSalary;
    private boolean resident;
    private double tax;
    private double medicare;
    private double weeklyExpenses;
    private double salaryAfterTax;
   
    public Client() {
        name = "";
        savingAccount = new Account();
        grossSalary = 0;
        netSalary = 0;
        resident = true;
        tax = 0;
        medicare = 0;
        weeklyExpenses = 0;
        salaryAfterTax = 0;
    }

    // Set and Get method for name
    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }


    // Set and Get method for Savings account
    public void setSavingAccount(Account newAccount) {
        savingAccount = newAccount;
    }

    public Account getAccount() {
        return savingAccount;
    }


    // Set and Get method for gross salary
    public void setGrossSalary(double newGrossSalary) {
        grossSalary = newGrossSalary;
    }

    public double getGrossSalary() {
        return grossSalary;
    }


    // Set and Get method for net salary
    public void setNetSalary(double newNetSalary) {
        netSalary = newNetSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    // Set and Get method for resident status
    public void setResident(boolean newResident) {
        resident = newResident;
    }

    public boolean getResident() {
        return resident;
    }
    
    // Set and Get method for tax
    public void setTax(double newTax) {
        tax = newTax;
    }

    public double getTax() {
        return tax;
    }

    // Set and Get method for medicare
    public void setMedicare(double newMedicare) {
        medicare = newMedicare;
    }

    public double getMedicare() {
        return medicare;
    }


    // Set and Get method for weekly expenses
    public void setWeeklyExpenses(double newWeeklyExpenses) {
        weeklyExpenses = newWeeklyExpenses;
    }

    public double getWeeklyExpenses() {
        return weeklyExpenses;
    }


    // Set and Get method for salary after tax
    public void setSalaryAfterTax(double newsalaryAfterTax) {
        salaryAfterTax = newsalaryAfterTax;
    }

    public double getSalaryAfterTax() {
        return salaryAfterTax;
    }


    // function to calculate taxes
    public double calTax() {
        if (resident == true) {
            if (grossSalary <= 18200) {
                netSalary = grossSalary;
                tax = 0;
                setNetSalary(netSalary);
            } else if (18200 < grossSalary && grossSalary <= 45000) {
                salaryAfterTax = 18200 + 0.81 * (grossSalary - 18200);
                tax = grossSalary - salaryAfterTax;
                if (grossSalary > 29032) {
                    netSalary = salaryAfterTax - 0.02 * grossSalary;
                    setNetSalary(netSalary);
                } else {
                    netSalary = salaryAfterTax;
                    setNetSalary(netSalary);
                }
            } else if (45000 < grossSalary && grossSalary <= 120000) {
                salaryAfterTax = 18200 + 0.81 * 26800 + 0.675 * (grossSalary - 45000);
                tax = grossSalary - salaryAfterTax;
                netSalary = salaryAfterTax - 0.02 * grossSalary;
                setNetSalary(netSalary);
            } else if (120000 < grossSalary && grossSalary <= 180000) {
                salaryAfterTax = 18200 + 0.81 * 26800 + 0.675 * 75000 + 0.63 * (grossSalary - 120000);
                tax = grossSalary - salaryAfterTax;
                netSalary = salaryAfterTax - 0.02 * grossSalary;
                setNetSalary(netSalary);
            } else if (180000 < grossSalary) {
                salaryAfterTax = 18200 + 0.81 * 26800 + 0.675 * 75000 + 0.63 * 60000 + 0.55 * (grossSalary - 180000);
                tax = grossSalary - salaryAfterTax;
                netSalary = salaryAfterTax - 0.02 * grossSalary;
                setNetSalary(netSalary);
            }
        } else if (resident == false) {
            if (grossSalary <= 120000) {
                netSalary = 0.675 * grossSalary;
                tax = grossSalary - netSalary;
            } else if (120000 < grossSalary && grossSalary <= 180000) {
                netSalary = 0.675 * 120000 + 0.63 * (grossSalary - 120000);
                tax = grossSalary - netSalary;
            } else if (180000 < grossSalary) {
                netSalary = 0.675 * 120000 + 0.63 * 60000 + 0.55 * (grossSalary - 180000);
                tax = grossSalary - netSalary;
            }
        }
        return tax;
    }

    public double calcMedicare() {
        if (grossSalary > 29032) {
            medicare = 0.02 * grossSalary;
        }
        return medicare;
    }
}
