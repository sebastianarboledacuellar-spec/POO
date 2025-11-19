class Piso { 

    private int numero; 
    private BotonPiso subir; 
    private BotonPiso bajar; 

 
    // dependiendo del piso el ascensor subira o bajara
    public Piso(int numero, int totalPisos) { 
        this.numero = numero; 
        if (numero < totalPisos) 
            subir = new BotonPiso(numero, "subir"); 
        if (numero > 1) 
            bajar = new BotonPiso(numero, "bajar"); 
    } 

    public int getNumero() { 
        return numero; 
    } 

    public BotonPiso getSubir() {
        return subir;
    }

    public BotonPiso getBajar() {
        return bajar;
    }

    public boolean hasSubir() {
        return subir != null;
    }

    public boolean hasBajar() {
        return bajar != null;
    }

    public void presionarSubir() {
        if (subir != null) subir.presionar();
    }

    public void presionarBajar() {
        if (bajar != null) bajar.presionar();
    }

    @Override
    public String toString() {
        return String.format("Piso %d [subir=%s, bajar=%s]", numero, (hasSubir()?"OK":"-"), (hasBajar()?"OK":"-"));
    }

} 