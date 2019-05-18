package chojd.com.retrofit;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class LogConfigEntity {
    @SerializedName("is_hot_report")
    public abstract boolean isHotRepoet();
    @SerializedName("is_backend_report")
    public abstract boolean isBackendReport();
    @SerializedName("is_mobile_network_report")
    public abstract boolean isMobileNetworkReport();
    @SerializedName("is_cold_report")
    public abstract boolean isColdReport();
    @SerializedName("")
    public abstract boolean isRunloopReport();
    @SerializedName("is_page_change_report")
    public abstract boolean isPageChangeReport();

    public static Builder builder() {
        return new AutoValue_LogConfigEntity.Builder();
    }

    public static TypeAdapter<LogConfigEntity> typeAdapter(Gson gson) {
        return new AutoValue_LogConfigEntity.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder setHotRepoet(boolean newHotRepoet);

        public abstract Builder setBackendReport(boolean newBackendReport);

        public abstract Builder setMobileNetworkReport(boolean newMobileNetworkReport);

        public abstract Builder setColdReport(boolean newColdReport);

        public abstract Builder setRunloopReport(boolean newRunloopReport);

        public abstract Builder setPageChangeReport(boolean newPageChangeReport);

        public abstract LogConfigEntity build();
    }
}
