class BotonPiso extends Boton { 

    //boton de cada piso para llamar al ascensor
    private int piso; 
    private String direccion; 

    public BotonPiso(int piso, String direccion) { 
        this.piso = piso; 
        this.direccion = direccion; 
    } 

    public int getPiso() { 
        return piso; 
    } 

    public String getDireccion() { 
        return direccion; 
    } 

} 