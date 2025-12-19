package dev.x341.aonbas.sdk.dto.metro.schedule;

import java.util.List;

public record MetroScheduleResponse(
        List<ScheduleFeature> features
) {}