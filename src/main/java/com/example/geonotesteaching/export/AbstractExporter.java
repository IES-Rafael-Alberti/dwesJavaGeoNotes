package com.example.geonotesteaching.export;

// Clase base para exportadores de datos.
// Implementa la interfaz Exporter, que define el contrato para cualquier exportador (por ejemplo, exportar a JSON, HTML, etc).
// "abstract sealed class" (Java 17):
//  - sealed: limita qué subclases pueden heredar, garantizando que solo las clases listadas en 'permits' (JsonExporter y Render) pueden extender esta clase.
//  - abstract: no se puede instanciar directamente; las subclases deben implementar el método export().
// Ventaja didáctica: el compilador fuerza que solo los exportadores previstos formen parte de la jerarquía, facilitando el mantenimiento y la comprensión del diseño.
// Render es una clase interna de Timeline que también actúa como exportador, permitiendo diferentes formatos de salida.
// Este patrón permite centralizar la lógica de exportación y facilita la extensión controlada del sistema.
public abstract class AbstractExporter implements Exporter  {
    // Método que cada exportador debe implementar para producir la salida final (por ejemplo, JSON, HTML, etc).
    public abstract String export();
}