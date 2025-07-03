# API de Gestión de Productos - Spring Boot

Esta es la traducción a **Spring Boot** de la API original desarrollada en **FastAPI**. La API gestiona la entidad `Producto` con operaciones CRUD completas.

## Características

- ✅ **Endpoints CRUD**: Crear, obtener, listar, actualizar y eliminar productos
- ✅ **Validaciones**: 
  - Nombre obligatorio (no vacío)
  - Precio debe ser positivo
  - Stock debe ser entero >= 0
- ✅ **Separación en capas**: Modelo, Servicio, Controlador
- ✅ **Estructura modular**: Archivos separados por responsabilidad
- ✅ **Documentación automática**: Swagger UI disponible
- ✅ **Almacenamiento en memoria**: Idéntico al comportamiento original

## Estructura del Proyecto

```
src/main/java/com/ejemplo/productos/
├── ProductosApplication.java          # Clase principal de Spring Boot
├── model/
│   └── Producto.java                  # Modelo con validaciones
├── service/
│   └── ProductoService.java           # Lógica de negocio
└── controller/
    ├── ProductoController.java        # Endpoints REST
    └── GlobalExceptionHandler.java    # Manejo de errores
```

## Requisitos

- **Java 17+**
- **Maven 3.6+**

## Instalación y Ejecución

1. **Instalar dependencias:**
   ```bash
   mvn clean install
   ```

2. **Ejecutar la aplicación:**
   ```bash
   mvn spring-boot:run
   ```

3. **Verificar que está funcionando:**
   - Servidor: http://localhost:8000
   - Documentación Swagger: http://localhost:8000/docs
   - OpenAPI JSON: http://localhost:8000/openapi.json

## Endpoints Disponibles

### POST /productos
Crear un nuevo producto
```json
// Request Body
{
  "nombre": "Laptop HP",
  "precio": 999.99,
  "stock": 10
}

// Response
{
  "id": 1,
  "nombre": "Laptop HP",
  "precio": 999.99,
  "stock": 10
}
```

### GET /productos/{id}
Obtener un producto por ID
```json
// Response
{
  "id": 1,
  "nombre": "Laptop HP",
  "precio": 999.99,
  "stock": 10
}
```

### GET /productos
Listar todos los productos
```json
// Response
[
  {
    "id": 1,
    "nombre": "Laptop HP",
    "precio": 999.99,
    "stock": 10
  }
]
```

### PUT /productos/{id}
Actualizar un producto existente
```json
// Request Body
{
  "nombre": "Laptop HP Actualizada",
  "precio": 1099.99,
  "stock": 5
}

// Response
{
  "id": 1,
  "nombre": "Laptop HP Actualizada",
  "precio": 1099.99,
  "stock": 5
}
```

### DELETE /productos/{id}
Eliminar un producto
```json
// Response
{
  "ok": true
}
```

## Validaciones

Las validaciones se aplican automáticamente:

- **Nombre**: Obligatorio, no puede estar vacío
- **Precio**: Debe ser un número positivo
- **Stock**: Debe ser un entero mayor o igual a 0

### Ejemplo de Error de Validación
```json
{
  "detail": "Error de validación",
  "errors": {
    "nombre": "El nombre es obligatorio y no puede estar vacío",
    "precio": "El precio debe ser positivo"
  }
}
```

## Comparación con la Versión Original

| Aspecto | FastAPI (Python) | Spring Boot (Java) |
|---------|------------------|-------------------|
| Puerto por defecto | 8000 | 8000 |
| Documentación | `/docs` | `/docs` |
| Validaciones | Pydantic | Bean Validation |
| Almacenamiento | Lista en memoria | Map en memoria |
| Respuestas de error | HTTPException | ResponseEntity |
| Estructura | 3 archivos | 6 archivos (más modular) |

## Dependencias Principales

- **Spring Boot Web**: Framework web y REST
- **Spring Boot Validation**: Validaciones Bean Validation
- **SpringDoc OpenAPI**: Generación de documentación Swagger
- **Spring Boot Test**: Pruebas unitarias

## Notas Técnicas

1. **Thread Safety**: El servicio utiliza `ConcurrentHashMap` y `AtomicLong` para manejo seguro de concurrencia
2. **Validaciones**: Se usan anotaciones Jakarta Validation para replicar exactamente las validaciones de Pydantic
3. **Documentación**: SpringDoc genera automáticamente la documentación OpenAPI/Swagger
4. **Manejo de Errores**: `GlobalExceptionHandler` proporciona respuestas de error consistentes
5. **Configuración**: Todo configurable a través de `application.properties`

## Extensibilidad

La arquitectura permite fácilmente:
- Agregar persistencia con JPA/Hibernate
- Implementar autenticación y autorización
- Agregar cachéing con Redis
- Implementar pruebas unitarias y de integración
- Configurar perfiles de entorno (dev, test, prod) 