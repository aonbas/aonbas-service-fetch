package dev.x341.aonbas.sdk.dto.metro.realtime;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record StationSlot(
        @SerializedName("codi_via") int codiVia,
        @SerializedName("id_sentit") int idSentit,
        @SerializedName("codi_estacio") int codiEstacio,
        @SerializedName("linies_trajectes") List<RouteDetail> liniesTrajectes
) {}
