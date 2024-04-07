package com.kopiyama.view.print;

import com.kopiyama.Main;
import com.kopiyama.model.BookForLoan;
import com.kopiyama.model.LoanBookOrder;
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
            System.out.printf("| %-10s | %-70s | %-30s | %-10s |\n",
                    loanBook.getBookID(),
                    loanBook.getTitle(),
                    loanBook.getAuthor().getName(),
                    loanBook.getStok());
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

    public void printAllLoanBookOrders(List<LoanBookOrder> loanBookOrders) {
        System.out.println("+------------+---------------+------------+----------------------------------------------+-----------------+---------------+----------+");
        System.out.println("|  Loan Id   | Member Name   |  Book Id   |                     Title                    | Loan Book Price | Loan Duration | Loan Fee |");
        System.out.println("+------------+---------------+------------+----------------------------------------------+-----------------+---------------+----------+");
        for (LoanBookOrder order : loanBookOrders) {
            System.out.printf("| %-10s | %-13s | %-10s | %-44s | %-15.2f | %-13d | %-8.2f |\n",
                    order.getLoanID(),
                    order.getMember().getName(),
                    order.getBookID(),
                    order.getLoanBook().getTitle(),
                    order.getLoanBookPrice(), // Gunakan Loan Book Price dari objek LoanBookOrder
                    order.getLoanDuration(),
                    order.getLoanFee());
        }
        System.out.println("+------------+---------------+------------+----------------------------------------------+-----------------+---------------+----------+\n");
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

}
