package com.example.geonotesteaching;

import com.example.geonotesteaching.export.JsonExporter;
import com.example.geonotesteaching.geo.GeoPoint;
import com.example.geonotesteaching.model.Note;
import com.example.geonotesteaching.service.Timeline;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class TimelineExportTest {

    @Test
    void exportWrapsNotesArray_andOrdersByIdAscending() {
        Timeline timeline = new Timeline();
        var loc = new GeoPoint(10, 20);

        // Dos notas con distintos ids
        Note n100 = new Note(100L, "First", "Content A", loc,
                Instant.parse("2024-01-01T00:00:00Z"), null);
        Note n200 = new Note(200L, "Second", "Content B", loc,
                Instant.parse("2024-01-02T00:00:00Z"), null);
        timeline.addNote(n100);
        timeline.addNote(n200);

        // Exportador JSON con la colección de notas
        JsonExporter exporter = new JsonExporter(timeline.asCollection());
        String out = exporter.export();

        assertTrue(out.startsWith("{"));
        assertTrue(out.contains("\"notes\": ["));

        // Contiene ambas notas
        assertTrue(out.contains("\"id\": 100"));
        assertTrue(out.contains("\"title\": \"First\""));
        assertTrue(out.contains("\"id\": 200"));
        assertTrue(out.contains("\"title\": \"Second\""));

        // Comprobamos que la nota con id 100 aparece antes que la 200 (orden ascendente)
        int idx100 = out.indexOf("\"id\": 100");
        int idx200 = out.indexOf("\"id\": 200");
        assertTrue(idx100 >= 0 && idx200 >= 0 && idx100 < idx200,
                "Expected id 100 to appear before id 200:\n" + out);
    }
}