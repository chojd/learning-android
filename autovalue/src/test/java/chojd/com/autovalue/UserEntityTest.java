package chojd.com.autovalue;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class UserEntityTest {

    private static final String sUid = "1234567";
    private static final String sNickname = "tester";
    private static final String sRealname = "Gene";

    @Test
    public void testBuilder () {

        UserEntity user = UserEntity.builder().uid(sUid).nickname(sNickname).build();
        Truth.assertThat(user).isNotNull();
        Truth.assertThat(user.realname()).isNull();
        Truth.assertThat(user.uid()).isEqualTo(sUid);
        Truth.assertThat(user.nickname()).isEqualTo(sNickname);

        UserEntity expectedUser = UserEntity.builder().uid(sUid).nickname(sNickname).build();
        Truth.assertThat(user).isEqualTo(expectedUser);
    }

    @Test(expected = IllegalStateException.class)
    public void testUidNullable() {
        UserEntity user = UserEntity.builder().nickname(sNickname).realname(sRealname).build();
        Truth.assertThat(user).isNotNull();
    }

    @Test(expected = IllegalStateException.class)
    public void testNicknameNullable() {
        UserEntity user = UserEntity.builder().uid(sUid).realname(sRealname).build();
        Truth.assertThat(user).isNotNull();
    }

    @Test
    public void testGsonAutoValue() throws IOException {
        String jsonStr = TestUtils.json("user.json", this);
        Truth.assertThat(jsonStr).isNotNull();
        UserEntity user = UserEntity.typeAdapter(defaultGson()).fromJson(jsonStr);
        Truth.assertThat(user).isNotNull();
        Truth.assertThat(user.uid()).isEqualTo(sUid);
        Truth.assertThat(user.nickname()).isEqualTo(sNickname);
        Truth.assertThat(user.realname()).isEqualTo(sRealname);
    }

    private Gson defaultGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapterFactory(BuyerboxAdapterFactory.create());
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson;
    }

}