package com.bridgelabz.uc1_stock_account;

import java.util.ArrayList;
import java.util.Scanner;

class Stock {
    int numOfStocks;
    double stockPrice;
    int numOfShares;
    ArrayList<String> stockNames;

    /**
     * Stock constructor used for initializing arraylist
     */
    public Stock() {
        stockNames = new ArrayList<>();
    }

    /**
     * Adding stock names to the arraylist
     */
    public void setStockNames() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Enter number of stocks : ");
        numOfStocks = sc.nextInt();
        while (i < numOfStocks) {
            System.out.println("Choose option from below \n1.To add Stock Name \n2.Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 1) {
                System.out.println("Enter the stock name to add : ");
                String setName = sc.nextLine();
                stockNames.add(setName);
                i++;
            } else {
                break;
            }
        }
        System.out.println(stockNames);
    }
}

/**
 * Stock portfolio class extends Stock class
 * arraylist used in Stock portfolio
 */
class StockPortfolio extends Stock {
    double totalValue;

    /**
     * This method is used to assign the values of stock price
     * and the number of shares user has
     */
    public void setStockPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter stock price:");
        stockPrice = sc.nextDouble();
        System.out.println("Enter number of Shares:");
        numOfShares = sc.nextInt();
    }

    /**
     * This method is used to calculate total value
     *
     * @return totalValue to method
     */
    public double stockCalculations() {
        this.totalValue = stockPrice * numOfShares;
        return totalValue;
    }

    /**
     * This method calculates the total value of the portfolio
     * Loop runs until number of stocks user has
     */
    public void stockPortFolio() {
        int j = 0;
        double portFolioValue = 0;
        Scanner sc = new Scanner(System.in);
        while (j < numOfStocks) {
            System.out.println("Enter the stock name");
            String choice = sc.nextLine();
            if (stockNames.contains(choice)) {
                setStockPrice();
                stockCalculations();
                System.out.println("Total value of " + choice + " share is : " + stockCalculations());
                portFolioValue += totalValue;
                j++;
            } else {
                System.out.println("Record not found");
            }
        }
        System.out.println("Total Portfolio Value is : " + portFolioValue);
    }
}

public class StockAccount {
    /**
     * object of StockPortfolio is created
     * stock names method and stock portfolio method are called using object
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StockPortfolio stockObj = new StockPortfolio();
        stockObj.setStockNames();
        stockObj.stockPortFolio();
    }
}
