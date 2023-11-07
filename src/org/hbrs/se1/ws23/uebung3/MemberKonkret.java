package org.hbrs.se1.ws23.uebung3;


import java.io.Serializable;

public class MemberKonkret implements Member, Serializable {

    private Integer id = null;

    public MemberKonkret(Integer id ){
        this.id = id;
    }

    @Override
    public Integer getID() {
        return this.id;
    }

    public void setID ( Integer id ) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberKonkret [id=" + id + "]";
    }
}