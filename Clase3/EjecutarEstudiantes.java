import java.util.Arrays;

public class EjecutarEstudiantes {
    public static void main(String[] args) {
    
        Estudiante objEst1 = new Estudiante(1, "Juan", "Ingeniería");
        Estudiante objEst2 = new Estudiante(2, "Pedro", "Derecho");
        Estudiante objEst3 = new Estudiante(3, "María", "Ingeniería");
        
        //Creación del arreglo de objetos
        Estudiante[] est = new Estudiante[4];

        //Asignar los estudiantes a cada posición del arreglo de objetos
        est[0] = objEst1;
        est[1] = objEst2;
        est[2] = objEst3;
        est[3] = new Estudiante(4, "Ana", "Psicología");

        //Forma1 --> Imprimir el arreglo de objetos
        for(int i = 0; i < est.length; i++){
            System.out.println(est[i]);
        }

        //Forma2 --> Imprimir el arreglo de objetos
        System.out.println(Arrays.toString(est));

        //Ejecución del método contarEstudiantes
        String f = "Ingeniería";
        System.out.println("# de estudiantes: " + objEst1.contarEstudiantes(est, f) + " : " + f);

        //Ejecución del método mostrarNombres
        objEst1.mostrarNombres(est);


    }
}


    
