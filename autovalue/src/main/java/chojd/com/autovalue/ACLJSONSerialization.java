package chojd.com.autovalue;

import android.util.ArrayMap;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//        {
//            "ctn1Zeov9d":{"read":true,"write":true},
//            "zn1xx1ov8d":{"read":true,"write":false}
//        }

public class ACLJSONSerialization implements JsonDeserializer<ACLWrapper>, JsonSerializer<ACLWrapper> {
    private final Gson baseGson;

    public ACLJSONSerialization(Gson baseGson) {
        this.baseGson = baseGson;
    }

    @Override
    public ACLWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx) throws JsonParseException {

        JsonObject obj = json.getAsJsonObject();
        Set<String> strings = obj.keySet();
        int size = strings.size();
        if (size == 0) {
            return null;
        }

        ArrayList<ACWrapper> acl = new ArrayList<>(strings.size());

        for (String userId : strings) {
            JsonElement jsonElement = obj.get(userId);
            String permissionJson = jsonElement.toString();//{"read":true,"write":false}
            ACEntity ac = baseGson.fromJson(permissionJson, ACEntity.class);
            ACWrapper acWrapper = ACWrapper.builder().uid(userId).ac(ac).build();
            acl.add(acWrapper);
        }

        return ACLWrapper.builder().acList(acl).build();
    }

    @Override
    public JsonElement serialize(ACLWrapper src, Type typeOfSrc, JsonSerializationContext context) {
        if (src == null) {
            return null;
        }
        if (src.acList() == null) {
            return null;
        }
        if (src.acList().size() == 0) {
            return null;
        }

        ArrayMap<String, ArrayMap<String, Boolean>> result = new ArrayMap<>(src.acList().size());
        List<ACWrapper> list = src.acList();
        for (ACWrapper acWrapper : list) {
            if (acWrapper.uid() == null || acWrapper.ac() == null) {
                continue;
            }
            ArrayMap<String, Boolean> acMap = new ArrayMap<>(2);

            ACEntity ac = acWrapper.ac();

            acMap.put("read", ac.read());
            acMap.put("write", ac.write());
            result.put(acWrapper.uid(), acMap);
        }

        Gson gson = new Gson();
        return gson.toJsonTree(result);
    }
}
