package cn.com.ofashion.cleanarchitecture.model;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Dashboard {

    public static TypeAdapter<Dashboard>typeAdapter(Gson gson) {
        return new AutoValue_Dashboard.GsonTypeAdapter(gson);
    }

    @NonNull
    @SerializedName("teacher")
    public abstract Teacher teacher();

    @NonNull
    @SerializedName("student")
    public abstract Student student();

    public static Builder builder() {
        return new AutoValue_Dashboard.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder teacher(Teacher teacher);

        public abstract Builder student(Student student);

        public abstract Dashboard build();
    }
}
