package org.hbrs.se1.ws23.uebung3.test;
import org.hbrs.se1.ws23.uebung3.Container;
import org.hbrs.se1.ws23.uebung3.ContainerException;
import org.hbrs.se1.ws23.uebung3.Member;
import org.hbrs.se1.ws23.uebung3.MemberKonkret;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceException;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategy;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyMongoDB;
import org.hbrs.se1.ws23.uebung3.persistence.PersistenceStrategyStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContainerTest {
    Container c = Container.createContainer();

    @BeforeEach
    void leereContainer() {
        c.deleteAll();
        c.strategy = null;
    }

    @Test
    void testNoStrategy() throws ContainerException {
        Member member1 = new MemberKonkret(1);
        c.addMember(member1);
        assertNull(c.strategy);
        assertThrows(PersistenceException.class, () -> c.store());
        try {
            c.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.NoStrategyIsSet, e.getExceptionTypeType());
        }
    }
    @Test
    void testePersistenceStrategyMongoDB() throws ContainerException {
        Member member1 = new MemberKonkret(1);
        c.addMember(member1);
        c.strategy = new PersistenceStrategyMongoDB<Member>();
        assertThrows(UnsupportedOperationException.class, () -> c.strategy.openConnection());
        assertThrows(UnsupportedOperationException.class, () -> c.store());
        assertThrows(UnsupportedOperationException.class, () -> c.load());
        assertThrows(UnsupportedOperationException.class, () -> c.strategy.closeConnection());
    }
    @Test
    void testeDirectories() throws PersistenceException{
        PersistenceStrategyStream<Member> strategy = new PersistenceStrategyStream<>();
        strategy.setLocation("/");
        c.strategy = strategy;
        try {
            c.strategy.openConnection();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getExceptionTypeType());
        }
        try {
            c.store();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.NoFileFound, e.getExceptionTypeType());
        }
        try {
            c.load();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.NoFileFound, e.getExceptionTypeType());
        }
        try {
            c.strategy.closeConnection();
        } catch (PersistenceException e) {
            assertEquals(PersistenceException.ExceptionType.ConnectionNotAvailable, e.getExceptionTypeType());
        }
    }

    @Test
    void roundTripTest() throws ContainerException, PersistenceException {
        PersistenceStrategy<Member> strategy = new PersistenceStrategyStream<>();
        ((PersistenceStrategyStream<Member>)strategy).setLocation("test/org/hbrs/se1/ws23/uebung3/test/testdata.ver");
        c.strategy = strategy;
        c.strategy.openConnection();

        //Container füllen
        MemberKonkret member1 = new MemberKonkret(1);
        MemberKonkret member2 = new MemberKonkret(2);
        c.addMember(member1);
        c.addMember(member2);
        c.store();
        c.deleteAll();
        assertEquals(0, c.size());
        c.load();
        assertEquals(2, c.size());
        c.strategy.closeConnection();
    }
}