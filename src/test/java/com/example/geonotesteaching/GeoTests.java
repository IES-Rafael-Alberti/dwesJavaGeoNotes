package com.example.geonotesteaching;

import com.example.geonotesteaching.export.JsonExporter;
import com.example.geonotesteaching.geo.*;
import com.example.geonotesteaching.model.*;
import com.example.geonotesteaching.service.Timeline;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

public class GeoTests {

    @Test
    void testIsInAreaOrderAgnostic() {
        GeoPoint a = new GeoPoint(10, -5);
        GeoPoint b = new GeoPoint(12, 2);
        GeoArea area = new GeoArea(a, b);
        assertTrue(Match.isInArea(new GeoPoint(11, 0), area));
        assertFalse(Match.isInArea(new GeoPoint(20, 0), area));
        GeoArea area2 = new GeoArea(b, a);
        assertTrue(Match.isInArea(new GeoPoint(11, 0), area2));
    }

    @Test
    void testJsonExporterBasic() {
        Timeline t = new Timeline();
        t.addNote(new Note(1, "A", "B", new GeoPoint(0,0), Instant.now(), null));
        String json = new JsonExporter(t.asCollection()).export();
        assertTrue(json.contains("\"notes\""));
        assertTrue(json.contains("\"id\": 1"));
    }
}