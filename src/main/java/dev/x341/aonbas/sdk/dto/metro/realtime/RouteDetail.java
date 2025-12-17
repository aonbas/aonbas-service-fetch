package dev.x341.aonbas.sdk.dto.metro.realtime;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public record RouteDetail(
        @SerializedName("codi_linia") int codiLinia,
        @SerializedName("nom_linia") String nomLinia,
        @SerializedName("color_linia") String colorLinia,
        @SerializedName("codi_trajecte") String codiTrajecte,
        @SerializedName("desti_trajecte") String destiTrajecte,
        @SerializedName("propers_trens") List<TrainArrival> propersTrens
) {}