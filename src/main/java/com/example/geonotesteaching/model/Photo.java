package com.example.geonotesteaching.model;

// Los 'records' también pueden implementar interfaces. Son una forma limpia de
// definir los subtipos de la interfaz sellada.
public record Photo(String url, int width, int height) implements Attachment {
    public Photo {
        if (url == null || url.isBlank()) {
            throw new IllegalArgumentException("Photo.url requerido");
        }
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimensiones de Photo inválidas: " + width + "x" + height);
        }
    }
}