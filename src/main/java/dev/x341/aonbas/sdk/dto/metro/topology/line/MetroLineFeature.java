package dev.x341.aonbas.sdk.dto.metro.topology.line;

public record MetroLineFeature(
        String type, // "Feature"
        String id,
        String geometry_name,
        MetroLineGeometry geometry,
        MetroLineProperties properties
) {}