package chojd.com.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.ArrayList;

import javax.annotation.Nullable;


@AutoValue
public abstract class MetaEntity {
    public static TypeAdapter<MetaEntity> typeAdapter(Gson gson) {
        return new AutoValue_MetaEntity.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_MetaEntity.Builder();
    }

    public abstract String status();

    public abstract int code();

    @Nullable
    public abstract ArrayList<Item1002Entity> items();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder status(String status);

        public abstract Builder code(int code);

        public abstract Builder items(ArrayList<Item1002Entity> items);

        public abstract MetaEntity build();
    }
}
