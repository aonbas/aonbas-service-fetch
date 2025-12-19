package dev.x341.aonbas.sdk.config;

import io.github.cdimascio.dotenv.Dotenv;

public class TMBConfig {
    private final String appId;
    private final String appKey;

    public TMBConfig() {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        this.appId = System.getenv("TMB_APP_ID") != null ? System.getenv("TMB_APP_ID") : dotenv.get("TMB_APP_ID");
        this.appKey = System.getenv("TMB_APP_KEY") != null ? System.getenv("TMB_APP_KEY") : dotenv.get("TMB_APP_KEY");

        validate();
    }

    public TMBConfig(String appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
        validate();
    }

    private void validate() {
        if (appId == null || appKey == null) {
            throw new IllegalStateException("❌ Faltan credenciales TMB_APP_ID o TMB_APP_KEY");
        }
    }

    public String getAppId() { return appId; }
    public String getAppKey() { return appKey; }
}