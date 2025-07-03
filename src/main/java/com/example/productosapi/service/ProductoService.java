package com.example.productosapi.service;

import com.example.productosapi.model.Producto;
import java.util.List;

public interface ProductoService {
    Producto crearProducto(Producto producto);
    Producto obtenerProducto(Integer id);
    List<Producto> listarProductos();
    Producto actualizarProducto(Integer id, Producto producto);
    boolean eliminarProducto(Integer id);
}