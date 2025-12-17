package dev.x341.aonbas.sdk.dto.metro.topology.station;

public record MetroStationFeature(
        String type,
        String id,
        MetroStationPointGeometry geometry,
        MetroStationProperties properties
) {
    // Helper para obtener coordenadas rápido sin acceder a geometry.coordinates
    public double getLatitude() {
        return geometry != null ? geometry.getLat() : 0.0;
    }

    public double getLongitude() {
        return geometry != null ? geometry.getLon() : 0.0;
    }
}