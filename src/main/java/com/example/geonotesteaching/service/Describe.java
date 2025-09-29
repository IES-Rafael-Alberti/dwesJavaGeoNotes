package com.example.geonotesteaching.service;

import com.example.geonotesteaching.model.Attachment;
import com.example.geonotesteaching.model.Audio;
import com.example.geonotesteaching.model.Link;
import com.example.geonotesteaching.model.Photo;

/**
 * Utilidad para generar descripciones legibles de distintos tipos de adjuntos (Attachment).
 * Aprovecha características modernas de Java para hacer el código más conciso y expresivo.
 * Si se añaden nuevos tipos de Attachment, el switch debe actualizarse para mantener la exhaustividad.
 */
// Esta clase usa 'switch expressions' y 'pattern matching' para describir un 'Attachment'.
// - Switch como EXPRESIÓN (Java 14): el switch devuelve directamente un String.
// - Pattern matching en 'case' (Java 17+ para jerarquías selladas): permite casar el tipo
//   y nombrarlo (Photo p) y además añadir una GUARDIA 'when' con condiciones extra.
// - String::formatted (Java 15): alternativa a String.format con sintaxis más fluida.
public final class Describe {
    /**
     * Devuelve una descripción textual para el adjunto recibido.
     * Utiliza switch como expresión y pattern matching para distinguir el tipo concreto y aplicar reglas específicas.
     * @param a adjunto a describir
     * @return descripción legible del adjunto
     */
    public static String describeAttachment(Attachment a) {
        return switch (a) {
            // Si la foto es "grande" (ancho mayor a 1920), se indica alta definición y se muestran dimensiones.
            case Photo p when p.width() > 1920 -> "📷 Foto en alta definición (%d x %d)".formatted(p.width(), p.height());
            // Para otras fotos, solo se indica el tipo.
            case Photo p -> "📷 Foto";
            // Si el audio dura más de 5 minutos, se destaca como largo.
            case Audio audio when audio.duration() > 300 -> "🎵 Audio largo";
            // Para otros audios, solo se indica el tipo.
            case Audio audio -> "🎵 Audio";
            // Para enlaces, se muestra la etiqueta si existe, o la URL si no hay etiqueta.
            case Link l -> "🔗 %s".formatted((l.label() == null || l.label().isEmpty()) ? l.url() : l.label());
            // ... Si se añaden nuevos tipos de Attachment, añadir nuevos 'case' aquí para mantener la exhaustividad.
        };
    }
}