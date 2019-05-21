package cn.com.ofashion.httpservice;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

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

    @NonNull
    @SerializedName("code")
    public abstract int code();

    @Nullable
    @SerializedName("data")
    public abstract Map data();

    @NonNull
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
