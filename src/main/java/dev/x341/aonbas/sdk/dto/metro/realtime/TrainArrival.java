package dev.x341.aonbas.sdk.dto.metro.realtime;

import com.google.gson.annotations.SerializedName;

public record TrainArrival(
        @SerializedName("codi_servei") String codiServei,
        @SerializedName("temps_arribada") long tempsArribada // Timestamp Epoch en millis
) {
    // Helper para saber los minutos restantes
    public long getMinutesLeft() {
        long now = System.currentTimeMillis();
        long diff = tempsArribada - now;
        return diff > 0 ? diff / 60000 : 0;
    }
}