package org.hbrs.se1.ws23.uebung2;

public class ContainerException extends Exception {
    public ContainerException() {
        super("Die Member-Id ist bereits vorahnden!");
    }
    public ContainerException(String fehlermeldung) {
        super(fehlermeldung);
    }

}
