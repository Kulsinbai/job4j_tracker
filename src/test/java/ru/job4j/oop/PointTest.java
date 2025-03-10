package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    public void whenDistance2D() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        double expected = 5.0;
        double result = p1.distance(p2);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenDistance3D() {
        Point p1 = new Point(0, 0, 0);
        Point p2 = new Point(1, 2, 2);
        double expected = 3.0;
        double result = p1.distance3d(p2);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenSamePoint3D() {
        Point p1 = new Point(5, 5, 5);
        Point p2 = new Point(5, 5, 5);
        double expected = 0.0;
        double result = p1.distance3d(p2);
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenNegativeCoordinates3D() {
        Point p1 = new Point(-1, -2, -3);
        Point p2 = new Point(4, 1, 2);
        double expected = Math.sqrt(59);
        double result = p1.distance3d(p2);
        assertEquals(expected, result, 0.01);
    }
}