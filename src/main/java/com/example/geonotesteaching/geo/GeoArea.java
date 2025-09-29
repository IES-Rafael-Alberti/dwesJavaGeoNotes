package com.example.geonotesteaching.geo;

/**
 * GeoArea representa un área rectangular en el espacio geográfico usando dos puntos: la esquina superior izquierda (topLeft)
 * y la esquina inferior derecha (bottomRight). Ambos puntos se definen mediante el record GeoPoint.
 * Este diseño es común en sistemas de información geográfica (GIS), mapas y aplicaciones que requieren delimitar zonas.
 * Uso de 'record' en Java:
 * - Los records son clases inmutables y concisas, ideales para modelar datos simples.
 * - Proporcionan automáticamente constructor, getters, equals, hashCode y toString.
 * - Facilitan la escritura de código seguro y legible.
 * Convención:
 * - topLeft: punto con la latitud más alta y la longitud más baja del área.
 * - bottomRight: punto con la latitud más baja y la longitud más alta.
 * Ejemplo de uso:
 *   GeoArea area = new GeoArea(new GeoPoint(40.5, -3.7), new GeoPoint(39.9, -3.5));
 * Ampliaciones posibles:
 * - Métodos para calcular el área, comprobar si un punto está dentro, etc.
 * - Validación de que topLeft realmente está arriba a la izquierda de bottomRight.
 * Relación:
 * - GeoArea utiliza GeoPoint, que también es un record y representa un punto geográfico (latitud, longitud).
 */
public record GeoArea(GeoPoint topLeft, GeoPoint bottomRight) { }