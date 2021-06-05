package ex20.base;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
Exercise 20 - Multistate Sales Tax Calculator
More complex programs may have decisions nested in other decisions, so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total for everyone else.
//5.5*
Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.
Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
Challenges
Add support for your state and county.
Allow the user to enter a state abbreviation and county name in upper, lower, or mixed case.
Allow the user to also enter the state’s full name in upper, lower, or mixed case.
Implement the program using data structures to avoid nested if statements.
 */
public class App {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        App myApp = new App();
        int amount = myApp.readAmount();

        String output = myApp.createOutput(amount);

        myApp.displayOutput(output);

    }
    private int readAmount(){
        System.out.print("What is the order amount? ");
        int num =in.nextInt();
        in.nextLine();
        return num;


    }
    private String createOutput(int amount){
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.print("What state do you live in? ");
        String state = in.nextLine();
        state = state.toLowerCase();
        double tax;
        if(state.equals("wisconsin")){
            System.out.print("What county do you live in? ");
            String county = in.nextLine();
            county = county.toLowerCase();
            if(county.equals("eau claire")){

                //5.5%
                tax = (double)Math.round((amount * 0.055)*100d)/100d;
                return "The tax is $" + df.format(tax) + "\nThe total is $" + df.format(tax+amount) + ".";
            }
            if(county.equals("dunn")){
                //5.4%

                tax = (double)Math.round((amount * 0.054)*100d)/100d;
                return "The tax is $" + df.format(tax) + "\nThe total is $" + df.format(tax+amount) + ".";
            }
            else{
                tax = (double)Math.round((amount * 0.050)*100d)/100d;
                return "The tax is $" + df.format(tax) + "\nThe total is $" + df.format(tax+amount) + ".";
            }

        }
        if((state).equalsIgnoreCase("illinois")){
            //8%
            tax = (double)Math.round((amount * 0.08)*100d)/100d;
            return "The tax is $" + df.format(tax) + "\nThe total is $" + df.format(tax+amount) + ".";

        }
        else {
         return "The total is $" + df.format(amount);
         //no tax
        }

    }
    private void displayOutput(String output){
        System.out.println(output);
    }
}
