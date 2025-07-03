package com.example.productosapi.service;

import com.example.productosapi.model.Producto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductoServiceImpl implements ProductoService {
    private final List<Producto> productos = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    @Override
    public Producto crearProducto(Producto producto) {
        producto.setId(idCounter.getAndIncrement());
        productos.add(producto);
        return producto;
    }

    @Override
    public Producto obtenerProducto(Integer id) {
        return productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }    @Override
    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    @Override
    public Producto actualizarProducto(Integer id, Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            if (p.getId().equals(id)) {
                producto.setId(id);
                productos.set(i, producto);
                return producto;
            }
        }
        return null;
    }

    @Override
    public boolean eliminarProducto(Integer id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }
}