package chojd.com.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

@AutoValue
public abstract class ACEntity {
    public static Builder builder() {
        return new AutoValue_ACEntity.Builder();
    }

    public static TypeAdapter<ACEntity> typeAdapter(Gson gson) {
        return new AutoValue_ACEntity.GsonTypeAdapter(gson);
    }

    public abstract boolean read();

    public abstract boolean write();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder read(boolean read);

        public abstract Builder write(boolean write);

        public abstract ACEntity build();
    }
}
