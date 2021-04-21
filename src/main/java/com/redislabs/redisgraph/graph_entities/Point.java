package com.redislabs.redisgraph.graph_entities;

import java.util.List;
import java.util.Objects;

/**
 * This class represents a (geographical) point in the graph.
 */
public final class Point {

    private static final double EPSILON = 1e-5;

    private final double latitude;
    private final double longitude;

    /**
     * @param latitude
     * @param longitude 
     */
    public Point(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @param values {@code [latitude, longitude]}
     */
    public Point(List<Double> values) {
        if (values == null || values.size() != 2) {
            throw new IllegalStateException("Point requires two doubles.");
        }
        this.latitude = values.get(0);
        this.longitude = values.get(1);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Point)) return false;
        Point o = (Point) other;
        return Math.abs(latitude - o.latitude) < EPSILON &&
                Math.abs(longitude - o.longitude) < EPSILON;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append('}');
        return sb.toString();
    }
}
