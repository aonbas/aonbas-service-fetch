package dev.x341.aonbas.sdk.dto.metro.topology.station;

import com.google.gson.annotations.SerializedName;

public record MetroStationProperties(
        @SerializedName("ID_ESTACIO") int idEstacio,
        @SerializedName("CODI_ESTACIO") int codiEstacio,
        @SerializedName("NOM_ESTACIO") String nomEstacio,
        @SerializedName("ORDRE_ESTACIO") int ordreEstacio,

        @SerializedName("ID_LINIA") int idLinia,
        @SerializedName("CODI_LINIA") int codiLinia,
        @SerializedName("NOM_LINIA") String nomLinia,
        @SerializedName("COLOR_LINIA") String colorLinia,

        @SerializedName("NOM_TIPUS_ACCESSIBILITAT") String accessibilitat,
        @SerializedName("NOM_TIPUS_ESTAT") String estat,

        @SerializedName("DATA_INAUGURACIO") String dataInauguracio,
        @SerializedName("PICTO") String picto,
        @SerializedName("PICTO_GRUP") String pictoGrup
) {}