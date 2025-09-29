package com.example.geonotesteaching.service;

import com.example.geonotesteaching.model.Note;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Timeline gestiona una colección de notas (Note) manteniendo el orden de inserción.
 * Es útil para mostrar las notas en el mismo orden en que fueron añadidas, por ejemplo en una línea de tiempo.
 * Implementación:
 * - Utiliza un 'SequencedMap' para garantizar el orden y permitir acceso eficiente al primer y último elemento.
 * - En Java 21, LinkedHashMap implementa la interfaz SequencedMap, lo que permite compatibilidad y acceso a métodos como firstEntry() y lastEntry().
 * - A diferencia de HashMap, el orden de las notas es predecible y estable.
 * Nota: El método getNotes() expone el mapa interno, por lo que se debe tener cuidado con la mutabilidad externa.
 */
public final class Timeline {
    /**
     * Mapa de notas, clave: id de la nota, valor: objeto Note.
     * Se mantiene el orden de inserción gracias a LinkedHashMap (SequencedMap).
     */
    private final Map<Long, Note> notes = new LinkedHashMap<>();

    /**
     * Añade una nota a la línea de tiempo. Si ya existe una nota con el mismo id, se sobrescribe.
     * @param note nota a añadir
     */
    public void addNote(Note note) { notes.put(note.id(), note); }

    /**
     * Obtiene una nota por su id.
     * @param id identificador de la nota
     * @return la nota correspondiente, o null si no existe
     */
    public Note getNote(long id) { return notes.get(id); }

    /**
     * Devuelve el mapa completo de notas, manteniendo el orden de inserción.
     * Precaución: el mapa es mutable y puede modificarse externamente si se expone.
     * @return mapa de notas
     */
    public Map<Long, Note> getNotes() { return notes; }
    public Collection<Note> asCollection() { return notes.values(); }  // vista de valores

}