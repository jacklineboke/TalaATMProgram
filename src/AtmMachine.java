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
    private static double balance = 150000; //Initial balance for everyone
    private static int anotherTransaction; 
    static double withdrawn = 0; //Default value for the withdrawn amount
    static double maxwithdraw = 50000; //Marks the maximum withdrawal amount
    static double deposited = 0; //Default value for the deposited amount
    static double maxdeposit = 150000; //Marks the maximum withdrawal amount
    static int depositfrequency=0; //Initial deposit Frequency
    static int withdrawfrequency=0; //Initial withdrawal Frequency
 
    public static void main(String args[]){
        in = new Scanner(System.in);
 
        // call our transaction method here 
        transaction();
    }
 
    public static void transaction(){
        // here is where most of work is

    	int choice; 
 
        //Main Menu
    	System.out.println("Please select an option"); 
        System.out.println("1. Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Quit");
 
        choice = in.nextInt();
 
        switch(choice){
            case 1:
            	 // this option is to check balance 
                System.out.println("Available balance is "+ String.format("%.2f",balance)+"\n");
                anotherTransaction();  //Prompts user whether to quit or continue with other transactions 
            break; 
 
            case 2:
                // option number 2 is depositing 
                String rawdeposit; //stores the user input in case of text
                System.out.println("Enter deposit amount and press enter (or type Menu and press enter to go back to Main Menu): "); 
                rawdeposit = in.next();
                depositing(rawdeposit);
                System.out.println("Account balance is Kshs " +  String.format("%.2f",balance));
                anotherTransaction();
                
            break; 
 
            case 3:
                // option number 3 is withdrawing 
                String rawwithdraw;  
                System.out.println("Enter withdrawal amount and press enter (or type Menu and press enter to go back to Main Menu): "); 
                rawwithdraw = in.next();
                withdrawing(rawwithdraw);
                System.out.println("Account balance is Kshs: " +  String.format("%.2f",balance));
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
            	System.out.println("Thank you for using our services.");
                      }
             break;
            default:
                System.out.println("Invalid option:\n\n"); 
                anotherTransaction();
            break;
        }
 
    } 
 
public static void anotherTransaction(){
        System.out.println("\n Do you want another transaction?\n 1. Another transaction\n2. Exit");
        anotherTransaction = in.nextInt();
        if(anotherTransaction == 1){
            transaction(); // call transaction method
        } else if(anotherTransaction == 2){
            System.out.println("Thank you for using our services");
        } else {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }

public static double balances() {
		return balance;
	            	   	    	}
             
public static double depositing(String rawdeposit) {
	double deposit = 0; //stores the user input in case of numbers
	if(rawdeposit.equals("menu")) {
    	transaction(); // call transaction method
    } else {
    	deposit = Double.parseDouble(rawdeposit); //converting user input from text to numbers
    }
    
    if(deposit <1) { //check allowed transaction deposit amount 
		  
	      System.out.println("Deposit amount is less than the Minimum allowed amount of Ksh 1.");
    	   	} 
			   else if(deposit <= 40000) { //check allowed amount per transaction 
		  if (maxdeposit >= deposit) { //check maximum allowed deposit amount per day 
			  if (depositfrequency <=3) { //check daily allowed deposit frequency
	      balance += deposit;   // update balance
	      deposited += deposit;
	   maxdeposit -= deposit;
	      depositfrequency++; //increasing the deposit frequency
	   	           	   	} else { //check daily deposit frequency
			  
	   	         System.out.println("Daily Deposit Frequency Exceeded ");
	                }
 	            	   	    	}else { //check maximum allowed deposit amount per day 
 	            	   	  System.out.println("Daily Deposit Amount Exceeded ");
 	            	   	    	}
				    				  
	   			      	  } else { //check allowed amount per transaction
	          	   System.out.println("Kshs " + deposit + " Exceeds the allowed deposit limit per transaction");
	            	   	    	}
             
			return balance;
	
}
    
 public static double withdrawing(String rawwithdraw) { 
    
	 double amount = 0; 
    
    if(rawwithdraw.equals("menu")) {
    	transaction(); // call transaction method
    } else {
    	amount = Double.parseDouble(rawwithdraw); //converting user input from text to numbers
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
   	           	   	} else { //check daily withdrawal amount
			  
	   	         System.out.println("Daily Withdrawal Frequency Exceeded ");
	                }
 	            	   	    	}else {
 	            	   	  System.out.println("Daily Withdrawal Amount Exceeded ");
 	            	   	    	}
				    				  
	   			      	  } else { //check allowed transaction withdrawal amount
	          	   System.out.println("Kshs " + amount + " Exceeds the allowed withdrawal limit per transaction");
	          	       	   	    	}
            return balance;
}
    
}