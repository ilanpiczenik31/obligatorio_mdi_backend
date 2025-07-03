package com.example.producto.service;

import com.example.producto.model.Producto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    private final List<Producto> productos = new ArrayList<>();
    private int idCounter = 1;

    public Producto crearProducto(Producto producto) {
        producto.setId(idCounter++);
        productos.add(producto);
        return producto;
    }

    public Optional<Producto> obtenerProducto(int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }

    public List<Producto> listarProductos() {
        return productos;
    }

    public Optional<Producto> actualizarProducto(int id, Producto producto) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(p -> {
                    p.setNombre(producto.getNombre());
                    p.setPrecio(producto.getPrecio());
                    p.setStock(producto.getStock());
                    return p;
                });
    }

    public boolean eliminarProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }
}
