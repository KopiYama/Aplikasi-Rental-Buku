package com.kopiyama.view.print;

import com.kopiyama.Main;
import com.kopiyama.model.BookForLoan;
import jdk.dynalink.StandardNamespace;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PrintDisplay {
    public void printAllLoanBooks(List<BookForLoan> dataAllBooks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+");
        System.out.println("|   Book Id  |                                Title                                   |             Author             |    Stok    |");
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+");
        for (BookForLoan loanBook : dataAllBooks) {
            System.out.printf("| %-10s | %-70s | %-30s | %-10s |\n", loanBook.getBookID(), loanBook.getTitle(), loanBook.getAuthor().getName(), loanBook.getStok());
        }
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+\n");
    }

    public void loanMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Book ID: ");
        String bookId = scanner.nextLine();

        System.out.println("Enter Customer ID: ");
        String customerId = scanner.nextLine();

        // Implementasi logika untuk fitur Loan di sini
        System.out.println("Loan successful for Book ID: " + bookId + " to Customer ID: " + customerId);

        scanner.close();


    }

    public int printReturnToMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int choice = -1;

        while (isRunning) {
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter Your Choice: ");

            try {
                String input = scanner.nextLine();
                if (input.trim().isEmpty()) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
                choice = Integer.parseInt(input);
                break; // Keluar dari loop jika input valid
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid number.");
            }
        }

        return choice;
    }

//    public static void printReturnToMainMenu() {
//        Scanner scanner = new Scanner(System.in);
//        boolean isRunning = true;
//
//        while (isRunning) {
//            System.out.println("0. Back to Main Menu");
//            System.out.println("Enter Your Choice: ");
//
//            try {
//                String input =scanner.nextLine();
//                if (input.trim().isEmpty()) {
//                    System.out.println("Invalid choice. Please try again.");
//                    continue;
//                }
//                int choice = Integer.parseInt(input);
//
//                switch (choice) {
//                    case 0:
//
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("\nPilihan tidak valid. Silakan coba lagi.\n");
//            }
//        }
//    }



}
