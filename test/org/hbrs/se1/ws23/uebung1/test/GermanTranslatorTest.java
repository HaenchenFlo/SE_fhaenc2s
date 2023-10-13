package org.hbrs.se1.ws23.uebung1.test;

import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GermanTranslatorTest {

    @Test
    void aPositiveTest() {
        GermanTranslator translator = new GermanTranslator();

        String[] zahlen = {"eins", "zwei", "drei", "vier", "fünf", "sechs", "sieben", "acht", "neun", "zehn"};
        for (int i = 1; i <= 10; i++) {
            String value = translator.translateNumber(i);
            assertEquals(value,zahlen[i-1]);
            System.out.println("" + i + " ist gleich " + value);
        }
    }

    @Test
    void aNegativeTest() {
        GermanTranslator translator = new GermanTranslator();
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(15));
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(2));
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(-3));
        assertThrows(IllegalArgumentException.class, () -> translator.translateNumber(-5));
    }
}