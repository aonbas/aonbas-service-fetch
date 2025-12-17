package dev.x341.aonbas.sdk.dto.metro.topology.station;

import java.util.List;

public record MetroStationsResponse(
        String type, // "FeatureCollection"
        List<MetroStationFeature> features,
        int totalFeatures,
        String timeStamp
) {}
