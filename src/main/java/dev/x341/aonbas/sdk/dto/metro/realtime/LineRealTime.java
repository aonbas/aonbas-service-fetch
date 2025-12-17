package dev.x341.aonbas.sdk.dto.metro.realtime;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record LineRealTime(
        @SerializedName("codi_linia") int codiLinia,
        @SerializedName("nom_linia") String nomLinia,
        @SerializedName("nom_familia") String nomFamilia,
        @SerializedName("codi_familia") int codiFamilia,
        @SerializedName("color_linia") String colorLinia,
        List<StationSlot> estacions
) {
}
