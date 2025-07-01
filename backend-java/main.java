public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Ilan", 21, "ilan@example.com");
        p.mostrarInfo();
        System.out.println("¿Mayor de edad? " + p.esMayorDeEdad());
    }
}
