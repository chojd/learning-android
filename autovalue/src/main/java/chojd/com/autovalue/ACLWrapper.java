package chojd.com.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.util.List;

import javax.annotation.Nullable;

@AutoValue
public abstract class ACLWrapper {
    public static TypeAdapter<ACLWrapper> typeAdapter(Gson gson) {
        return new AutoValue_ACLWrapper.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_ACLWrapper.Builder();
    }

    @Nullable
    public abstract List<ACWrapper> acList();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder acList(List<ACWrapper> acList);

        public abstract ACLWrapper build();
    }
}
