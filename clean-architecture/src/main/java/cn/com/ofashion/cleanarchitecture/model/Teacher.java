package cn.com.ofashion.cleanarchitecture.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import io.reactivex.annotations.NonNull;

@AutoValue
public abstract class Teacher {

    public static TypeAdapter<Teacher>typeAdapter(Gson gson) {
        return new AutoValue_Teacher.GsonTypeAdapter(gson);
    }

    @NonNull
    @SerializedName("name")
    public abstract String name();

    @NonNull
    @SerializedName("age")
    public abstract int age();

    public static Builder builder() {
        return new AutoValue_Teacher.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder age(int age);

        public abstract Teacher build();
    }
}
