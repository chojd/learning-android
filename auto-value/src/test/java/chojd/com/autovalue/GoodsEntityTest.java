package chojd.com.autovalue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class GoodsEntityTest {

    private static final String sGid = "goodsid";
    private static final String sName = "goods name";
    private static final String sOwnerID = "1234567";
    private static final String sOwnerNickname = "tester";

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBuilder() {
        UserEntity user = UserEntity.builder().uid(sOwnerID).nickname(sOwnerNickname).build();
        assertThat(user).isNotNull();
        GoodsEntity goods = GoodsEntity.builder().gid(sGid).name(sName).owner(user).build();
        assertThat(goods).isNotNull();
        assertThat(goods.gid()).isEqualTo(sGid);
        assertThat(goods.name()).isEqualTo(sName);
    }

    @Test
    public void testGsonAutoValue() throws IOException {
        String jsonStr = TestUtils.json("goods.json", this);
        assertThat(jsonStr).isNotNull();
        GoodsEntity goods = GoodsEntity.typeAdapter(defaultGson()).fromJson(jsonStr);
        assertThat(goods).isNotNull();
        //如果你需要比较整个对象里的所有字段，干脆久直接去比较这个对象。
        //
        assertThat(goods.gid()).isEqualTo(sGid);
        assertThat(goods.name()).isEqualTo(sName);
        assertThat(goods.owner()).isNotNull();
        assertThat(goods.owner().uid()).isEqualTo(sOwnerID);
        assertThat(goods.owner().nickname()).isEqualTo(sOwnerNickname);
    }

    private Gson defaultGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(BuyerboxAdapterFactory.create());
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson;
    }

}