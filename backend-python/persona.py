class Persona:
    def __init__(self, nombre, edad, email):
        if edad <= 0:
            raise ValueError("La edad debe ser positiva.")
        if "@" not in email:
            raise ValueError("El email debe contener '@'.")
        self.nombre = nombre
        self.edad = edad
        self.email = email

    def es_mayor_de_edad(self):
        return self.edad >= 18

    def mostrar_info(self):
        print(f"Nombre: {self.nombre}")
        print(f"Edad: {self.edad}")
        print(f"Email: {self.email}")


if __name__ == "__main__":
    persona = Persona("Ilan", 21, "ilan@example.com")
    persona.mostrar_info()
    print("¿Mayor de edad?", persona.es_mayor_de_edad())
