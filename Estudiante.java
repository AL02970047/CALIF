public class Estudiante {
    // Atributos
    private String nombre;
    private int[] calificaciones;


    public Estudiante(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    // Método para calcular el promedio de las calificaciones
    public double calcularPromedio() {
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma / (double) calificaciones.length;
    }

    // Método para obtener la calificación final a partir del promedio
    public char obtenerCalificacionFinal(double promedio) {
        if (promedio <= 50) {
            return 'F';
        } else if (promedio <= 60) {
            return 'E';
        } else if (promedio <= 70) {
            return 'D';
        } else if (promedio <= 80) {
            return 'C';
        } else if (promedio <= 90) {
            return 'B';
        } else {
            return 'A';
        }
    }

    // Método para imprimir los resultados
    public void imprimirResultados() {
        double promedio = calcularPromedio();
        char calificacionFinal = obtenerCalificacionFinal(promedio);

        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.printf(" Promedio: %.2f\n", promedio);
        System.out.println(" Calificación: " + calificacionFinal);
    }
    
    public static void main(String[] args) {
        // Ejemplo de uso
        int[] calificaciones = {85, 90, 90, 92, 88};
        Estudiante estudiante = new Estudiante("Oscar Garcia", calificaciones);
        estudiante.imprimirResultados();
    }
}
