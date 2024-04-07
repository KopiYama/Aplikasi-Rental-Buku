package com.kopiyama.view.print;

import com.kopiyama.model.BookForLoan;

import java.util.List;
import java.util.Scanner;

public class PrintDisplay {
    public void printAllLoanBooks(List<BookForLoan> dataAllBooks) {
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+");
        System.out.println("|   Book Id  |                                Title                                   |             Author             |    Stok    |");
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+");
        for (BookForLoan loanBook : dataAllBooks) {
            System.out.printf("| %-10s | %-70s | %-30s | %-10s |\n", loanBook.getBookID(), loanBook.getTitle(), loanBook.getAuthor().getName(), loanBook.getStok());
        }
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+\n");
    }

    public int printReturnToMainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("0. Kembali ke Main Menu");
        System.out.print("Pilih menu: ");
        int choice = scanner.nextInt();

        return choice;
    }
}
