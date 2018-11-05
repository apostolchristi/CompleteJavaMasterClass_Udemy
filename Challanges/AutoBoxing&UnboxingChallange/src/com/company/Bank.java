package com.company;
// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }


    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) { //if its returns null, that means that this name hasn't been used before
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String custumerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) { //we are checking to see first wether the branch exists and then
            return branch.newCustomer(custumerName, initialAmount); //we're leaving the check to see wether the customer can be added to the appropriate class
        }
        return false; // we are not able to store custumer
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
        Branch branch = findBranch(branchName); //check if branch exists first.
        if(branch != null) { //was able to be found and we can actually go ahead and call the code
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }

    private Branch findBranch (String customerName) {
        for(int i=0; i<this.branches.size(); i++) {
            Branch checkedBranch = this.branches.get(i);
            if(checkedBranch.getName().equals(customerName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    // is to list all the customers for a given branch and optionally all the transactions for each customer
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {//if not equal to null we found a match and we can process it
            System.out.println("Custumers details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers(); // we got the list of customers for the branch that we're looking for
            for(int i=0; i<branchCustomers.size(); i++) { // getting a list of all the customers for the particular branch
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");//showing the name of the customer, and if u recall, we said optionally show the transactions
                if(showTransactions) { //this code will execute if "showTransactions" is true
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j=0; j<transactions.size(); j++) {
                        System.out.println("[" +(j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
