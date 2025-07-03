package com.ejemplo.productos.controller;

import com.ejemplo.productos.model.Producto;
import com.ejemplo.productos.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controlador REST para la gestión de productos.
 * Replica exactamente los endpoints del main.py original de FastAPI.
 */
@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "API para gestión de productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    /**
     * Crear un nuevo producto.
     * Equivalente a @app.post("/productos") def crear(producto: Producto)
     */
    @PostMapping
    @Operation(summary = "Crear producto", description = "Crea un nuevo producto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Producto creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<Producto> crear(@Valid @RequestBody Producto producto) {
        Producto productoCreado = productoService.crearProducto(producto);
        return new ResponseEntity<>(productoCreado, HttpStatus.CREATED);
    }
    
    /**
     * Obtener un producto por ID.
     * Equivalente a @app.get("/productos/{producto_id}") def obtener(producto_id: int)
     */
    @GetMapping("/{productoId}")
    @Operation(summary = "Obtener producto", description = "Obtiene un producto por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto encontrado"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Producto> obtener(
            @Parameter(description = "ID del producto", required = true)
            @PathVariable Long productoId) {
        
        Optional<Producto> produto = productoService.obtenerProducto(productoId);
        
        if (produto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(produto.get());
    }
    
    /**
     * Listar todos los productos.
     * Equivalente a @app.get("/productos") def listar()
     */
    @GetMapping
    @Operation(summary = "Listar productos", description = "Obtiene la lista de todos los productos")
    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente")
    public ResponseEntity<List<Producto>> listar() {
        List<Producto> productos = productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }
    
    /**
     * Actualizar un producto existente.
     * Equivalente a @app.put("/productos/{producto_id}") def actualizar(producto_id: int, producto: Producto)
     */
    @PutMapping("/{productoId}")
    @Operation(summary = "Actualizar producto", description = "Actualiza un producto existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado"),
        @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    public ResponseEntity<Producto> actualizar(
            @Parameter(description = "ID del producto", required = true)
            @PathVariable Long productoId,
            @Valid @RequestBody Producto producto) {
        
        Optional<Producto> productoActualizado = productoService.actualizarProducto(productoId, producto);
        
        if (productoActualizado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return ResponseEntity.ok(productoActualizado.get());
    }
    
    /**
     * Eliminar un producto.
     * Equivalente a @app.delete("/productos/{producto_id}") def eliminar(producto_id: int)
     */
    @DeleteMapping("/{productoId}")
    @Operation(summary = "Eliminar producto", description = "Elimina un producto por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Producto eliminado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    public ResponseEntity<Map<String, Boolean>> eliminar(
            @Parameter(description = "ID del producto", required = true)
            @PathVariable Long productoId) {
        
        boolean eliminado = productoService.eliminarProducto(productoId);
        
        if (!eliminado) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Replica la respuesta {"ok": True} del código Python
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("ok", true);
        return ResponseEntity.ok(respuesta);
    }
} 