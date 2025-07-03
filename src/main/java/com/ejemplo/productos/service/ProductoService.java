package com.ejemplo.productos.service;

import com.ejemplo.productos.model.Producto;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Servicio que gestiona la lógica de negocio para los productos.
 * Replica exactamente la funcionalidad del ProductoService de Python,
 * usando almacenamiento en memoria.
 */
@Service
public class ProductoService {
    
    // Almacenamiento en memoria (equivalente a self._productos en Python)
    private final Map<Long, Producto> productos = new ConcurrentHashMap<>();
    
    // Contador de IDs (equivalente a self._id_counter en Python)
    private final AtomicLong idCounter = new AtomicLong(1);
    
    /**
     * Crea un nuevo producto y lo almacena.
     * Equivalente a crear_producto() en Python.
     */
    public Producto crearProducto(Producto producto) {
        Long nuevoId = idCounter.getAndIncrement();
        
        // Crear una nueva instancia con el ID asignado
        Producto productoConId = new Producto(
            nuevoId,
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock()
        );
        
        productos.put(nuevoId, productoConId);
        return productoConId;
    }
    
    /**
     * Obtiene un producto por su ID.
     * Equivalente a obtener_producto() en Python.
     */
    public Optional<Producto> obtenerProducto(Long productoId) {
        return Optional.ofNullable(productos.get(productoId));
    }
    
    /**
     * Lista todos los productos.
     * Equivalente a listar_productos() en Python.
     */
    public List<Producto> listarProductos() {
        return new ArrayList<>(productos.values());
    }
    
    /**
     * Actualiza un producto existente.
     * Equivalente a actualizar_producto() en Python.
     */
    public Optional<Producto> actualizarProducto(Long productoId, Producto producto) {
        if (!productos.containsKey(productoId)) {
            return Optional.empty();
        }
        
        // Actualizar manteniendo el ID original
        Producto productoActualizado = new Producto(
            productoId,
            producto.getNombre(),
            producto.getPrecio(),
            producto.getStock()
        );
        
        productos.put(productoId, productoActualizado);
        return Optional.of(productoActualizado);
    }
    
    /**
     * Elimina un producto por su ID.
     * Equivalente a eliminar_producto() en Python.
     */
    public boolean eliminarProducto(Long productoId) {
        return productos.remove(productoId) != null;
    }
    
    /**
     * Método auxiliar para verificar si existe un producto
     */
    public boolean existeProducto(Long productoId) {
        return productos.containsKey(productoId);
    }
    
    /**
     * Método auxiliar para obtener el número total de productos
     */
    public int cantidadProductos() {
        return productos.size();
    }
} 