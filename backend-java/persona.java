public class Persona {
    private String nombre;
    private int edad;
    private String email;

    public Persona(String nombre, int edad, String email) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no debe estar vacío.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad debe ser positiva.");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("El email debe contener '@'.");
        }
        
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad);
        System.out.println("Email: " + this.email);
    }

    // Getters (opcionales, según necesidades)
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }
}