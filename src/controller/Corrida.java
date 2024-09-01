package controller;

public class Corrida{
	private volatile boolean finalCorrida;
	private boolean vencedor = false;
	
	public synchronized boolean oFinal() {
        return finalCorrida;
    }

    public synchronized void setFinal(boolean finalCorrida) {
        this.finalCorrida = finalCorrida;
    }
    
    public synchronized boolean isVencedorDeclarado() {
        return vencedor;
    }
    
    public synchronized void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }
}
