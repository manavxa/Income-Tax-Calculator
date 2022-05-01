
/*Author: Manav Arora 
 *Student No: 3365762
 *Date: 29/04/2022
 *Description: Calculator Class
 */
import java.util.*;
import java.text.*;

public class CalculatorInterface { // class for taking input and output from user.
    double netSalary;
    String Yes = "yes";
    String No = "no";
    boolean resident = false;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void run() {
        Scanner console = new Scanner(System.in);
        Client client;

        client = new Client();

        String firstName;
        System.out.print("First Name = "); // taking first name
        firstName = console.nextLine();
        while (firstName.isEmpty()) {
            System.out.println("Error! First Name cannot be empty. Please enter again: ");
            System.out.print("First Name = ");
            firstName = console.nextLine();
        }

        System.out.print("Last Name = "); // taking last name
        String lastName = console.nextLine();
        while (lastName.isEmpty()) {
            System.out.println("Error! Last Name cannot be empty. Please enter again: ");
            System.out.print("Last Name = ");
            lastName = console.nextLine();
        }

        client.setName(firstName + " " + lastName);

        System.out.print("Enter your annual salary = "); // taking annual salary
        client.setGrossSalary(console.nextDouble());

        while (client.getGrossSalary() <= 0) {
            System.out.println("Error! Salary cannot be negative or zero. Please enter again: ");
            client.setGrossSalary(console.nextDouble());
        }

        System.out.println("Are you a resident? (yes / no) "); // taking resident status
        String residentCheck = console.next();

        if (residentCheck.equals(Yes)) {
            resident = true;
        }
        client.setResident(resident);

        System.out.println("---------------------------------");

        client.calTax();
        client.calcMedicare();

        // Setting conditions according to the calculations made in Client.java
        if (client.getGrossSalary() > 0) {
            if (resident == true) {
                if (client.getGrossSalary() <= 18200) {
                    System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                    System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));
                    System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                    System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));
                } else if (18200 < client.getGrossSalary() && client.getGrossSalary() <= 45000) {
                    if (client.getGrossSalary() > 29032) {
                        System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                        System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));

                        System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                        System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));

                        System.out.println(
                                "Since you are a resident you have to pay Medicare levy per year, which amounts to: " +
                                        df.format(client.getMedicare()));

                    } else {
                        System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                        System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));

                        System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                        System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));

                        System.out.println(
                                "Since you are a resident you have to pay Medicare levy per year, which amounts to: " +
                                        df.format(client.getMedicare()));
                    }
                } else if (45000 < client.getGrossSalary() && client.getGrossSalary() <= 120000) {
                    System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                    System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));
                    System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                    System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));
                    System.out.println(
                            "Since you are a resident you have to pay Medicare levy per year, which amounts to: " +
                                    client.getMedicare());
                } else if (120000 < client.getGrossSalary() && client.getGrossSalary() <= 180000) {
                    System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                    System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));

                    System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                    System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));

                    System.out.println(
                            "Since you are a resident you have to pay Medicare levy per year, which amounts to: " +
                                    df.format(client.getMedicare()));
                } else if (180000 < client.getGrossSalary()) {
                    System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                    System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));

                    System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                    System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));

                    System.out.println(
                            "Since you are a resident you have to pay Medicare levy per year, which amounts to: " +
                                    df.format(client.getMedicare()));
                }

                AccountInvestment(client.getNetSalary());
            } else if (resident == false) {
                if (client.getGrossSalary() <= 120000) {
                    System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                    System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));

                    System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                    System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));
                } else if (120000 < client.getGrossSalary() && client.getGrossSalary() <= 180000) {
                    System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                    System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));

                    System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                    System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));
                } else if (180000 < client.getGrossSalary()) {
                    System.out.println("Your net salary per year is: " + df.format(client.getNetSalary()));
                    System.out.println("Your net salary per week is: " + df.format(client.getNetSalary() / 52));

                    System.out.println("Amount of tax you should pay per year: " + df.format(client.getTax()));
                    System.out.println("Amount of tax you should pay per week: " + df.format(client.getTax() / 52));
                }
                AccountInvestment(client.getNetSalary());
            }

        }

    }

    // function to take the user input related to investment and output the
    // calculated amount back.
    public void AccountInvestment(double netSalary) {

        Client client;
        client = new Client();

        client.calTax();
        client.calcMedicare();

        Account account;
        account = new Account();

        int incrementingLength = 0;

        Scanner console = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("Enter your weekly expenses"); // taking weekly expenses
        double weeklyExpenses = console.nextDouble();

        while (weeklyExpenses > netSalary / 52) {
            System.out.println(
                    "Warning! You earn less than you spend. Would you like to re-enter your weekly expenses or terminate here? (Re-enter/Terminate)");
            console.nextLine();
            String decision = console.nextLine();
            switch (decision.toLowerCase()) {
                case "re-enter":
                    System.out.print("Weekly Expenses: ");
                    weeklyExpenses = console.nextDouble();
                    break;
                case "terminate":
                    System.exit(0);
                default:
                    System.out.print(
                            "Since you did not enter anything or entered something not in the options, program terminated! ");
                    System.exit(0);
            }
        }

        if (weeklyExpenses <= (netSalary) / 52) {
            System.out.println("Would you like to invest ? (yes / no)"); // investment choice
            String investDecision = console.next();

            if (investDecision.equals(Yes)) {
                System.out.println("The amount you want to invest per week:"); // weekly investment amount
                account.setAmount(console.nextDouble());
                while (account.getAmount() > netSalary / 52) {
                    System.out.println("Error! You needs cannot invest more than you earn. Please enter again: ");
                    System.out.println("The amount you want to invest per week:"); // weekly investment amount
                    account.setAmount(console.nextDouble());
                }
                System.out.println("Interest rate (between 1-20): "); // interest rate
                account.setRate(console.nextDouble());
                {
                    while (account.getRate() > 20 || account.getRate() < 1) {
                        System.out.println("Error! Interest Rate needs to be between 1% - 20%. Please enter again: ");
                        System.out.println("Interest rate (between 1-20): ");
                        account.setRate(console.nextDouble());
                    }
                }

                System.out.println("Investment length (# of weeks): "); // investment length
                account.setNumberOfWeeks(console.nextInt());
                while (account.getNumberOfWeeks() <= 0) {
                    System.out.println("Error! You cannot enter zero or negative number. Please enter again: ");
                    System.out.println("Investment length (# of weeks): "); // investment length
                    account.setNumberOfWeeks(console.nextInt());
                }

                if (account.getNumberOfWeeks() > 0) {
                    System.out.println("Investment Weeks | Balance"); // investment output

                    if (account.getNumberOfWeeks() < 4) {
                        account.calcInvestment(account.getNumberOfWeeks());
                        System.out.println((account.getNumberOfWeeks()) + "           " +
                                df.format(account.getMonthlyInvestment()));

                    } else {

                        while (incrementingLength < account.getNumberOfWeeks()) {

                            if (incrementingLength == 0) {
                                if (account.getNumberOfWeeks() < 4) {
                                    incrementingLength = account.getNumberOfWeeks();
                                    account.calcInvestment(incrementingLength);

                                    System.out.println(
                                            incrementingLength + "                  "
                                                    + df.format(account.getMonthlyInvestment()));
                                } else {
                                    incrementingLength = incrementingLength + 4;
                                    account.calcInvestment(incrementingLength);

                                    System.out.println(
                                            incrementingLength + "                  "
                                                    + df.format(account.getMonthlyInvestment()));
                                }

                            }

                            if ((account.getNumberOfWeeks() - incrementingLength) >= 4) {
                                incrementingLength = incrementingLength + 4;
                                account.calcInvestment(incrementingLength);

                                System.out.println(
                                        incrementingLength + "                  "
                                                + df.format(account.getMonthlyInvestment()));
                            } else {
                                int tempWeeks = incrementingLength;
                                incrementingLength = account.getNumberOfWeeks() - incrementingLength;
                                account.calcInvestment(incrementingLength);
                                System.out.println((incrementingLength + tempWeeks) + "                 " +
                                        df.format(account.getMonthlyInvestment()));
                                break;
                            }

                        }
                    }
                }
            } else if (investDecision.equals(No)) {
                System.out.println("You have chosen not to invest");
            }
        } else if (weeklyExpenses > (netSalary) / 52) {
            System.out.println("You cannot invest");
        }
    }

    public static void main(String[] args) {
        CalculatorInterface calc = new CalculatorInterface();
        calc.run();
    }
}