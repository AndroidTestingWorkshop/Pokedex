package gojek.pokedex;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fixture {
    public static final String BASE_PATH = "src/test/resources/";
    private String fileToLoad;

    public Fixture(String pathOfFileToLoad) {
        this.fileToLoad = pathOfFileToLoad;
    }

    public String load() throws IOException {
        File file = new File(BASE_PATH, fileToLoad);
        FileReader fileReader = new FileReader(file);
        char[] characterBuffer = new char[(int) file.length()];
        fileReader.read(characterBuffer);
        return String.valueOf(characterBuffer);
    }

    public <T> List<T> loadList(Class<T[]> tClass) {
        InputStream resourcesJsonArrayStream = tClass.getClassLoader().getResourceAsStream(fileToLoad);
        InputStreamReader resourcesJsonArrayStreamReader = new InputStreamReader(resourcesJsonArrayStream);
        T[] resourcesJson = new Gson().fromJson(resourcesJsonArrayStreamReader, tClass);
        ArrayList<T> resourceList = new ArrayList<>();
        List<T> resources = Arrays.asList(resourcesJson);
        resourceList.addAll(resources);
        return resourceList;
    }
}