package BankAccount;


import java.util.Scanner;


public class BankAccount {
    
    Account useAccount = new Account(); //Allow the use of methods from the Account Class
       
    
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in); //Allow input from the keyboard

        Account useAccount = new Account(); //Allow the use of methods from the Account Class
        int useMenu = 1;
        useAccount.setCheckingBalance(100000);
        useAccount.setSavingBalance(250000);
        useAccount.setCash(50000);
        
        System.out.println(("Starting balance for your Checking Account is ") + useAccount.getCheckingBalance());
        System.out.println(("Starting balance for your Saving Account is ") + useAccount.getCheckingBalance());
        System.out.println(("Starting balance for Cash on hand is ") + useAccount.getCash());


        do {

            System.out.println("Welcome to Bank Main Menu. \n");
            System.out.println("Enter 1: To Withdraw Cash.") ;
            System.out.println("Enter 2: To Deposit Cash.") ;
            System.out.println("Enter 3: To Transfer Cash From Checking to Savings Account.") ;
            System.out.println("Enter 4: To Transfer Cash From Savings to Checking Account.") ;
            System.out.println("Enter 5: To Access Bond Menu.") ;
            System.out.println("Enter 6: To View Your Available Balances.") ;
            System.out.println("Enter 7: To Exit Program. \n") ;

            int menuOption = keyboard.nextInt();

            switch (menuOption)
            {
                case 1 : {
                    System.out.println("Select the account you wish to withdraw from ");
                    System.out.println("Enter 1: To Withdraw From Checking Account. ") ;
                    System.out.println("Enter 2: To Withdraw From Savings Account. ") ;
                    System.out.println("Enter 3: To Exit. ") ;

                    int withdrawCheck = keyboard.nextInt();

                    switch (withdrawCheck) {
                        case 1: {
                            useAccount.withdrawChecking();
                            break;
                        
                        }
                        case 2: {
                            useAccount.withdrawSaving();
                            break;
                    }
                        case 3: {
                            return;                            
                    }
                        default: {
                            System.out.println("Error. Invalid Option.");
                        }
                    }
                }break;
                    
                case 2: {
                    
                       
                    System.out.println("Select the account you wish to withdraw from.");
                    System.out.println("Enter 1: To Deposit From Checking Account. ") ;
                    System.out.println("Enter 2: To Withdraw From Savings Account. ") ;
                    System.out.println("Enter 3: To Exit. ") ;

                    int depositCheck = keyboard.nextInt();

                    switch (depositCheck) {
                        case 1: {
                            useAccount.depositChecking();
                            break;
                        
                        }
                        case 2: {
                            useAccount.depositSaving();
                            break;
                    }
                        case 3: {
                            return;
                            
                    }
                        default: {
                            System.out.println("Error. Invalid Option.");
                        }
                    }
                }break;

                case 3:{
                    System.out.println("Enter 1: To Transfer Cash From Checking to Savings Account.") ;
                    System.out.println("Enter 2: To Exit.") ;
                    int transferAmount = keyboard.nextInt();

                    switch (transferAmount) {
                        case 1: {
                            useAccount.transferToSaving();
                            break;
                        
                        }
                        case 2: {
                            return;
                            
                    }                        
                        default: {
                            System.out.println("Error. Invalid Option.");
                        }
                    }
                }break;
                case 4: {
                    System.out.println("Enter 1: To Transfer Cash From Savings to Checking Account.") ;
                    System.out.println("Enter 2: To Exit.") ;
                    int transferAmount = keyboard.nextInt();

                    switch (transferAmount) {
                        case 1: {
                            useAccount.transferFromSaving();
                    break;
                        }
                        
                        case 2: {
                            return;                            
                    }                        
                        default: {
                            System.out.println("Error. Invalid Option.");
                        }
                    }
                }break;
                    
                case 5: {
                    useAccount.bondMenu();
                    break;
                }
                case 6: {
                    System.out.println("Here is your Account Balance.");
                    System.out.println(("Checking :$") + useAccount.getCheckingBalance());
                    System.out.println(("Saving :$") + useAccount.getSavingBalance());
                    System.out.println(("Cash :$") + useAccount.getCash());
                    
                    break;
                }
                case 7: {
                    System.exit(0);
                }
                default: {
                    System.out.println("Error. Invalid Option.");
                }
                    
            }






        } while (useMenu == 1);
        
    }


   
}
