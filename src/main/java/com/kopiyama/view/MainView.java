package com.kopiyama.view;

import com.kopiyama.model.BookForLoan;
import com.kopiyama.service.impl.DataAllBookServiceImpl;
import com.kopiyama.service.impl.LoanServiceImpl;
import com.kopiyama.view.print.PrintDisplay;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainView {
    private DataAllBookServiceImpl dataAllBookService;
    private LoanServiceImpl loanService;
    private PrintDisplay printDisplay;

    public MainView(DataAllBookServiceImpl dataAllBookService, LoanServiceImpl loanService) {
        this.dataAllBookService = dataAllBookService;
        this.loanService = loanService;
        this.printDisplay = new PrintDisplay();
    }

    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1; // Inisialisasi awal choice dengan nilai diluar pilihan menu

        do {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Aplikasi Rental Buku Cucux");
            System.out.println("1. Data All Book For Loan");
            System.out.println("2. Loan");
            System.out.println("3. Return");
            System.out.println("4. Data All Loan Book Order");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Membuang karakter newline dari buffer
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Membuang karakter yang tidak valid
                continue; // Lanjutkan ke iterasi berikutnya
            }

            switch (choice) {
                case 1:
                    System.out.println("Data All Loan Books");
                    List<BookForLoan> dataAllBooks = dataAllBookService.findAllLoanBook();
                    printDisplay.printAllLoanBooks(dataAllBooks);

                    // Menampilkan pilihan "Kembali ke Main Menu"
                    choice = printDisplay.printReturnToMainMenu();
                    break;
                case 2:
                    System.out.println("Loan Menu");
                    // Tambahkan logika untuk fitur Loan di sini
                    break;
                case 3:
                    System.out.println("Return Menu");
                    // Tambahkan logika untuk fitur Return di sini
                    break;
                case 4:
                    System.out.println("Data All Loan Book Order Menu");
                    // Tambahkan logika untuk fitur Data All Loan Book Order di sini
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close(); // Menutup scanner setelah penggunaan selesai
    }
}
