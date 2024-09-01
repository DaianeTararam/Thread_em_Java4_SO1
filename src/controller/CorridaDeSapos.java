package controller;

import java.util.Random;

public class CorridaDeSapos implements Runnable {

	private String sapo;
	private Corrida corrida;
	private int distanciaMax = 100;
	private static final Random random = new Random();
	private int saltoMax = 10;
	private int distanciaPercorrida= 0 ;
	
	public CorridaDeSapos(Corrida corrida, String sapo) {
		this.corrida = corrida;
		this.sapo = sapo;
	}
	
	@Override
	public void run() {
		while (!corrida.oFinal() && distanciaPercorrida < distanciaMax) {
            int salto = random.nextInt(saltoMax + 1);
            distanciaPercorrida += salto;
            if (distanciaPercorrida > distanciaMax) {
                distanciaPercorrida = distanciaMax;
            }
            
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		if (distanciaPercorrida >= distanciaMax) {
            synchronized (corrida) {
                if (!corrida.isVencedorDeclarado()) {
                    corrida.setFinal(true);
                    corrida.setVencedor(true);
                    System.out.println("Sapo vencedor: " + sapo);
                }
            }
		}
	}
}