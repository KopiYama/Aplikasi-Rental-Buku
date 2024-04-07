package com.kopiyama.service.impl;

import com.kopiyama.model.BookForLoan;
import com.kopiyama.repository.RepositoryLoanBook;
import com.kopiyama.service.DataAllBookService;
import com.kopiyama.service.LoanService;

import java.util.List;
import java.util.Scanner;

public class LoanServiceImpl implements LoanService {
    private RepositoryLoanBook repositoryLoanBook;
    private DataAllBookService dataAllBookService;

    public LoanServiceImpl(RepositoryLoanBook repositoryLoanBook, DataAllBookService dataAllBookService) {
        this.repositoryLoanBook = repositoryLoanBook;
        this.dataAllBookService = dataAllBookService;
    }

    @Override
    public void loanBook() {
        Scanner scanner = new Scanner(System.in);

        // Menampilkan daftar buku yang tersedia untuk dipinjam
        List<BookForLoan> availableBooks = dataAllBookService.findAllLoanBook();
        System.out.println("Daftar Buku Yang Tersedia:");
        for (BookForLoan book : availableBooks) {
            System.out.println(book);
        }

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
