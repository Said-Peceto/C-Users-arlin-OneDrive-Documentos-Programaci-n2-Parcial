import java.util.Scanner;
import java.util.Date;

public class Parcial1 {
    private static String[] usuarios = {"usuario1", "usuario2", "usuario3"}; // Puedo expandir los usuarios cada vez que sea necesario :)
    private static String[] contrasenas = {"admin1", "admin2", "admin3"};
    private static String[] nombres = {"Said", "Gabriela", "Lionel"};
    private static String[] apellidos = {"Peceto", "Gómez", "Messi"};
    private static String usuarioActual;
    private static String contrasenaActual;
    private static String[] tickets = new String[100]; 
    private static int numTickets = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("------Universidad  XYZ------\n");
            System.out.println("Ingrese su usuario:");
            String usuario = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();

            loggedIn = iniciarSesion(usuario, contrasena);
        }

        Date fechaHoraInicio = new Date();
        System.out.println("Fecha y hora de inicio de sesión: " + fechaHoraInicio);

        System.out.println("Ingrese una nueva contraseña:");
        String nuevaContrasena = scanner.nextLine();
        cambiarContrasena(nuevaContrasena);

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    subirTicket(scanner);
                    break;
                case 2:
                    verTickets();
                    break;
                case 3:
                    System.out.println("Sesión finalizada. Fecha y hora de cierre de sesión: " + new Date());
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        } while (opcion != 3);
    }

    private static boolean iniciarSesion(String usuario, String contrasena) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].equals(usuario) && contrasenas[i].equals(contrasena)) {
                usuarioActual = usuario;
                contrasenaActual = contrasena;
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + nombres[i] + " " + apellidos[i] + "!");
                return true;
            }
        }
        System.out.println("Credenciales incorrectas. Por favor, inténtelo nuevamente.");
        return false;
    }

    private static void cambiarContrasena(String nuevaContrasena) {
        contrasenaActual = nuevaContrasena;
        System.out.println("Contraseña actualizada exitosamente.");
    }

    private static void mostrarMenu() {
        System.out.println("------- Menú -------");
        System.out.println("1) Subir un ticket");
        System.out.println("2) Ver tickets");
        System.out.println("3) Salir");
        System.out.println("---------------------");
        System.out.println("Ingrese una opción: ");
    }

    private static void subirTicket(Scanner scanner) {
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese su identificación:");
        String identificacion = scanner.nextLine();
        System.out.println("Ingrese su correo:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese la carrera que estudia:");
        String carrera = scanner.nextLine();
        System.out.println("Ingrese el ticket que desea enviar: \n - Queja \n - Sugerencia");
        String ticket = scanner.nextLine();
        System.out.println("Escribe un comentario de tu Sugerencia/queja:");
        String comentario = scanner.nextLine();

        String informacionTicket = "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido + "\n" +
                "Identificación: " + identificacion + "\n" +
                "Correo: " + correo + "\n" +
                "Carrera: " + carrera + "\n" +
                "Ticket: " + ticket + "\n" +
                "Comentario: " + comentario + "\n";
                

        tickets[numTickets] = informacionTicket;
        numTickets++;

        System.out.println("Ticket enviado exitosamente. Código del ticket: " + numTickets);
    }

    private static void verTickets() {
        System.out.println("Tickets generados:");
        for (int i = 0; i < numTickets; i++) {
            System.out.println("Código del ticket: " + (i + 1));
            System.out.println(tickets[i]);
            System.out.println("------------------------");
        }
    }
}

