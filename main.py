from fastapi import FastAPI, HTTPException
from models import Producto
from services import ProductoService

app = FastAPI()
servicio = ProductoService()

@app.post("/productos")
def crear(producto: Producto):
    return servicio.crear_producto(producto)

@app.get("/productos/{producto_id}")
def obtener(producto_id: int):
    prod = servicio.obtener_producto(producto_id)
    if not prod:
        raise HTTPException(status_code=404, detail="Producto no encontrado")
    return prod

@app.get("/productos")
def listar():
    return servicio.listar_productos()

@app.put("/productos/{producto_id}")
def actualizar(producto_id: int, producto: Producto):
    actualizado = servicio.actualizar_producto(producto_id, producto)
    if not actualizado:
        raise HTTPException(status_code=404, detail="Producto no encontrado")
    return actualizado

@app.delete("/productos/{producto_id}")
def eliminar(producto_id: int):
    exito = servicio.eliminar_producto(producto_id)
    if not exito:
        raise HTTPException(status_code=404, detail="Producto no encontrado")
    return {"ok": True}