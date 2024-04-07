package com.kopiyama;

import com.kopiyama.model.*;

public class Main {
    public static void main(String[] args) {
        Novelis novelis1 = new Novelis("Mochamad Rizky Andika");
        Mangaka mangaka1 = new Mangaka("Bella Monyet");
        Member member1 = new Member("M-001", "Rizky Andika", "Bandung");

        Comic comic1 = new Comic("Comic-001", "Naruto", mangaka1, 10000.0, 0.0, 9, "Shounen");

        Novel novel1 = new Novel("Novel-001", "Madree", novelis1, 10000.0, 0.0, 19, true);

        LoanBookOrder loanBookOrder1 = new LoanBookOrder("L-001", member1 , comic1, 3);


        System.out.println(novelis1);
        System.out.println(mangaka1);
        System.out.println(member1);
        System.out.println(comic1);
        System.out.println(novel1);
        System.out.println(loanBookOrder1);

    }
}