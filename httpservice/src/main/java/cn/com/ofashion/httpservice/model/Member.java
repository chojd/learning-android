package cn.com.ofashion.httpservice.model;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Member {

    public static TypeAdapter<Member>typeAdapter(Gson gson) {
        return new AutoValue_Member.GsonTypeAdapter(gson);
    }

    @NonNull
    @SerializedName("role")
    public abstract String role();

    @NonNull
    @SerializedName("age")
    public abstract int age();

    @NonNull
    @SerializedName("name")
    public abstract String name();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder role(String role);

        public abstract Builder age(int age);

        public abstract Builder name(String name);

        public abstract Member build();
    }
}
