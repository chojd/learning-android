package chojd.com.autovalue;

import com.google.auto.value.AutoValue;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class GoodsEntity {

    public abstract String gid();

    public abstract String name();

    @SerializedName("seller")
    public abstract UserEntity owner();

    public static Builder builder() {
        return new AutoValue_GoodsEntity.Builder();
    }

    public static TypeAdapter<GoodsEntity> typeAdapter(Gson gson) {
        return new AutoValue_GoodsEntity.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder gid(String gid);

        public abstract Builder name(String name);

        public abstract Builder owner(UserEntity owner);

        public abstract GoodsEntity build();
    }
}
