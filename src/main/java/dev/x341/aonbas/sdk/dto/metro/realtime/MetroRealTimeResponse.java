package dev.x341.aonbas.sdk.dto.metro.realtime;

import java.util.List;

public record MetroRealTimeResponse(
        long timestamp,
        List<LineRealTime> linies
) {
}



