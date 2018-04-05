/**
 * 
 */

/**
 * @author jackline
 *
 */
import java.util.Scanner;
 
public class AtmMachine{
 
    private static Scanner in; 
    private static double balance = 150000; // initial balance to 150000 for everyone
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
                String rawdeposit; 
                double deposit = 0; 
                System.out.println("Enter deposit amount and press enter (or type Menu and press enter to go back to Main Menu): "); 
                rawdeposit = in.next();
                
                if(rawdeposit.equals("menu")) {
                	transaction(); // call transaction method
                } else {
                	deposit = Double.parseDouble(rawdeposit);
                }
                
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
                // option number 3 is withdrawing 
                String rawwithdraw; 
                double amount = 0; 
                System.out.println("Enter withdrawal amount and press enter (or type Menu and press enter to go back to Main Menu): "); 
                rawwithdraw = in.next();
                
                if(rawwithdraw.equals("menu")) {
                	transaction(); // call transaction method
                } else {
                	amount = Double.parseDouble(rawwithdraw);
                }
                
                if(amount <1) { //check allowed transaction withdrawal amount 
         		  
         	      System.out.println("Withdrawal amount is less than the Minimum allowed amount of Ksh 1.");
                	   	} 
         			   else if(amount <= 20000) { //check allowed transaction withdrawal amount
         		  if (maxwithdraw >= amount) {
         			  if (withdrawfrequency <=2) {
           	      balance -= amount;   // update balance
           	      withdrawn += amount;
           	   maxwithdraw -= amount;
           	      withdrawfrequency++;
           	      System.out.println("You have withdrawn Kshs"+ amount);
           	    System.out.println("Your new balance is Kshs: " + balance);
           	    System.out.println("Total Withdrawn amount for the day is Kshs: " + withdrawn);
           	 System.out.println("Withdrawal Amount Remaining for the day is Kshs: " + maxwithdraw);
           	    System.out.println("Withdrawal Frequency: " + withdrawfrequency);
           	   	           	   	} else { //check daily withdrawal amount
         			  
           	   	         System.out.println("Daily Withdrawal Frequency Exceeded ");
           	                }
             	            	   	    	}else {
             	            	   	  System.out.println("Daily Withdrawal Amount Exceeded ");
             	            	   	    	}
         				    				  
          	   			      	  } else { //check allowed transaction withdrawal amount
         	          	   System.out.println("Kshs " + amount + " Exceeds the allowed withdrawal limit per transaction");
         	          	       	   	    	}
                         anotherTransaction();
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