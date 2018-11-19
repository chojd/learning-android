package chojd.com.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import javax.annotation.Nullable;

@AutoValue
public abstract class UserEntity {

    public abstract String uid();

    public abstract String nickname();

    @Nullable
    public abstract String realname();

    public static Builder builder() {
        return new AutoValue_UserEntity.Builder();
    }

    public static TypeAdapter<UserEntity> typeAdapter(Gson gson) {
        return new AutoValue_UserEntity.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder uid(String uid);

        public abstract Builder nickname(String nickname);

        public abstract Builder realname(String realname);

        public abstract UserEntity build();
    }
}
