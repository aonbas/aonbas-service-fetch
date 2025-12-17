package dev.x341.aonbas.sdk.dto.metro.topology.line;

import java.util.List;

public record MetroLinesResponse(
        String type, // "FeatureCollection"
        List<MetroLineFeature> features,
        int totalFeatures,
        int numberMatched,
        int numberReturned,
        String timeStamp
) {}