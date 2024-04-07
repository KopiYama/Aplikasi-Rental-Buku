package com.kopiyama;

import com.kopiyama.repository.RepositoryLoanBook;
import com.kopiyama.repository.RepositoryLoanBookOrder;
import com.kopiyama.service.impl.DataAllBookServiceImpl;
import com.kopiyama.service.impl.LoanServiceImpl;
import com.kopiyama.service.impl.ReturnServiceImpl;
import com.kopiyama.view.MainView;
import com.kopiyama.view.print.PrintDisplay;

public class MainApp {
    public static void main(String[] args) {
        RepositoryLoanBook repositoryLoanBook = new RepositoryLoanBook();
        RepositoryLoanBookOrder repositoryLoanBookOrder = new RepositoryLoanBookOrder();
        DataAllBookServiceImpl dataAllBookService = new DataAllBookServiceImpl(repositoryLoanBook);
        PrintDisplay printDisplay = new PrintDisplay();
        LoanServiceImpl loanService = new LoanServiceImpl(printDisplay, dataAllBookService, repositoryLoanBookOrder, repositoryLoanBook);
        ReturnServiceImpl returnService = new ReturnServiceImpl(repositoryLoanBookOrder, repositoryLoanBook, printDisplay);
        MainView mainView = new MainView(dataAllBookService, loanService, returnService);

        mainView.showMainMenu();
    }
}
