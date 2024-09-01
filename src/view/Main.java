package view;

import controller.CorridaDeSapos;
import controller.Corrida;

public class Main {

	public static void main(String[] args) {
			Corrida corrida = new Corrida();
			for (int i = 1; i <= 5; i++) {
	            CorridaDeSapos sapo = new CorridaDeSapos(corrida, "Sapo " + i);
	            new Thread(sapo).start();
			}
	}
}
