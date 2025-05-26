import java.util.ArrayList;
import java.util.Scanner;

public class Evidencia2POO {

    // Clase Persona con atributos privados y constructor
    static class Persona {
        private String nombre;
        private String apellido;
        private String genero;
        private int edad;

        public Persona(String nombre, String apellido, String genero, int edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.genero = genero;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public String getGenero() {
            return genero;
        }

        public int getEdad() {
            return edad;
        }
    }

    // Captura la información por teclado y almacena en ArrayList
    public static ArrayList<Persona> capturarPersonas(Scanner scanner, int cantidad) {
        ArrayList<Persona> persona = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese los datos de la persona " + (i + 1) + ":");

            String nombre;
            while (true) {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine().trim();
                if (!nombre.isEmpty() && nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
                    break;
                } else {
                    System.out.println("Entrada inválida. Ingrese solo su nombre real (letras y espacios entre palabras, sin números ni símbolos).");
                }
            }

            String apellido;
            while (true) {
                System.out.print("Apellido: ");
                apellido = scanner.nextLine().trim();
                if (!apellido.isEmpty() && apellido.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
                    break;
                } else {
                    System.out.println("El apellido no puede estar vacío. Intente nuevamente.");
                }
            }

            String genero;
            while (true) {
                System.out.print("Género (Masculino/Femenino): ");
                genero = scanner.nextLine().trim();
                if (genero.equalsIgnoreCase("Masculino") || genero.equalsIgnoreCase("Femenino")) {
                    break;
                } else {
                    System.out.println("Entrada inválida. Por favor ingrese 'Masculino' o 'Femenino'.");
                }
            }

            int edad;
            while (true) {
                System.out.print("Edad: ");
                String edadStr = scanner.nextLine().trim();
                try {
                    edad = Integer.parseInt(edadStr);
                    if (edad > 0) {
                        break;
                    } else {
                        System.out.println("La edad debe ser un número positivo mayor que cero.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un número entero para la edad.");
                }
            }

            persona.add(new Persona(nombre, apellido, genero, edad));
            System.out.println();
        }
        return persona;
    }

    // Muestra nombre, apellido y género
    public static void mostrarNombreYGenero(ArrayList<Persona> persona) {
        System.out.println("Nombre, Apellido y Género de las personas:");
        for (Persona p : persona) {
            System.out.println("Nombre: " + p.getNombre() +
                    ", Apellido: " + p.getApellido() +
                    ", Género: " + p.getGenero());
        }
        System.out.println();
    }

    // Calcula promedio de edad
    public static double calcularPromedioEdad(ArrayList<Persona> persona) {
        int suma = 0;
        for (Persona p : persona) {
            suma += p.getEdad();
        }
        return (double) suma / persona.size();
    }

    // Cuenta personas por género
    public static int contarGenero(ArrayList<Persona> persona, String generoBuscado) {
        int contador = 0;
        for (Persona p : persona) {
            if (p.getGenero().equalsIgnoreCase(generoBuscado)) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Cuántas personas desea ingresar?: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        ArrayList<Persona> persona = capturarPersonas(scanner, cantidad);

        mostrarNombreYGenero(persona);

        double promedio = calcularPromedioEdad(persona);
        System.out.printf("Promedio de edades: %.2f%n", promedio);

        int masculinos = contarGenero(persona, "Masculino");
        int femeninos = contarGenero(persona, "Femenino");

        System.out.println("Cantidad de personas con género Masculino: " + masculinos);
        System.out.println("Cantidad de personas con género Femenino: " + femeninos);

        scanner.close();
    }
}
