package org.hbrs.se1.ws23.uebung2;
import java.util.ArrayList;
public class Container {
    ArrayList<Member> Memberlist = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        for (Member e : Memberlist) {
            if (e.getID() == member.getID()) {
                throw new ContainerException("Das Member-Objekt mit der ID " + member.getID() + " ist bereits vorhanden");
            }
        }
        Memberlist.add(member);
    }

    public String deleteMember(Integer id) {
        for (int i = 0; i < Memberlist.size(); i++) {
            if (Memberlist.get(i).getID() == id) {
                return "";
            }
        }
        return "FEHLER!!! Member mit der ID nicht gefunden";
    }

    public void dump() {
        for (Member e : Memberlist) {
            System.out.println(e.toString());
        }
    }

    public int size(){
        return Memberlist.size();
    }

}
