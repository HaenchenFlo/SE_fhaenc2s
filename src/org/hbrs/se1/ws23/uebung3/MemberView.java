package org.hbrs.se1.ws23.uebung3;

import java.util.Iterator;
import java.util.List;

public class MemberView {

    //Methode zur Ausgabe aller IDs der Member-Objekte.

    public static void dump(List<Member> liste) {
        System.out.println("Ausgabe aller Member-Objekte: ");
        for (Member i : liste) {
            System.out.println("ID: " + i.getID());
        }
    }
}