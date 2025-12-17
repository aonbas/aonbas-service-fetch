package dev.x341.aonbas.sdk.dto.metro.topology.line;

import com.google.gson.annotations.SerializedName;

public record MetroLineProperties(
        @SerializedName("ID_LINIA") int idLinia,
        @SerializedName("CODI_LINIA") int codiLinia,
        @SerializedName("NOM_LINIA") String nomLinia,
        @SerializedName("DESC_LINIA") String descLinia,
        @SerializedName("ORIGEN_LINIA") String origenLinia,
        @SerializedName("DESTI_LINIA") String destiLinia,
        @SerializedName("NOM_OPERADOR") String nomOperador,
        @SerializedName("NOM_FAMILIA") String nomFamilia,
        @SerializedName("COLOR_LINIA") String colorLinia,
        @SerializedName("COLOR_TEXT_LINIA") String colorTextLinia,
        @SerializedName("ORDRE_LINIA") int ordreLinia
) {}