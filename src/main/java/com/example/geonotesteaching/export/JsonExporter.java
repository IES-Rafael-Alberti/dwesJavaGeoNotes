package com.example.geonotesteaching.export;

import com.example.geonotesteaching.model.Note;

import java.util.Collection;
import java.util.Comparator;

/**
 * Exportador de notas a formato JSON.
 * Esta clase toma una colección de objetos Note y genera una representación JSON de los mismos.
 * Es 'final' porque su implementación es sencilla y estable, no se espera que se extienda.
 */
public final class JsonExporter extends AbstractExporter {
    /**
     * Colección de notas a exportar.
     */
    private final Collection<Note> notes;

    /**
     * Constructor que recibe la colección de notas a exportar.
     * @param notes colección de objetos Note
     */
    public JsonExporter(Collection<Note> notes) { this.notes = notes; }

    /**
     * Genera una cadena JSON con todas las notas ordenadas por id.
     * Cada nota se representa como un objeto con sus campos principales.
     * @return cadena JSON con la estructura de las notas
     */
    @Override
    public String export() {
        var notesList = notes.stream()
                .sorted(Comparator.comparingLong(Note::id))
                .map(n -> String.format("""
                        {
                          "id": %d,
                          "title": "%s",
                          "content": "%s",
                          "location": { "lat": %f, "lon": %f },
                          "createdAt": "%s"
                        }""",
                        n.id(), esc(n.title()), esc(n.content()),
                        n.location().lat(), n.location().lon(),
                        n.createdAt()))
                .toList();

        String joined = String.join(",\n", notesList);
        return String.format("""
                {
                  "notes": [
                    %s
                  ]
                }""", joined);
    }

    /**
     * Realiza un escapado mínimo de comillas para los campos de texto en JSON.
     * En producción se recomienda usar una librería especializada para evitar problemas de seguridad y compatibilidad.
     * @param s cadena a escapar
     * @return cadena con comillas escapadas
     */
    private static String esc(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }
}