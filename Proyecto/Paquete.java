import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paquete {
    private int id;
    private String destinatario;
    private LocalDate fechaIngreso;
    private String descripcion;
    private String tamaño; // PEQUEÑO, MEDIANO, GRANDE
    
    // Constructor
    public Paquete(int id, String destinatario, String descripcion, String tamaño) {
        this.id = id;
        this.destinatario = destinatario;
        this.fechaIngreso = LocalDate.now();
        this.descripcion = descripcion;
        this.tamaño = tamaño.toUpperCase();
    }
    
    // Getters y Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDestinatario() {
        return destinatario;
    }
    
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getTamaño() {
        return tamaño;
    }
    
    public void setTamaño(String tamaño) {
        this.tamaño = tamaño.toUpperCase();
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Paquete [ID=" + id + ", Destinatario=" + destinatario + 
               ", Fecha Ingreso=" + fechaIngreso.format(formatter) + 
               ", Descripción=" + descripcion + ", Tamaño=" + tamaño + "]";
    }
}
