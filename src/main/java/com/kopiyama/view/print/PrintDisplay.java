package com.kopiyama.view.print;

import com.kopiyama.model.BookForLoan;

import java.util.List;

public class PrintDisplay {
    public void printAllLoanBooks(List<BookForLoan> dataAllBooks) {
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+");
        System.out.println("|   Book Id  |                                Title                                   |             Author             |    Stok    |");
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+");
        for (BookForLoan loanBook : dataAllBooks) {
            System.out.printf("| %-10s | %-70s | %-30s | %-10s |\n", loanBook.getBookID(), loanBook.getTitle(), loanBook.getAuthor().getName(), loanBook.getStok());
        }
        System.out.println("+------------+------------------------------------------------------------------------+--------------------------------+------------+");
    }
}
