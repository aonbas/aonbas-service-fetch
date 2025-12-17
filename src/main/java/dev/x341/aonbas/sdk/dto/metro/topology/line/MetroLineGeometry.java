package dev.x341.aonbas.sdk.dto.metro.topology.line;

import java.util.List;

public record MetroLineGeometry(
        String type, // "MultiLineString"
        // GeoJSON MultiLineString es array de arrays de arrays de doubles [Línea][Punto][Lat/Lon]
        List<List<List<Double>>> coordinates
) {}