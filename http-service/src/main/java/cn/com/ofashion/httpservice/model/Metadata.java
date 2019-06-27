package cn.com.ofashion.httpservice.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

@AutoValue
public abstract class Metadata  {

    public static TypeAdapter<Metadata>typeAdapter(Gson gson) {
        return new AutoValue_Metadata.GsonTypeAdapter(gson);
    }

    @SerializedName("code")
    public abstract int code();

    @SerializedName("data")
    public abstract Map data();

    @SerializedName("message")
    public abstract String message();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder code(int code);

        public abstract Builder data(Map data);

        public abstract Builder message(String message);

        public abstract Metadata build();
    }
}
