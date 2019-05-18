package chojd.com.retrofit;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class ConfigEntity {

    public static Builder builder() {
        return new AutoValue_ConfigEntity.Builder();
    }

    public static TypeAdapter<ConfigEntity> typeAdapter(Gson gson) {
        return new AutoValue_ConfigEntity.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder forcedUrl(String forcedUrl);

        public abstract Builder forced(String forced);

        public abstract Builder log_switch(LogConfigEntity log_switch);

        public abstract ConfigEntity build();
    }

    @SerializedName("forced_url")
    public abstract String forcedUrl();
    public abstract String forced();

    @SerializedName("log_switch")
    public abstract LogConfigEntity log_switch();
}
