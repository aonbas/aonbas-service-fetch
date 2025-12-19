package dev.x341.aonbas.sdk.dto.metro.topology.station.interchange;

import java.util.List;

public record MetroInterchangeTopology(
        String type,
        List<InterchangeFeature> features,
        int totalFeatures,
        String timeStamp
) {}