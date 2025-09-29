package com.example.geonotesteaching.geo;

// Un 'record' es una clase inmutable y concisa para modelar datos. Java genera automáticamente
// el constructor, los getters, los métodos equals(), hashCode() y toString().
// A diferencia de Kotlin, los tipos de los campos deben ser explícitos.
public record GeoPoint(double lat, double lon) {
    // El 'constructor compacto' de un record se usa para validar los datos de los campos.
    // Es una buena práctica para asegurar la consistencia del objeto.
    public GeoPoint {
        if (lat < -90 || lat > 90) throw new IllegalArgumentException("Latitud inválida: " + lat);
        if (lon < -180 || lon > 180) throw new IllegalArgumentException("Longitud inválida: " + lon);
    }
}