package bolt;

import java.text.ParseException;

import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;

public class TesterMain {
	public static void main(String[] args) throws NemLetezoAruKivetel, TulSokLevonasKivetel, ParseException {
		Tester tester = new Tester();
		tester.addAru();
		// tester.vaneAru();
		// tester.printAll();
		// tester.torolAru((long) 23456);
		// tester.vasarol((long) 23456, 1);
		// tester.feltoltArut((long) 23456, 3);
		// tester.printAll();
	}
}
