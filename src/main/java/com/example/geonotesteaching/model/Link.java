package com.example.geonotesteaching.model;

// Record que representa un enlace opcionalmente con etiqueta visible.
// Implementa la interfaz sellada Attachment (Java 17).
public record Link(String url, String label) implements Attachment {
    public Link {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("Link.url requerido");
        }
        // Normalizamos label: si viene en blanco, lo tratamos como null (más fácil de manejar).
        if (label != null && label.isBlank()) {
            label = null;
        }
    }

    // Devuelve la etiqueta "efectiva": si no hay label, usamos la URL como texto.
    public String effectiveLabel() {
        return (label == null || label.isBlank()) ? url : label;
    }
}