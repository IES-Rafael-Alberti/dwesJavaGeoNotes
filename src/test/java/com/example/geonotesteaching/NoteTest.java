package com.example.geonotesteaching;

import com.example.geonotesteaching.geo.GeoPoint;
import com.example.geonotesteaching.model.Note;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void titleIsRequired_andBlankNotAllowed() {
        var loc = new GeoPoint(10, 10);
        assertThrows(IllegalArgumentException.class, () -> new Note(1L, null, "c", loc, Instant.now(), null));
        assertThrows(IllegalArgumentException.class, () -> new Note(1L, "   ", "c", loc, Instant.now(), null));
    }

    @Test
    void contentDefaultsToEmptyWhenNull() {
        var loc = new GeoPoint(0, 0);
        Note n = new Note(2L, "title", null, loc, Instant.now(), null);
        assertEquals("", n.content());
    }

    @Test
    void locationIsRequired() {
        assertThrows(IllegalArgumentException.class, () -> new Note(3L, "title", "c", null, Instant.now(), null));
    }

    @Test
    void createdAtDefaultsWhenNull() {
        var loc = new GeoPoint(0, 0);
        Note n = new Note(4L, "title", "c", loc, null, null);
        assertNotNull(n.createdAt());
    }
}
