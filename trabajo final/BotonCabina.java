class BotonCabina extends Boton { 

    private int destino; 

    // Constructor del botón de la cabina con el piso de destino
    public BotonCabina(int destino) { 
        this.destino = destino; 
    } 

    public int getDestino() { 
        return destino; 
    } 

} 