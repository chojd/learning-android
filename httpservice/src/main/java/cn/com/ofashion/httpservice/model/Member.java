package cn.com.ofashion.httpservice.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class Member {

    public static TypeAdapter<Member>typeAdapter(Gson gson) {
        return new AutoValue_Member.GsonTypeAdapter(gson);
    }

    @SerializedName("role")
    public abstract String role();

    @SerializedName("age")
    public abstract int age();

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
