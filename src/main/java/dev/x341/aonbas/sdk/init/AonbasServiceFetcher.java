package dev.x341.aonbas.sdk.init;

import dev.x341.aonbas.sdk.config.TMBConfig;
import dev.x341.aonbas.sdk.services.TMBService;
import okhttp3.OkHttpClient;

public class AonbasServiceFetcher {
    TMBConfig config = new TMBConfig();
    OkHttpClient client = new OkHttpClient();

    TMBService tmbService = new TMBService(client, config);


    
}
