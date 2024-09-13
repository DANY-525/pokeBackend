package com.example.pokemonapp.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class VehiculoTest {

    @Test
    public void testDefaultConstructor() {
        Vehiculo vehiculo = new Vehiculo();
        assertNull(vehiculo.getNumeroPlaca());
        assertNull(vehiculo.getTipo());
        assertNull(vehiculo.getFechaSoat());
        assertNull(vehiculo.getFechaTechno());
        assertNull(vehiculo.getUbicacion());
    }

    @Test
    public void testAllArgsConstructor() {
        Date now = new Date();
        Vehiculo vehiculo = new Vehiculo("ABC123", "Car", now, now, "Parking Lot");

        assertEquals("ABC123", vehiculo.getNumeroPlaca());
        assertEquals("Car", vehiculo.getTipo());
        assertEquals(now, vehiculo.getFechaSoat());
        assertEquals(now, vehiculo.getFechaTechno());
        assertEquals("Parking Lot", vehiculo.getUbicacion());
    }

    @Test
    public void testBuilder() {
        Date now = new Date();
        Vehiculo vehiculo = Vehiculo.builder()
                .numeroPlaca("XYZ789")
                .tipo("Truck")
                .fechaSoat(now)
                .fechaTechno(now)
                .ubicacion("Garage")
                .build();

        assertEquals("XYZ789", vehiculo.getNumeroPlaca());
        assertEquals("Truck", vehiculo.getTipo());
        assertEquals(now, vehiculo.getFechaSoat());
        assertEquals(now, vehiculo.getFechaTechno());
        assertEquals("Garage", vehiculo.getUbicacion());
    }

    @Test
    public void testSettersAndGetters() {
        Vehiculo vehiculo = new Vehiculo();
        Date now = new Date();

        vehiculo.setNumeroPlaca("LMN456");
        vehiculo.setTipo("Bike");
        vehiculo.setFechaSoat(now);
        vehiculo.setFechaTechno(now);
        vehiculo.setUbicacion("Street");

        assertEquals("LMN456", vehiculo.getNumeroPlaca());
        assertEquals("Bike", vehiculo.getTipo());
        assertEquals(now, vehiculo.getFechaSoat());
        assertEquals(now, vehiculo.getFechaTechno());
        assertEquals("Street", vehiculo.getUbicacion());
    }
}