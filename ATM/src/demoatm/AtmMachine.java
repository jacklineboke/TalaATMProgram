package demoatm;

import java.util.Scanner;
 
public class AtmMachine{
 
    private static Scanner in; 
    private static float balance = 150000; // initial balance to 150000 for everyone
    private static int quit;
    private static int anotherTransaction;
    static double withdrawn = 0;
    static double maxwithdraw = 50000;
    static double deposited = 0;
    static double maxdeposit = 150000;
    static int depositfrequency=0;
    static int withdrawfrequency=0;
 
    public static void main(String args[]){
        in = new Scanner(System.in);
 
        // call our transaction method here 
        transaction();
    }
 
    private static void transaction(){
        // here is where most of work is
 
        int choice; 
 
        System.out.println("Please select an option"); 
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Quit");
 
        choice = in.nextInt();
 
        switch(choice){
            case 1:
            	 // this option is to check balance 
                System.out.println("Available balance is "+balance+"\n");
                anotherTransaction(); 
            break; 
 
            case 2:
                // option number 2 is depositing 
                float deposit; 
                System.out.println("Enter deposit amount and press enter (or type Menu and press enter to go back to Main Menu): "); 
                deposit = in.nextFloat();
                               
                if(deposit <1) { //check allowed transaction deposit amount 
         		  
         	      System.out.println("Deposit amount is less than the Minimum allowed amount of Ksh 1.");
                	   	} 
         			   else if(deposit <= 40000) { //check allowed transaction deposit amount
         		  if (maxdeposit >= deposit) {
         			  if (depositfrequency <=3) {
           	      balance += deposit;   // update balance
           	      deposited += deposit;
           	   maxdeposit -= deposit;
           	      depositfrequency++;
           	      System.out.println("You have deposited Kshs"+ deposit);
           	    System.out.println("Your new balance is Kshs: " + balance);
           	    System.out.println("Total Deposited amount for the day is Kshs: " + deposited);
           	 System.out.println("Deposit Remaining for the day is Kshs: " + maxdeposit);
           	    System.out.println("Deposit Frequency: " + depositfrequency);
           	   	           	   	} else { //check daily deposit amount
         			  
           	   	         System.out.println("Daily Deposit Frequency Exceeded ");
           	                }
             	            	   	    	}else {
             	            	   	  System.out.println("Daily Deposit Amount Exceeded ");
             	            	   	    	}
         				    				  
          	   			      	  } else { //check allowed transaction deposit amount
         	          	   System.out.println("Kshs " + deposit + " Exceeds the allowed deposit limit per transaction");
         	          	       	   	    	}
                         anotherTransaction();
            break; 
 
            case 3:
               float amount; 
                System.out.println("Enter amount and press enter (or type menu and press enter to go back to main menu): "); 
                amount = in.nextFloat();
                if(amount > balance || amount == 0){
                    System.out.println("You have insufficient funds\n\n"); 
                    anotherTransaction(); // ask if they want another transaction
                } else if(amount <= balance && amount <=20000) {
                    // they have some cash
                    // update balance 
                    balance = balance - amount; 
                    System.out.println("You have withdrawn "+amount+" and your new balance is "+balance+"\n");
                    
                    anotherTransaction(); 
                }
                else {
                    // update balance 
                    balance +=0; 
                    System.out.println("Invalid "+balance+"\n");
                    
                    anotherTransaction(); 
                }
            break;
            case 4:
                int quit; 
                System.out.println("Are you sure you want to quit? \n1. Yes\n2. No\n");
            	quit = in.nextInt();
            	if (quit == 2) {//continue
            	transaction();
            	}
            	if (quit == 1) {//quit
            	System.out.println("Thanks for choosing us. Good Bye.");
                      }
             break;
            default:
                System.out.println("Invalid option:\n\n"); 
                anotherTransaction();
            break;
        }
 
    } 
 
    private static void anotherTransaction(){
        System.out.println("\n Do you want another transaction?\nPress 1 for another transaction\n2 To exit");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction(); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println("Thanks for choosing us. Good Bye!");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
}