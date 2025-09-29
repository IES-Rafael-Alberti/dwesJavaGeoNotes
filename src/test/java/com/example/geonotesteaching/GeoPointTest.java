package com.example.geonotesteaching;

import com.example.geonotesteaching.geo.GeoPoint;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeoPointTest {

    @Test
    void createsValidPoint() {
        GeoPoint p = new GeoPoint(36.5297, -6.2927);
        assertEquals(36.5297, p.lat());
        assertEquals(-6.2927, p.lon());
    }

    @Test
    void throwsOnLatitudeTooLow() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new GeoPoint(-90.1, 0));
        assertTrue(ex.getMessage().contains("Latitud inválida"));
    }

    @Test
    void throwsOnLatitudeTooHigh() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new GeoPoint(90.0001, 0));
        assertTrue(ex.getMessage().contains("Latitud inválida"));
    }

    @Test
    void throwsOnLongitudeTooLow() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new GeoPoint(0, -180.0001));
        assertTrue(ex.getMessage().contains("Longitud inválida"));
    }

    @Test
    void throwsOnLongitudeTooHigh() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new GeoPoint(0, 180.0001));
        assertTrue(ex.getMessage().contains("Longitud inválida"));
    }
}
