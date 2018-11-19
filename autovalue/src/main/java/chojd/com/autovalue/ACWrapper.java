package chojd.com.autovalue;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

//              "ACL": {
//                  "ctn1Zeov9d": {
//                  "read": true,
//                  "write": true
//              },

@AutoValue
public abstract class ACWrapper {
    public abstract String uid();
    public abstract ACEntity ac();

    public static TypeAdapter<ACWrapper> typeAdapter(Gson gson) {
        return new AutoValue_ACWrapper.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_ACWrapper.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder uid(String uid);

        public abstract Builder ac(ACEntity ac);

        public abstract ACWrapper build();
    }
}
