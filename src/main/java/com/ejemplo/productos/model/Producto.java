package com.ejemplo.productos.model;

import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Modelo de Producto que replica las validaciones del modelo Python original:
 * - nombre: obligatorio (no vacío)
 * - precio: debe ser positivo
 * - stock: debe ser entero >= 0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Producto {
    
    private Long id;
    
    @NotBlank(message = "El nombre es obligatorio y no puede estar vacío")
    private String nombre;
    
    @Positive(message = "El precio debe ser positivo")
    @NotNull(message = "El precio es obligatorio")
    private Double precio;
    
    @Min(value = 0, message = "El stock debe ser mayor o igual a 0")
    @NotNull(message = "El stock es obligatorio")
    private Integer stock;
    
    // Constructor vacío requerido por Jackson
    public Producto() {}
    
    // Constructor con parámetros
    public Producto(String nombre, Double precio, Integer stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    // Constructor completo
    public Producto(Long id, String nombre, Double precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Double getPrecio() {
        return precio;
    }
    
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public Integer getStock() {
        return stock;
    }
    
    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
} 