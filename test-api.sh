#!/bin/bash

# Script de prueba para la API de Productos en Spring Boot
# Asegúrate de que la aplicación esté ejecutándose en el puerto 8000

BASE_URL="http://localhost:8000"

echo "🚀 Probando la API de Productos Spring Boot..."
echo ""

echo "1. Creando un producto..."
RESPONSE1=$(curl -s -X POST "$BASE_URL/productos" \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Laptop HP",
    "precio": 999.99,
    "stock": 10
  }')
echo "Respuesta: $RESPONSE1"
echo ""

echo "2. Creando otro producto..."
RESPONSE2=$(curl -s -X POST "$BASE_URL/productos" \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Mouse Inalámbrico",
    "precio": 25.50,
    "stock": 50
  }')
echo "Respuesta: $RESPONSE2"
echo ""

echo "3. Listando todos los productos..."
RESPONSE3=$(curl -s -X GET "$BASE_URL/productos")
echo "Respuesta: $RESPONSE3"
echo ""

echo "4. Obteniendo producto con ID 1..."
RESPONSE4=$(curl -s -X GET "$BASE_URL/productos/1")
echo "Respuesta: $RESPONSE4"
echo ""

echo "5. Actualizando producto con ID 1..."
RESPONSE5=$(curl -s -X PUT "$BASE_URL/productos/1" \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Laptop HP Actualizada",
    "precio": 1099.99,
    "stock": 5
  }')
echo "Respuesta: $RESPONSE5"
echo ""

echo "6. Probando validación (precio negativo)..."
RESPONSE6=$(curl -s -X POST "$BASE_URL/productos" \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "",
    "precio": -100,
    "stock": -5
  }')
echo "Respuesta: $RESPONSE6"
echo ""

echo "7. Eliminando producto con ID 2..."
RESPONSE7=$(curl -s -X DELETE "$BASE_URL/productos/2")
echo "Respuesta: $RESPONSE7"
echo ""

echo "8. Listando productos finales..."
RESPONSE8=$(curl -s -X GET "$BASE_URL/productos")
echo "Respuesta: $RESPONSE8"
echo ""

echo "✅ Pruebas completadas!"
echo ""
echo "📚 Ver documentación Swagger en: $BASE_URL/docs" 