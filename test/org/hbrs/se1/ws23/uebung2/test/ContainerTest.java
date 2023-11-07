package org.hbrs.se1.ws23.uebung2.test;

import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.Container;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    Member member1;
    Member member2;
    Container container;

    @BeforeEach
    void objekteErstellen() {
        member1 = new ConcreteMember(1);
        member2 = new ConcreteMember(2);
        container = new Container();
    }
    @Test
    void testeAdd() throws ContainerException {
        container.addMember(member1);
        assertEquals(1,container.size());
        container.addMember(member2);
        assertEquals(2, container.size());
    }
    @Test
    void testeDelete() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        assertEquals("",container.deleteMember(1));
        assertEquals("",container.deleteMember(2));
    }
    @Test
    void testeDump() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        container.dump();
    }
    @Test
    void testeSize() throws ContainerException {
        assertEquals(0,container.size());
        container.addMember(member1);
        assertEquals(1,container.size());
        container.addMember(member2);
        assertEquals(2,container.size());
        container.deleteMember(1);
        assertEquals(2,container.size());
        assertThrows(ContainerException.class, () -> container.addMember(member2));
        assertEquals(2,container.size());
        container.deleteMember(1);
        assertEquals(2,container.size());
    }
    @Test
    void negativeTests() throws ContainerException {
        container.addMember(member1);
        container.addMember(member2);
        assertThrows(ContainerException.class, () -> container.addMember(member1));
        assertThrows(ContainerException.class, () -> container.addMember(member2));
        container.deleteMember(1);
        container.deleteMember(2);
        assertEquals("FEHLER!!! Member mit der ID nicht gefunden", container.deleteMember(1));
        assertEquals("FEHLER!!! Member mit der ID nicht gefunden", container.deleteMember(2));
    }
}
