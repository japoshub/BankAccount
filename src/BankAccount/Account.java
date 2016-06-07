package BankAccount;

import java.util.Scanner;


public class Account {

    private int checkingBalance;  //Our variable to always hold amount of money in Checking Account.
    private int savingBalance;    //Our variable to always hold amount of money in Saving Account.
    private int cashOnHand;
    private static int bondBuyPrice = 5000;
    private int amountOfBondsFive = 0;
    private int amountOfBondsTen = 0;
    private int amountOfBondsTwenty = 0;
    private static int sellRate = 500;


    Scanner keyboard = new Scanner(System.in);  //Allow input from the keyboard


    public void setCheckingBalance(int cash_In_Checking) {

        checkingBalance = cash_In_Checking; //Setter to update current cash in the Checking Account.

    }

    public void setSavingBalance(int cash_In_Saving) {

        savingBalance = cash_In_Saving;    //Setter to update current cash in the Saving Account.
    }


    public int getCheckingBalance() {

        return checkingBalance; //Getter to return how much cash the user has
    }

    public int getSavingBalance() {

        return savingBalance; //Getter to return how much cash the user has
    }

    public void printCheckingBalance(){
        System.out.println(("Your updated Checking Balance is ") + getCheckingBalance());
    }

    public void printSavingBalance(){
        System.out.println(("Your updated Savings Balance is ") + getSavingBalance());
    }
    
    public void printCash(){
        System.out.println(("Your updated Cash Balance is ") + getCash());
    }

    public void printAmountOfBondFive(){
        System.out.println(("Your updated 5 Year Bond Balance is ") + amountOfBondsFive + " bonds.");
    }
    
    public void printAmountOfBondTen(){
        System.out.println(("Your updated 10 Year Bond Balance is ") + amountOfBondsTen + " bonds.");
    }
    
    public void printAmountOfBondTwenty(){
        System.out.println(("Your updated 20 Year Bond Balance is ") + amountOfBondsTwenty + " bonds.");
    }
    
    public void transferToSaving() {  //Method to transfer funds from Checking Account to Savings Account

        Scanner transferKeyboard = new Scanner(System.in);
        
        System.out.println("Please enter the amount you wish transfer from Checkings to Savings. ");
        int amount = transferKeyboard.nextInt(); //Asks user to input amount desired to transfer from Checking Account

        if (amount < 0)  //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Transfer amount cannot be less than 0. \n");

        else if (amount > checkingBalance)  /**Makes sure the user does not input an amount greater
         than Checking balance**/
            System.out.println("Error. Invalid amount. Transfer amount cannot be greater than your balance. \n");

        else if (amount > 0 && amount <= checkingBalance) { /**The amount the user requested will be increased in Savings and removed from
         Checking**/
            checkingBalance = checkingBalance - amount;
            savingBalance = savingBalance + amount;
            printCheckingBalance();
            printSavingBalance();
            
        }
    }

    public void transferFromSaving() {  //Method to transfer funds from Savings to Checking Account

        Scanner transferKeyboard = new Scanner(System.in);
        
        System.out.println("Please enter the amount you wish transfer from Savings to Checking . \n");
        int amount = transferKeyboard.nextInt(); //Asks user to input amount desired to transfer from Savings

        if (amount < 0)  //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Transfer amount cannot be less than 0. \n");

        else if (amount > savingBalance)  /**Makes sure the user does not input an amount greater
         than the current Savings balance**/
            System.out.println("Error. Invalid amount. Transfer amount cannot be greater than your balance. \n");

        else if (amount > 0 && amount <= savingBalance) {  /**The amount the user requested will be increased in Checkings and removed from
         Savings**/

            checkingBalance = checkingBalance + amount;
            savingBalance = savingBalance - amount;
            printCheckingBalance();
            printSavingBalance();

            
        }
       
    }

    public void setCash(int Cash_On_Hand) {  //Set amount of cash the user has

        cashOnHand = Cash_On_Hand;
    }

    public int getCash() {  //Used to get and/or print the amount of cash the user has

        return cashOnHand;
    }

    public void depositChecking() {  // Method to deposit cash into Checkings

        Scanner cashkeyboard = new Scanner (System.in);
        
        System.out.println("Please enter the amount you wish to deposit to your Checking account. \n");
        int amount = cashkeyboard.nextInt();  //Asks user to input amount desired to deposit from cash

        if (amount < 0)     //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Transfer amount cannot be less than 0. \n");

        else if (amount > cashOnHand)  //Makes sure the user does not input an amount greater than cash on hand
            System.out.println("Error. Invalid amount. Transfer amount cannot be greater than your total cash. \n");

        else if (amount > 0 && amount <= cashOnHand) {  //The amount the user requested will be increased in Checkings and removed from
            //cash on hand
            int newAmount = getCheckingBalance() + amount;
            checkingBalance = newAmount;
            cashOnHand = cashOnHand - amount;

            /**Prints balances for the affected accounts**/
            printCheckingBalance();
            printCash();
        }
    }

    public void depositSaving() {  // Method to depost cash into Savings

        Scanner cashkeyboard = new Scanner (System.in);

        System.out.println("Please enter the amount you wish to deposit to your Savings account \n");
        int amount = cashkeyboard.nextInt();  //Asks user to input amount desired to deposit from cash

        if (amount <= 0)     //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Transfer amount cannot be less than 0. \n");

        else if (amount > cashOnHand)  //Makes sure the user does not input an amount greater than cash on hand
            System.out.println("Error. Invalid amount. Transfer amount cannot be greater than your total cash. \n");

        else if (amount > 0 && amount <= cashOnHand) {  //The amount the user requested will be increased in Savings and removed from
            //cash on hand
            int newAmount = savingBalance + amount;
            savingBalance = newAmount;
            cashOnHand = cashOnHand - amount;

            /**Prints balances for the affected accounts**/
            printSavingBalance();
            printCash();
        }
    }

    public void withdrawChecking() {  // Method to withdraw cash from Checking account

        Scanner cashkeyboard = new Scanner(System.in);
                
        System.out.println("Please enter the amount you wish to withdraw from your Checking account. \n");
        int amount = cashkeyboard.nextInt();  //Asks user to input amount desired to withdraw from Checking account.

        if (amount <= 0) {     //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Withdrawal amount cannot be less than 0. \n");
        }

        else if (amount > checkingBalance) {  //Makes sure the user does not input an amount greater Checking balance
            System.out.println("Error. Invalid amount. Withdrawal amount cannot be greater than your Checking balance. \n");
        }

        else if (amount > 0 && amount <= checkingBalance) {   //The amount the user requested will be decreased from Checking account
            //and withdrawn to cash on hand
            int newAmount = checkingBalance - amount;
            checkingBalance = newAmount;
            cashOnHand = cashOnHand + amount;

            /**Prints balances for the affected accounts**/
            printCheckingBalance();
            printCash();
        }
    }
    

    public void withdrawSaving() {  // Method to withdraw cash from Savings account

        Scanner cashkeyboard = new Scanner(System.in);

        System.out.println("Please enter the amount you wish to withdraw from your Savings account. \n");
        int amount = cashkeyboard.nextInt();  //Asks user to input amount desired to withdraw from Savings account.

        if (amount < 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Withdrawal amount cannot be less than 0. \n");
        }

        else if (amount > savingBalance) { //Makes sure the user does not input an amount greater than Savings balance
            System.out.println("Error. Invalid amount. Withdrawal amount cannot be greater than your Savings balance. \n");
        }
        else if (amount > 0 && amount < savingBalance) {  /**The amount the user requested will be decreased from Saving account
         and withdrawn to cash on hand**/
            int newAmount = savingBalance - amount;
            savingBalance = newAmount;
            cashOnHand = cashOnHand + amount;

            /**Prints balances for the affected accounts**/
            printSavingBalance();
            printCash();

        }

}
    
    /******************************************************************************/
    
      public void bondMenu() {

        System.out.println("Hello! \n Welcome to the Bond Menu. \n Bonds cost $5000 and come with a coupon rate of 10%. \n");
        System.out.println("You have the option to purchase bonds that mature at 5, 10, or 20 years. \n");

        System.out.println("Welcome to Bond Main Menu. \n");
        System.out.println("Enter 1: To Buy 5 Year Bonds.") ;
        System.out.println("Enter 2: To Buy 10 Year Bonds.") ;
        System.out.println("Enter 3: To Buy 20 Year Bonds.") ;
        System.out.println("Enter 4: To Sell Bonds ") ;
        System.out.println("Enter 5: To Exit Menu \n") ;

        int menuOptionBond = keyboard.nextInt();
        int userBondMenu = 1;

        do {
            switch (menuOptionBond){

                case 1: {
                    
                    Scanner bondFive = new Scanner(System.in);
                    System.out.println("Enter 1: To Buy 5 Year Bonds with Checking Account.") ;
                    System.out.println("Enter 2: To Buy 5 Year Bonds with Savings Account.") ;
                    System.out.println("Enter 3: To Buy 5 Year Bonds with Cash on hand.") ;
                    System.out.println("Enter 4: To Exit.") ;
                    int buyOption = bondFive.nextInt();
                    
                    switch (buyOption){
                        
                        case 1:{
                            buyBond5Check();
                            break;
                        }
                        case 2: {
                            buyBond5Save();
                            break;
                        }
                        case 3: {
                            buyBond5Cash();
                            break;
                        }
                        case 4:{
                            return;
                        }
                        default: {
                            System.out.println("Error. Invalid Selection");
                        }
                    }
                                        
                }break;
                case 2: {
                    Scanner bondTen = new Scanner(System.in);
                    System.out.println("Enter 1: To Buy 10 Year Bonds with Checking Account.") ;
                    System.out.println("Enter 2: To Buy 10 Year Bonds with Savings Account.") ;
                    System.out.println("Enter 3: To Buy 10 Year Bonds with Cash on hand.") ;
                    System.out.println("Enter 4: To Exit.") ;
                    int buyOption = bondTen.nextInt();
                    
                    switch (buyOption){
                        
                        case 1:{
                            buyBond10Check();
                            break;
                        }
                        case 2: {
                            buyBond10Save();
                            break;
                        }
                        case 3: {
                            buyBond10Cash();
                            break;
                        }
                        case 4:{
                            return;
                        }
                        default: {
                            System.out.println("Error. Invalid Selection");
                        }
                    }
                }break;
                case 3: {
                    Scanner bondTwenty = new Scanner(System.in);
                    System.out.println("Enter 1: To Buy 10 Year Bonds with Checking Account.") ;
                    System.out.println("Enter 2: To Buy 10 Year Bonds with Savings Account.") ;
                    System.out.println("Enter 3: To Buy 10 Year Bonds with Cash on hand.") ;
                    System.out.println("Enter 4: To Exit.") ;
                    int buyOption = bondTwenty.nextInt();
                    
                    switch (buyOption){
                        
                        case 1:{
                            buyBond20Check();
                            break;
                        }
                        case 2: {
                            buyBond20Save();
                            break;
                        }
                        case 3: {
                            buyBond20Cash();
                            break;
                        }
                        case 4:{
                            return;
                        }
                        default: {
                            System.out.println("Error. Invalid Selection");
                        }
                    }
                }break;                
                case 4: {                    
                    if (amountOfBondsFive + amountOfBondsTen + amountOfBondsTwenty == 0){        
                        
                         System.out.println("You don't own any Bonds. Purchase some first to be able to sell.");
                    return;
                    }else if (amountOfBondsFive + amountOfBondsTen + amountOfBondsTwenty != 0) {
                         sellBond();
                    break;
                    }                         
                }break;
                case 5: {
                    userBondMenu = 0;
                    return;
                }
                default: {
                    System.out.println("Incorrect Selection. Try Again.");
                }
            }
        } while (userBondMenu == 1);
    }

    public void setAmountOfBondsFive(int bondAmount) {

        amountOfBondsFive = amountOfBondsFive + bondAmount;
    }

    public void setAmountOfBondsTen(int bondAmount) {

        amountOfBondsTen = amountOfBondsTen + bondAmount;
    }

    public void setAmountOfBondsTwenty(int bondAmount) {

        amountOfBondsTwenty = amountOfBondsTwenty + bondAmount;
    }

    

    public void buyBond5Check() {

        int totalBuyAmount = (getCheckingBalance() / bondBuyPrice);;
        
        System.out.println(("Your Checking Account balance is $") + getCheckingBalance());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 5 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             checkingBalance = checkingBalance - totalBuyAmount;
             amountOfBondsFive = amountOfBondsFive + amount ;
             printCheckingBalance();
             printAmountOfBondFive();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }
    
    public void buyBond5Save() {

        int totalBuyAmount = (getSavingBalance() / bondBuyPrice);;
        
        System.out.println(("Your Savings Account balance is $") + getSavingBalance());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 5 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             savingBalance = savingBalance - totalBuyAmount;
             amountOfBondsFive = amountOfBondsFive + amount ;
             printSavingBalance();
             printAmountOfBondFive();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }
    
    public void buyBond5Cash() {

        int totalBuyAmount = (getCash() / bondBuyPrice);;
        
        System.out.println(("Your Cash balance is $") + getCash());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 5 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             cashOnHand = cashOnHand - totalBuyAmount;
             amountOfBondsFive = amountOfBondsFive + amount ;
             printCash();
             printAmountOfBondFive();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }
        
         
    public void buyBond10Check() {

        int totalBuyAmount = (getCheckingBalance() / bondBuyPrice);;
        
        System.out.println(("Your Checking Account balance is $") + getCheckingBalance());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 10 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             checkingBalance = checkingBalance - totalBuyAmount;
             amountOfBondsTen = amountOfBondsTen + amount ;
             printCheckingBalance();
             printAmountOfBondTen();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }

    public void buyBond10Save() {

        int totalBuyAmount = (getSavingBalance() / bondBuyPrice);;
        
        System.out.println(("Your Savings Account balance is $") + getSavingBalance());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 10 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             savingBalance = savingBalance - totalBuyAmount;
             amountOfBondsTen = amountOfBondsTen + amount ;
             printSavingBalance();
             printAmountOfBondTen();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }
    
    public void buyBond10Cash() {

        int totalBuyAmount = (getCash() / bondBuyPrice);;
        
        System.out.println(("Your Cash balance is $") + getCash());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 10 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             cashOnHand = cashOnHand - totalBuyAmount;
             amountOfBondsTen = amountOfBondsTen + amount ;
             printCash();
             printAmountOfBondTen();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }
    
    public void buyBond20Check() {

        int totalBuyAmount = (getCheckingBalance() / bondBuyPrice);;
        
        System.out.println(("Your Checking Account balance is $") + getCheckingBalance());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 20 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             checkingBalance = checkingBalance - totalBuyAmount;
             amountOfBondsTwenty = amountOfBondsTwenty + amount ;
             printCheckingBalance();
             printAmountOfBondTwenty();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }
    
    public void buyBond20Save() {

        int totalBuyAmount = (getSavingBalance() / bondBuyPrice);;
        
        System.out.println(("Your Savings Account balance is $") + getSavingBalance());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 20 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             savingBalance = savingBalance - totalBuyAmount;
             amountOfBondsTwenty = amountOfBondsTwenty + amount ;
             printSavingBalance();
             printAmountOfBondTwenty();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }
    
    public void buyBond20Cash() {

        int totalBuyAmount = (getCash() / bondBuyPrice);;
        
        System.out.println(("Your Cash balance is $") + getCash());
        System.out.println(("Maximum number of Bonds purchasable is ") + totalBuyAmount);
        System.out.println("Please enter the amount of 20 Year bonds you would like to purchase.");
        
        int amount = keyboard.nextInt();

        if (amount <= 0) {    //Makes sure the user does not input an amount less than 0
            System.out.println("Error. Invalid amount. Bond amount cannot be 0 or less. \n");
            
        } else if (amount > totalBuyAmount) { //Makes sure the user does not input an amount greater than total available money
            System.out.println("Error. Invalid amount. Insufficient funds to purchase that amount. \n");
            System.out.println("Maximum number of Bonds purchasable is \n");
            
        } else if (amount > 0 && amount <= totalBuyAmount) {  //Set the total price for requested number of Bonds.
            totalBuyAmount = amount * bondBuyPrice;

        System.out.println(("Your total purchase price is $") + totalBuyAmount);
        System.out.println("Enter 1: To purchase. \n Enter 2: To Exit");
        int userResponse = keyboard.nextInt();
         
        switch (userResponse) {
            case 1: {
             cashOnHand = cashOnHand - totalBuyAmount;
             amountOfBondsTwenty = amountOfBondsTwenty + amount ;
             printCash();
             printAmountOfBondTwenty();
                break;
            }
             
            case 2: {
                return;
            }
            default: {
                System.out.println("Error. Invalid Option.");
            }
        }
        }
    }

    public void sellBond() {

        Account useAccount = new Account();

        int totalBondsOwned = amountOfBondsFive + amountOfBondsTen + amountOfBondsTwenty;
        System.out.println("Welcome to the Sell Bond Menu.");
        System.out.println(("Your Account shows you own  \n") + totalBondsOwned);        
        System.out.println("bonds . \n");

        System.out.println(("You have  ") + amountOfBondsFive + ("\t 5 Year Bonds. \n"));
        System.out.println(("You have  ") + amountOfBondsTen + ("\t 10 Year Bonds. \n"));
        System.out.println(("You have  ") + amountOfBondsTwenty + ("\t 20 Year Bonds. \n"));
        System.out.println("Selling a Bond pays you the face value of the bond and interest on the years of the Bond. \n");

        System.out.println("Enter 1: To sell 5 Year Bonds.");
        System.out.println("Enter 2: To sell 10 Year Bonds.");
        System.out.println("Enter 3: To sell 20 Year Bonds.");
        System.out.println("Enter 4: To Exit.");

        int bondOption = keyboard.nextInt();

        switch (bondOption) {

            case 1: {
                System.out.println(("You have ") + amountOfBondsFive + (" 5 Year Bonds"));
                System.out.println("Please enter amount of bonds you wish to sell.");
                int sellAmount = keyboard.nextInt();

                if (sellAmount < 0) {

                    System.out.println("Error. Invalid amount. \n");
                    break;
                } else if (sellAmount > amountOfBondsFive) {
                    System.out.println("Error. Invalid amount. Sell amount cannot be greater than amount owned \n");
                    break;
                } else if (sellAmount > 0 && sellAmount <= amountOfBondsFive) {
                    int cashGain = ((bondBuyPrice * sellAmount) + (sellAmount * sellRate * 5));
                    amountOfBondsFive = amountOfBondsFive - sellAmount;
                    checkingBalance = checkingBalance + cashGain;

                    System.out.println((("Amount sold ") + sellAmount) + "\n");
                    System.out.println((("For $ ") + cashGain) + "\n");
                    System.out.println("Funds sent automatically to Checking Account");
                    printCheckingBalance();
                    printAmountOfBondFive();
                    break;
                }
            }
            case 2: {
                System.out.println(("You have  ") + amountOfBondsTen + (" 10 Year Bonds"));
                System.out.println("Please enter amount of bonds you wish to sell.");
                int sellAmount = keyboard.nextInt();

                if (sellAmount < 0) {

                    System.out.println("Error. Invalid amount. \n");
                    break;
                } else if (sellAmount > amountOfBondsTen) {
                    System.out.println("Error. Invalid amount. Sell amount cannot be greater than amount owned \n");
                    break;
                } else if (sellAmount > 0 && sellAmount <= amountOfBondsTen) {
                    int cashGain = ((bondBuyPrice * sellAmount) + (sellAmount * sellRate * 10));
                    amountOfBondsTen = amountOfBondsTen - sellAmount;
                    checkingBalance = checkingBalance + cashGain;

                    System.out.println((("Amount sold ") + sellAmount) + "\n");
                    System.out.println((("For $ ") + cashGain) + "\n");
                    System.out.println("Funds sent automatically to Checking Account");
                    printCheckingBalance();
                    printAmountOfBondTen();
                    break;

                }
            }
            case 3: {
                System.out.println(("You have  ") + amountOfBondsTen + (" 10 Year Bonds"));
                System.out.println("Please enter amount of bonds you wish to sell.");
                int sellAmount = keyboard.nextInt();

                if (sellAmount < 0) {

                    System.out.println("Error. Invalid amount. \n");
                    break;
                } else if (sellAmount > amountOfBondsTen) {
                    System.out.println("Error. Invalid amount. Sell amount cannot be greater than amount owned \n");
                    break;
                } else if (sellAmount > 0 && sellAmount <= amountOfBondsTen) {
                    int cashGain = ((bondBuyPrice * sellAmount) + (sellAmount * sellRate * 10));
                    amountOfBondsTen = amountOfBondsTen - sellAmount;
                    checkingBalance = checkingBalance + cashGain;

                    System.out.println((("Amount sold ") + sellAmount) + "\n");
                    System.out.println((("For $ ") + cashGain) + "\n");
                    System.out.println("Funds sent automatically to Checking Account");
                    printCheckingBalance();
                    printAmountOfBondTen();
                    break;

                }
            }
            case 4: {
              return;  
            }
            default:{
                System.out.println("Error. Invalid Option.");
            }
        }
    }
}
    