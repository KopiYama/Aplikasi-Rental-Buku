package com.kopiyama;

import com.kopiyama.model.BookForLoan;
import com.kopiyama.repository.RepositoryLoanBook;
import com.kopiyama.service.DataAllBookService;
import com.kopiyama.service.LoanService;
import com.kopiyama.service.impl.DataAllBookServiceImpl;
import com.kopiyama.service.impl.LoanServiceImpl;
import com.kopiyama.view.MainView;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        RepositoryLoanBook repository = new RepositoryLoanBook();
        DataAllBookServiceImpl dataAllBookService = new DataAllBookServiceImpl(repository);
        LoanServiceImpl loanService = new LoanServiceImpl(repository, dataAllBookService);
        MainView mainView = new MainView(dataAllBookService, loanService);

//        List<BookForLoan> availableBooks = dataAllBookService.findAllLoanBook();
//
//        for (BookForLoan book : availableBooks) {
//            System.out.println(book);
//        }

//        loanService.loanBook();

        mainView.showMainMenu();

    }
}
