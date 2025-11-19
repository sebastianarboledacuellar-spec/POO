class Boton {

    protected boolean presionado;
    
    // Marca el botón como presionado 
    public void presionar() {
        presionado = true;
    }

    // Desactiva el botón 
    public void reset() {
        presionado = false;
    }

    public boolean isPresionado() {
        return presionado;
    }

}