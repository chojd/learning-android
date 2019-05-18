package chojd.com.retrofit;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestUtils {

    private static File file(String fileName, Object obj) {
        ClassLoader classLoader = obj.getClass().getClassLoader();
        assert classLoader != null;
        URL resource = classLoader.getResource(fileName);
        assert resource != null;
        return new File(resource.getPath());
    }

    public static String json(String filePath, Object obj) {
        try {
            return FileUtils.readFileToString(file(filePath, obj), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String content(String filePath, Object obj) {
        return json(filePath, obj);
    }
}
