package com.kopiyama.service.impl;

import com.kopiyama.model.BookForLoan;
import com.kopiyama.model.LoanBookOrder;
import com.kopiyama.model.Member;
import com.kopiyama.repository.RepositoryLoanBookOrder;
import com.kopiyama.repository.RepositoryLoanBook;
import com.kopiyama.service.DataAllBookService;
import com.kopiyama.service.LoanService;
import com.kopiyama.view.print.PrintDisplay;

import java.util.List;
import java.util.Scanner;

public class LoanServiceImpl implements LoanService {
    private static int loanIdCounter = 1;
    private PrintDisplay printDisplay;
    private DataAllBookService dataAllBookService;
    private RepositoryLoanBookOrder repositoryLoanBookOrder;
    private RepositoryLoanBook repositoryLoanBook;

    public LoanServiceImpl(PrintDisplay printDisplay, DataAllBookService dataAllBookService, RepositoryLoanBookOrder repositoryLoanBookOrder, RepositoryLoanBook repositoryLoanBook) {
        this.printDisplay = printDisplay;
        this.dataAllBookService = dataAllBookService;
        this.repositoryLoanBookOrder = repositoryLoanBookOrder;
        this.repositoryLoanBook = repositoryLoanBook;
    }

    @Override
    public void loanBook() {
        Scanner scanner = new Scanner(System.in);

        List<BookForLoan> availableBooks = dataAllBookService.findAllLoanBook();
        printDisplay.printAllLoanBooks(availableBooks);

        System.out.print("\nMasukan Member Id   : ");
        String memberId = scanner.nextLine();

        Member member = repositoryLoanBookOrder.findMemberById(memberId);
        if (member == null) {
            System.out.println("\nMember not found. Loan Failed!");
            return;
        }

        System.out.print("Masukan Book Id     : ");
        String bookId = scanner.nextLine();

        System.out.print("Lama Peminjaman     : ");
        int loanDuration = scanner.nextInt();

        BookForLoan selectedBook = null;
        for (BookForLoan book : availableBooks) {
            if (book.getBookID().equals(bookId)) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook != null && selectedBook.getStok() > 0) {
            double bookLoanPrice = selectedBook.calculateBookLoanPrice(); // Buat hitung harga pinjam buku
            selectedBook.setStok(selectedBook.getStok() - 1); // Buat kurangi stok buku

            String loanId = String.format("Ord-%03d", loanIdCounter++);
            LoanBookOrder loanBookOrder = new LoanBookOrder(
                    loanId,
                    selectedBook.getBookID(),
                    member,
                    selectedBook,
                    loanDuration,
                    bookLoanPrice * loanDuration, // Loan price nya langsung ke simpan di objek nya masing"
                    bookLoanPrice // Simpan Loan Book Price di objek LoanBookOrder
            );

            repositoryLoanBookOrder.addLoanBookOrder(loanBookOrder);
            System.out.println("\nLoan Success!");
        } else {
            System.out.println("\nBuku tidak ditemukan atau stok habis. Loan Failed!");
        }

    }
}
