package com.example.geonotesteaching.export;

// Una 'sealed interface' para la jerarquía de exportadores.
// 'non-sealed' permite que otras clases fuera de este archivo la extiendan,
// mientras que 'final' impide cualquier otra extensión.
public interface Exporter {
    String export();
}