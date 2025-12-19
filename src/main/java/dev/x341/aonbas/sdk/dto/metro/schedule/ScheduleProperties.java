package dev.x341.aonbas.sdk.dto.metro.schedule;

import com.google.gson.annotations.SerializedName;

public record ScheduleProperties(
        @SerializedName("ID_LINIA") int idLinia,
        @SerializedName("CODI_LINIA") int codiLinia,
        @SerializedName("NOM_LINIA") String nomLinia,
        @SerializedName("DESC_TIPUS_DIA") String descTipusDia,
        @SerializedName("HORARI") String horari,
        @SerializedName("PRIMERA_SORTIDA") String primeraSortida,
        @SerializedName("ULTIMA_SORTIDA") String ultimaSortida
) {}