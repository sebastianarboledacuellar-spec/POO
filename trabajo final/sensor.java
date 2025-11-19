class Sensor { 

    //Simula un sensor que detecta fallas aleatorias en el ascensor
    public boolean detectarFalla() { 
        return Math.random() < 0.05;   
    } 
} 