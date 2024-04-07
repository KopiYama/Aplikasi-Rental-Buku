package com.kopiyama.service.impl;

import com.kopiyama.model.BookForLoan;
import com.kopiyama.model.LoanBookOrder;
import com.kopiyama.repository.RepositoryLoanBook;
import com.kopiyama.repository.RepositoryLoanBookOrder;
import com.kopiyama.service.ReturnService;
import com.kopiyama.view.print.PrintDisplay;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ReturnServiceImpl implements ReturnService {
    private RepositoryLoanBookOrder repositoryLoanBookOrder;
    private RepositoryLoanBook repositoryLoanBook;
    private PrintDisplay printDisplay;

    public ReturnServiceImpl(RepositoryLoanBookOrder repositoryLoanBookOrder, RepositoryLoanBook repositoryLoanBook, PrintDisplay printDisplay) {
        this.repositoryLoanBookOrder = repositoryLoanBookOrder;
        this.repositoryLoanBook = repositoryLoanBook;
        this.printDisplay = printDisplay;
    }

    @Override
    public void returnBook() {
        Scanner scanner = new Scanner(System.in);

        List<LoanBookOrder> loanBookOrders = repositoryLoanBookOrder.getAllLoanBookOrders();
        if (loanBookOrders.isEmpty()) {
            System.out.println("No books currently on loan.");
            return;
        } else {
            printDisplay.printAllLoanBookOrders(loanBookOrders);

            System.out.print("\nMasukan Loan Id: ");
            String loanId = scanner.nextLine();

            boolean found = false;
            Iterator<LoanBookOrder> iterator = loanBookOrders.iterator();
            while (iterator.hasNext()) {
                LoanBookOrder order = iterator.next();
                if (order.getLoanID().equals(loanId)) {
                    BookForLoan book = order.getLoanBook();
                    book.setStok(book.getStok() + 1); // Mengembalikan stok buku
                    iterator.remove(); // Menghapus peminjaman dari daftar
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("\nReturn Book Success!");
            } else {
                System.out.println("\nLoan ID not found. Return Failed!");
            }
        }
    }
}
