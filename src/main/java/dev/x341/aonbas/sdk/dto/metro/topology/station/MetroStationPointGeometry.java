package dev.x341.aonbas.sdk.dto.metro.topology.station;

import java.util.List;

public record MetroStationPointGeometry(
        String type, // "Point"
        List<Double> coordinates // GeoJSON estándar es [Longitud, Latitud]
) {
    public double getLon() {
        return (coordinates != null && coordinates.size() > 0) ? coordinates.get(0) : 0.0;
    }

    public double getLat() {
        return (coordinates != null && coordinates.size() > 1) ? coordinates.get(1) : 0.0;
    }
}