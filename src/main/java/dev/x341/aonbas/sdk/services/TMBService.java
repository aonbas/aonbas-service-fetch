package dev.x341.aonbas.sdk.services;

import com.google.gson.Gson;
import dev.x341.aonbas.sdk.config.TMBConfig;
import dev.x341.aonbas.sdk.dto.metro.realtime.MetroRealTimeResponse;
import dev.x341.aonbas.sdk.dto.metro.schedule.MetroScheduleResponse;
import dev.x341.aonbas.sdk.dto.metro.topology.line.MetroLinesResponse;
import dev.x341.aonbas.sdk.dto.metro.topology.station.MetroStationsResponse;
import dev.x341.aonbas.sdk.dto.metro.topology.station.interchange.MetroInterchangeTopology;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class TMBService {

    private static final String BASE_URL = "https://api.tmb.cat/v1";
    private final OkHttpClient client;
    private final TMBConfig config;
    private final Gson gson;

    public TMBService(OkHttpClient client, TMBConfig config) {
        this.client = client;
        this.config = config;
        this.gson = new Gson();
    }

    private <T> CompletableFuture<T> getAsync(String path, Class<T> classOfT) {
        HttpUrl url = HttpUrl.parse(BASE_URL + path).newBuilder()
                .addQueryParameter("app_id", config.getAppId())
                .addQueryParameter("app_key", config.getAppKey())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        CompletableFuture<T> future = new CompletableFuture<>();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                future.completeExceptionally(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody body = response.body()) {
                    if (!response.isSuccessful()) {
                        future.completeExceptionally(new IOException("Error TMB Api: " + response.code()));
                        return;
                    }
                    if (body == null) {
                        future.completeExceptionally(new IOException("Empty response body"));
                        return;
                    }

                    try {
                        String jsonString = body.string();
                        T result = gson.fromJson(jsonString, classOfT);
                        future.complete(result);
                    } catch (Exception e) {
                        future.completeExceptionally(new IOException("Error parsing JSON: " + e.getMessage()));
                    }
                }
            }
        });

        return future;
    }

    // ========================
    //       TOPOLOGY
    // ========================

    public CompletableFuture<MetroLinesResponse> getAllMetroLines() {
        return getAsync("/transit/linies/metro", MetroLinesResponse.class);
    }

    public CompletableFuture<MetroStationsResponse> getStationsByLine(int lineId) {
        return getAsync("/transit/linies/metro/" + lineId + "/estacions", MetroStationsResponse.class);
    }

    public CompletableFuture<MetroStationsResponse> getAllMetroStations() {
        return getAsync("/transit/linies/metro/estacions", MetroStationsResponse.class);
    }

    public CompletableFuture<MetroInterchangeTopology> getStationInterchanges(int lineId, int stationId) {
        String path = String.format("/transit/linies/metro/%d/estacions/%d/corresp", lineId, stationId);

        return getAsync(path, MetroInterchangeTopology.class);
    }

    // ========================
    //        REAL TIME
    // ========================

    public CompletableFuture<MetroRealTimeResponse> getStationRealTime(int stationCode) {
        return getAsync("/itransit/metro/estacions?estacions=" + stationCode, MetroRealTimeResponse.class);
    }

    // ========================
    //        SCHEDULE
    // ========================

    public CompletableFuture<MetroScheduleResponse> getLineSchedule(int lineId) {
        String path = String.format("/transit/linies/metro/%d/horaris", lineId);
        return getAsync(path, MetroScheduleResponse.class);
    }

}