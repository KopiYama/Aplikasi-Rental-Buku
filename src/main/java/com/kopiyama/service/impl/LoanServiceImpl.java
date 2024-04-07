package com.kopiyama.service.impl;

import com.kopiyama.model.BookForLoan;
import com.kopiyama.service.DataAllBookService;
import com.kopiyama.service.LoanService;
import com.kopiyama.view.print.PrintDisplay;

import java.util.List;
import java.util.Scanner;

public class LoanServiceImpl implements LoanService {
    private PrintDisplay printDisplay;
    private DataAllBookService dataAllBookService;

    public LoanServiceImpl(PrintDisplay printDisplay, DataAllBookService dataAllBookService) {
        this.printDisplay = printDisplay;
        this.dataAllBookService = dataAllBookService;
    }

    @Override
    public void loanBook() {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan daftar buku yang tersedia untuk dipinjam
        List<BookForLoan> availableBooks = dataAllBookService.findAllLoanBook();
        printDisplay.printAllLoanBooks(availableBooks);

        // Input Member ID
        System.out.print("\nMasukan Member Id: ");
        String memberId = scanner.nextLine();

        // Input Book ID
        System.out.print("Masukan Book Id: ");
        String bookId = scanner.nextLine();

        // Input Lama Peminjaman
        System.out.print("Lama Peminjaman: ");
        int loanDuration = scanner.nextInt();

        // Mencari buku yang sesuai dengan Book ID yang diinput
        BookForLoan selectedBook = null;
        for (BookForLoan book : availableBooks) {
            if (book.getBookID().equals(bookId)) {
                selectedBook = book;
                break;
            }
        }

        if (selectedBook != null && selectedBook.getStok() > 0) {
            // Mengurangi stok buku yang dipinjam
            selectedBook.setStok(selectedBook.getStok() - 1);

            // Menampilkan konfirmasi peminjaman sukses
            System.out.println("\nLoan Success!");
        } else {
            // Menampilkan pesan jika buku tidak ditemukan atau stok habis
            System.out.println("\nBuku tidak ditemukan atau stok habis. Loan Failed!");
        }
    }
}
