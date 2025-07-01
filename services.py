from typing import List, Optional
from models import Producto

class ProductoService:
    def __init__(self):
        self._productos = []
        self._id_counter = 1

    def crear_producto(self, producto: Producto):
        data = producto.dict()
        data['id'] = self._id_counter
        self._id_counter += 1
        self._productos.append(data)
        return data

    def obtener_producto(self, producto_id: int) -> Optional[dict]:
        return next((p for p in self._productos if p['id'] == producto_id), None)

    def listar_productos(self) -> List[dict]:
        return self._productos

    def actualizar_producto(self, producto_id: int, producto: Producto) -> Optional[dict]:
        for p in self._productos:
            if p['id'] == producto_id:
                p.update(producto.dict())
                return p
        return None

    def eliminar_producto(self, producto_id: int) -> bool:
        for p in self._productos:
            if p['id'] == producto_id:
                self._productos.remove(p)
                return True
        return False