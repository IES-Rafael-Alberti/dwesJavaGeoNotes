package com.example.geonotesteaching.model;

// Una 'sealed interface' permite controlar qué clases o records pueden implementarla.
// Esto es útil para modelar jerarquías cerradas y seguras.
public sealed interface Attachment permits Photo, Audio, Link {
}