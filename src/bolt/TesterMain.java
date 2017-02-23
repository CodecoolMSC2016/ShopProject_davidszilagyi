package bolt;

import bolt.kivetel.NemLetezoAruKivetel;
import bolt.kivetel.TulSokLevonasKivetel;

public class TesterMain {
	public static void main(String[] args) throws NemLetezoAruKivetel, TulSokLevonasKivetel {
		Tester tester = new Tester();
		tester.addAru();
		tester.vaneAru();
		tester.printAll();
		// tester.torolAru(23456);
		tester.vasarol(23456, 1000);
		tester.feltoltArut(23456, 3);
		tester.printAll();
	}
}
