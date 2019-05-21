package cn.com.ofashion.cleanarchitecture.model;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Student {

    public static TypeAdapter<Student>typeAdapter(Gson gson) {
        return new AutoValue_Student.GsonTypeAdapter(gson);
    }

    @NonNull
    @SerializedName("name")
    public abstract String name();

    @NonNull
    @SerializedName("age")
    public abstract int age();

    public static Builder builder() {
        return new AutoValue_Student.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder age(int age);

        public abstract Student build();
    }
}
