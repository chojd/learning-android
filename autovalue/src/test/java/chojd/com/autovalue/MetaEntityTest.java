package chojd.com.autovalue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class MetaEntityTest {

    private static final String sStatus = "success";
    private static final int sCode = 0;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBuilder() {
        MetaEntity meta = MetaEntity.builder().status(sStatus).code(sCode).build();
        assertThat(meta).isNotNull();
        assertThat(meta.status()).isEqualTo(sStatus);
        assertThat(meta.code()).isEqualTo(sCode);
        assertThat(meta.items()).isNull();
    }

    @Test
    public void testGsonAutoValue() throws IOException {
        String jsonStr = TestUtils.json("timeline.json", this);
        assertThat(jsonStr).isNotNull();
        MetaEntity meta = MetaEntity.typeAdapter(aclGson()).fromJson(jsonStr);
        assertThat(meta).isNotNull();
        assertThat(meta.status()).isEqualTo(sStatus);
        assertThat(meta.code()).isEqualTo(sCode);
    }

    @Test
    public void testDeserializer() throws IOException {
        String jsonStr = TestUtils.json("timeline.json", this);
        assertThat(jsonStr).isNotNull();
        MetaEntity meta = MetaEntity.typeAdapter(aclGson()).fromJson(jsonStr);
        String resultJsonStr = aclGson().toJson(meta).toString();
        assertThat(resultJsonStr).isEqualTo(jsonStr);
    }

    private Gson aclGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(BuyerboxAdapterFactory.create());
        builder.setPrettyPrinting();
        builder.registerTypeAdapter(ACLWrapper.class, new ACLJSONSerialization(baseGson()));
        return builder.create();
    }

    private Gson baseGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(BuyerboxAdapterFactory.create());
        builder.setPrettyPrinting();
        return builder.create();
    }
}