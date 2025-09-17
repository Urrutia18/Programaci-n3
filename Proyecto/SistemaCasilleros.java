import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class SistemaCasilleros {
    private Casillero[][] casilleros;
    private int contadorPaquetes;
    private Scanner scanner;
    
    public SistemaCasilleros() {
        // Inicializar matriz de casilleros 5x6 (30 casilleros total)
        casilleros = new Casillero[5][6];
        contadorPaquetes = 1;
        scanner = new Scanner(System.in);
        inicializarCasilleros();
    }
    
    private void inicializarCasilleros() {
        int numeroCasillero = 1;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                // Distribución de tamaños según la imagen del proyecto
                String tamaño;
                if (i < 2) {
                    tamaño = "PEQUEÑO";
                } else if (i < 4) {
                    tamaño = "MEDIANO";
                } else {
                    tamaño = "GRANDE";
                }
                
                casilleros[i][j] = new Casillero(numeroCasillero++, tamaño);
            }
        }
    }
    
    public void mostrarMenu() {
        int opcion;
        
        do {
            System.out.println("\n═══════════════════════════════════════");
            System.out.println("    SISTEMA DE CASILLEROS AMAZON    ");
            System.out.println("═══════════════════════════════════════");
            System.out.println("1. Registrar paquete en casillero");
            System.out.println("2. Consultar casilleros disponibles");
            System.out.println("3. Información de paquetes en casilleros");
            System.out.println("4. Cerrar aplicación");
            System.out.println("═══════════════════════════════════════");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch (opcion) {
                case 1:
                    registrarPaquete();
                    break;
                case 2:
                    consultarCasillerosDisponibles();
                    break;
                case 3:
                    mostrarInformacionPaquetes();
                    break;
                case 4:
                    System.out.println("Cerrando aplicación...");
                    System.out.println("¡Gracias por usar el Sistema de Casilleros Amazon!");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }
    
    private void registrarPaquete() {
        System.out.println("\n═══ REGISTRO DE PAQUETE ═══");
        
        // Mostrar esquema de casilleros disponibles
        mostrarEsquemaCasilleros();
        
        System.out.print("Ingrese el nombre del destinatario: ");
        String destinatario = scanner.nextLine();
        
        System.out.print("Ingrese la descripción del paquete: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Ingrese el tamaño del paquete (PEQUEÑO/MEDIANO/GRANDE): ");
        String tamaño = scanner.nextLine().toUpperCase();
        
        // Validar tamaño
        if (!tamaño.equals("PEQUEÑO") && !tamaño.equals("MEDIANO") && !tamaño.equals("GRANDE")) {
            System.out.println("❌ Tamaño inválido. Debe ser PEQUEÑO, MEDIANO o GRANDE.");
            return;
        }
        
        // Crear paquete
        Paquete nuevoPaquete = new Paquete(contadorPaquetes++, destinatario, descripcion, tamaño);
        
        // Intentar asignar casillero
        if (asignarCasillero(nuevoPaquete)) {
            System.out.println("✅ Paquete registrado exitosamente!");
            System.out.println(nuevoPaquete.toString());
        } else {
            System.out.println("❌ No hay casilleros disponibles para el tamaño " + tamaño);
        }
    }
    
    private boolean asignarCasillero(Paquete paquete) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (casilleros[i][j].asignarPaquete(paquete)) {
                    System.out.println("📦 Paquete asignado al casillero #" + casilleros[i][j].getNumero());
                    return true;
                }
            }
        }
        return false;
    }
    
    private void consultarCasillerosDisponibles() {
        System.out.println("\n═══ CASILLEROS DISPONIBLES ═══");
        
        int pequeños = 0, medianos = 0, grandes = 0;
        
        System.out.println("\nCasilleros disponibles por tamaño:");
        System.out.println("PEQUEÑO:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (!casilleros[i][j].isOcupado() && casilleros[i][j].getTamaño().equals("PEQUEÑO")) {
                    System.out.print("  #" + casilleros[i][j].getNumero() + " ");
                    pequeños++;
                }
            }
        }
        System.out.println(" (" + pequeños + " disponibles)");
        
        System.out.println("MEDIANO:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (!casilleros[i][j].isOcupado() && casilleros[i][j].getTamaño().equals("MEDIANO")) {
                    System.out.print("  #" + casilleros[i][j].getNumero() + " ");
                    medianos++;
                }
            }
        }
        System.out.println(" (" + medianos + " disponibles)");
        
        System.out.println("GRANDE:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (!casilleros[i][j].isOcupado() && casilleros[i][j].getTamaño().equals("GRANDE")) {
                    System.out.print("  #" + casilleros[i][j].getNumero() + " ");
                    grandes++;
                }
            }
        }
        System.out.println(" (" + grandes + " disponibles)");
        
        System.out.println("\nTotal de casilleros disponibles: " + (pequeños + medianos + grandes) + "/30");
    }
    
    private void mostrarInformacionPaquetes() {
        System.out.println("\n═══ INFORMACIÓN DE PAQUETES EN CASILLEROS ═══");
        
        boolean hayPaquetes = false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (casilleros[i][j].isOcupado()) {
                    Paquete paquete = casilleros[i][j].getPaquete();
                    System.out.println("Casillero #" + casilleros[i][j].getNumero() + 
                                     " (" + casilleros[i][j].getTamaño() + "):");
                    System.out.println("  📦 ID Paquete: " + paquete.getId());
                    System.out.println("  👤 Destinatario: " + paquete.getDestinatario());
                    System.out.println("  📅 Fecha de Ingreso: " + paquete.getFechaIngreso().format(formatter));
                    System.out.println("  📋 Descripción: " + paquete.getDescripcion());
                    System.out.println("  📏 Tamaño: " + paquete.getTamaño());
                    System.out.println();
                    hayPaquetes = true;
                }
            }
        }
        
        if (!hayPaquetes) {
            System.out.println("No hay paquetes almacenados en los casilleros.");
        }
    }
    
    private void mostrarEsquemaCasilleros() {
        System.out.println("\n═══ ESQUEMA DE CASILLEROS ═══");
        System.out.println("P = PEQUEÑO, M = MEDIANO, G = GRANDE");
        System.out.println("✅ = Disponible, ❌ = Ocupado\n");
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                String simbolo = casilleros[i][j].isOcupado() ? "❌" : "✅";
                String tamaño = casilleros[i][j].getTamaño().substring(0, 1);
                System.out.printf("[%s%s%02d] ", simbolo, tamaño, casilleros[i][j].getNumero());
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Método para contar casilleros ocupados (utilidad adicional)
    public int contarCasillerosOcupados() {
        int contador = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (casilleros[i][j].isOcupado()) {
                    contador++;
                }
            }
        }
        return contador;
    }
}