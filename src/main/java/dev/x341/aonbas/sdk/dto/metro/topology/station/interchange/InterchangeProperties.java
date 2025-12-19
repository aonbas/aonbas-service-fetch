package dev.x341.aonbas.sdk.dto.metro.topology.station.interchange;

import com.google.gson.annotations.SerializedName;

public record InterchangeProperties(
        @SerializedName("ID_ESTACIO") int idEstacio,
        @SerializedName("CODI_ESTACIO") int codiEstacio,      // Ej: 321

        @SerializedName("ID_LINIA") int idLinia,
        @SerializedName("CODI_LINIA") int codiLinia,          // Ej: 5 (para R5), 1 (para L1)
        @SerializedName("NOM_LINIA") String nomLinia,         // Ej: "R5", "L1", "H12"
        @SerializedName("DESC_LINIA") String descLinia,// Ej: "Barcelona Pl. Espanya - Manresa"

        @SerializedName("NOM_OPERADOR") String nomOperador,   // Ej: "FGC", "Metro", "TB" (Bus)
        @SerializedName("CODI_FAMILIA") int codiFamilia,      // Útil para filtrar (1=Metro, etc)

        @SerializedName("COLOR_LINIA") String colorLinia,     // Ej: "3dbfc3"
        @SerializedName("COLOR_TEXT_LINIA") String colorTextLinia,

        @SerializedName("NOM_ELEMENT_CORRESP") String nomElementCorresp // Ej: "Pl. Espanya"
) {}