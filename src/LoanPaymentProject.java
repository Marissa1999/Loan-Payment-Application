//Programmer: Marissa Gonçalves
//Date: October 10, 2017
//Purpose: This program allows to prompt for a loan amount and an amortization table is created to determine how the loan is paid off.

import java.text.NumberFormat;
import java.util.Scanner;

public class LoanPaymentProject

{

    	   public static void main (String[]args)

    {

            //define a scanner
            Scanner keyboard = new Scanner (System.in);




            //print out a message of the program
            System.out.println ("Personal Loan Payment Calculator");
            System.out.println ("================================");






            //allow the user to enter a loan amount in double format
            System.out.print ("Enter loan amount                : ");


            //peek at the error that can occur
             if (!keyboard.hasNextDouble())
             {
                System.out.println ("Error: the input is not a double value.");
                System.out.println ("Try again later.");
                System.exit(1);
             }


            //read the input as a double value
            double loanAmount = keyboard.nextDouble();







            //allow the user to enter a loan term as an integer
            System.out.print ("Enter loan term (months)         : ");


            //peek at the error that can occur
             if (!keyboard.hasNextInt())
             {
                System.out.println ("Error: the input is not an integer.");
                System.out.println ("Try again later.");
                System.exit(1);
             }


            //read the input as an integer
            int loanTerm = keyboard.nextInt();





            //allow the user to enter an interest rate in double format
            System.out.print ("Enter interest rate (% per year) : ");


             //peek at the error that can occur
             if (!keyboard.hasNextDouble())
             {
                System.out.println ("Error: the input is not a double value.");
                System.out.println ("Try again later.");
                System.exit(1);
             }


            //read the input as a double value
            double interestRate = keyboard.nextDouble();





            //print out more information about what the program consists
            System.out.println ();
            System.out.println ("               Loan Payment and Amortization Table               ");
            System.out.println ("=================================================================");
            System.out.println ("Month   Beginning     Monthly   Principal    Interest      Ending");
            System.out.println ("    #     Balance     Payment        Paid        Paid     Balance");
            System.out.println ("=================================================================");




            //calculate the monthly rate and monthly payment based on the user's inputs
            double monthlyRate = (interestRate / 100) * (1.0 / 12.0);
            double monthlyPayment = (monthlyRate * loanAmount) / (1.0 - (Math.pow (1.0 + monthlyRate, -loanTerm)));





            //allow the values to be recognized before the loop is executed
            int month = 1;
            double interestPaid = 0;
            double principalPaid = 0;
            double beginningBalance = loanAmount;
            double endingBalance = 0;
            double totalInterestPaid = 0;


            //allow the following numbers to be converted into currency format
            NumberFormat formatter = NumberFormat.getCurrencyInstance();


            //allow the information to calculated in loops based on the number of months for each row
            for (month = 1; month <= loanTerm; month++)
            {

            interestPaid = beginningBalance * monthlyRate;
            principalPaid = monthlyPayment - interestPaid;
            endingBalance = beginningBalance - principalPaid;
            System.out.printf("%5d  %10.2f  %10.2f  %10.2f  %10.2f  %10.2f  %n", month, beginningBalance, monthlyPayment, principalPaid, interestPaid, endingBalance);
            beginningBalance = endingBalance;
            totalInterestPaid += interestPaid;

            }



            //print out the design of the program with equal signs
            System.out.println ("=================================================================");


            //skip a line
            System.out.println ();


            //print out the summary of the inputs and the calculated results
            System.out.println ("Summary:");
            System.out.println ("========");
            System.out.printf ("%-25s%s\n", "Loan Amount:", formatter.format(loanAmount));
            System.out.printf ("%-25s%s\n", "Monthly Payment:", formatter.format(monthlyPayment));
            System.out.println ("Number of Payments:      " + loanTerm);
            System.out.printf ("%-25s%s\n", "Total Interest Paid:", formatter.format(totalInterestPaid));
            System.out.println ("Annual Interest Rate:    " + interestRate + "%");


    }
}

