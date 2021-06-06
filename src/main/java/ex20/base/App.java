package ex20.base;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 *  UCF COP3330 Summer 2021 Assignment 20 Solution
 *  Copyright 2021 William Weatherlow
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
