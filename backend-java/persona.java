public class Persona {
    private String nombre;
    private int edad;
    private String email;

    public Persona(String nombre, int edad, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe estar vacío.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 0.");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("El email debe contener '@'.");
        }

        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Email: " + email);
    }
}
