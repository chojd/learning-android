package chojd.com.autovalue;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GoodsEntityTest {

    private static final String sGid = "goodsid";
    private static final String sName = "goods name";
    private static final String sOwnerID = "1234567";
    private static final String sOwnerNickname = "tester";

    @Before
        public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testBuilder() {
        UserEntity user = UserEntity.builder().uid(sOwnerID).nickname(sOwnerNickname).build();
        Truth.assertThat(user).isNotNull();
        GoodsEntity goods = GoodsEntity.builder().gid(sGid).name(sName).owner(user).build();
        Truth.assertThat(goods).isNotNull();
        Truth.assertThat(goods.gid()).isEqualTo(sGid);
        Truth.assertThat(goods.name()).isEqualTo(sName);
    }

    @Test
    public void testGsonAutoValue() throws IOException {
        String jsonStr = TestUtils.json("goods.json", this);
        Truth.assertThat(jsonStr).isNotNull();
        GoodsEntity goods = GoodsEntity.typeAdapter(defaultGson()).fromJson(jsonStr);
        Truth.assertThat(goods).isNotNull();
        Truth.assertThat(goods.gid()).isEqualTo(sGid);
        Truth.assertThat(goods.name()).isEqualTo(sName);
        Truth.assertThat(goods.owner()).isNotNull();
        Truth.assertThat(goods.owner().uid()).isEqualTo(sOwnerID);
        Truth.assertThat(goods.owner().nickname()).isEqualTo(sOwnerNickname);
    }

    private Gson defaultGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(BuyerboxAdapterFactory.create());
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson;
    }

}