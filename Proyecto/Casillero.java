public class Casillero {
    private int numero;
    private String tamaño; // PEQUEÑO, MEDIANO, GRANDE
    private boolean ocupado;
    private Paquete paquete;
    
    // Constructor
    public Casillero(int numero, String tamaño) {
        this.numero = numero;
        this.tamaño = tamaño.toUpperCase();
        this.ocupado = false;
        this.paquete = null;
    }
    
    // Método para asignar paquete
    public boolean asignarPaquete(Paquete paquete) {
        if (!ocupado && paquete.getTamaño().equals(this.tamaño)) {
            this.paquete = paquete;
            this.ocupado = true;
            return true;
        }
        return false;
    }
    
    // Método para retirar paquete
    public Paquete retirarPaquete() {
        if (ocupado) {
            Paquete paqueteRetirado = this.paquete;
            this.paquete = null;
            this.ocupado = false;
            return paqueteRetirado;
        }
        return null;
    }
    
    // Getters y Setters
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getTamaño() {
        return tamaño;
    }
    
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño.toUpperCase();
    }
    
    public boolean isOcupado() {
        return ocupado;
    }
    
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public Paquete getPaquete() {
        return paquete;
    }
    
    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }
    
    @Override
    public String toString() {
        String estado = ocupado ? "OCUPADO" : "DISPONIBLE";
        return "Casillero " + numero + " (" + tamaño + ") - " + estado;
    }
}
