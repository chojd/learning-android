package chojd.com.autovalue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.io.IOException;

import static com.google.common.truth.Truth.assertThat;

public class UserEntityTest {

    private static final String sUid = "1234567";
    private static final String sNickname = "tester";
    private static final String sRealname = "Gene";

    @Test
    public void testBuilder() {

        UserEntity user = UserEntity.builder().uid(sUid).nickname(sNickname).build();
        assertThat(user).isNotNull();
        assertThat(user.realname()).isNull();
        assertThat(user.uid()).isEqualTo(sUid);
        assertThat(user.nickname()).isEqualTo(sNickname);

        UserEntity expectedUser = UserEntity.builder().uid(sUid).nickname(sNickname).build();
        assertThat(user).isEqualTo(expectedUser);
    }

    @Test(expected = IllegalStateException.class)
    public void testUidNullable() {
        UserEntity user = UserEntity.builder().nickname(sNickname).realname(sRealname).build();
        assertThat(user).isNotNull();
    }

    @Test(expected = IllegalStateException.class)
    public void testNicknameNullable() {
        UserEntity user = UserEntity.builder().uid(sUid).realname(sRealname).build();
        assertThat(user).isNotNull();
    }

    @Test
    public void testGsonAutoValue() throws IOException {
        String jsonStr = TestUtils.json("user.json", this);
        assertThat(jsonStr).isNotNull();
        UserEntity user = UserEntity.typeAdapter(defaultGson()).fromJson(jsonStr);
        assertThat(user).isNotNull();


        //这三句话可以被下面一句话代替。
        assertThat(user.uid()).isEqualTo(sUid);
        assertThat(user.nickname()).isEqualTo(sNickname);
        assertThat(user.realname()).isEqualTo(sRealname);

        //严格比较对象。
        assertThat(user).isEqualTo(UserEntity.builder().uid(sUid).nickname(sNickname).realname(sRealname).build());

    }

    private Gson defaultGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(BuyerboxAdapterFactory.create());
        builder.setPrettyPrinting();
        return builder.create();
    }

}