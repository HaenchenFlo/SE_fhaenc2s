package org.hbrs.se1.ws23.uebung2;

public class ConcreteMember implements Member {
    private int id;

    public ConcreteMember(Integer id) {
        this.id = id;
    }
    public Integer getID(){
        return this.id;
    }
    public String toString() {
        return "Member (ID = " + id + ")";
    }

}
