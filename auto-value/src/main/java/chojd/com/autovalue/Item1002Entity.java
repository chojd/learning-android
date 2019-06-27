package chojd.com.autovalue;


import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Nullable;

//              "type": 1002,
//              "content": "I am 1002 content",
//              "ACL": {
//                  "ctn1Zeov9d": {
//                  "read": true,
//                  "write": true
//                  },
//                  "zn1xx1ov8d": {
//                  "read": true,
//                  "write": false
//                  }
//              }

@AutoValue
public abstract class Item1002Entity {
    public static TypeAdapter<Item1002Entity> typeAdapter(Gson gson) {
        return new AutoValue_Item1002Entity.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_Item1002Entity.Builder();
    }

    public abstract int type();

    public abstract String content();

    @Nullable
    @SerializedName("ACL")
    public abstract ACLWrapper acl();

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder type(int type);

        public abstract Builder content(String content);

        public abstract Builder acl(ACLWrapper acl);

        public abstract Item1002Entity build();
    }
}
