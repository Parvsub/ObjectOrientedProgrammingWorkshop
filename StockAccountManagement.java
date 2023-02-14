package com.objectOreientedProgrammes;

import java.util.ArrayList;
import java.util.Scanner;


public class StockAccountManagement {

    public static void main(String[] args) {
        int flag = 0;
        Scanner scanner = new Scanner(System.in);
        StockPortfo portfolio = new StockPortfo();
        while (flag == 0) {
            System.out.println("Enter the details of Stock ");
            StockPortfo.Stock shareDetails = new StockPortfo.Stock();
            System.out.println("Enter Company Name:");
            shareDetails.company = scanner.nextLine();
            System.out.println("Enter number of share:");
            shareDetails.NoOfShare = scanner.nextInt();
            System.out.println("Enter Price of share:");
            shareDetails.price = scanner.nextDouble();

            portfolio.portf.add(shareDetails);
            System.out.println("Do you want to add more Stocks? enter 0 for YES or 1 for NO!");
            flag = scanner.nextInt();
        }
        for (int i = 0; i < portfolio.portf.size(); i++) {
            System.out.println(portfolio.totalValue());

        }
    }
}

class StockPortfo {
    ArrayList<Stock> portf = new ArrayList<>();
    double totalValue = 0;

    static class Stock {
        int NoOfShare;
        String company;
        double price;
    }

    public double totalValue() {
        for (Stock stock : portf) {
            totalValue += stock.price * stock.NoOfShare;
        }
        return totalValue;
    }
}