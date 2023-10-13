package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.TranslatorFactory;
import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;

public class Client {

	/*
	 * Methode zur Ausgabe einer Zahl auf der Console
	 * (auch bezeichnet als CLI, Terminal)
	 *
	 */
	void display( int aNumber ){
		GermanTranslator translator = TranslatorFactory.createGermanTranslator();
		String res  = translator.translateNumber(aNumber);

		// In dieser Methode soll die Methode translateNumber
		// mit dem übergegebenen Wert der Variable aNumber
		// aufgerufen werden.
		//
		// Strenge Implementierung gegen das Interface Translator gewuenscht!

		System.out.println("Das Ergebnis der Berechnung: " + res);

	}

}




