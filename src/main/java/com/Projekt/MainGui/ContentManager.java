package com.Projekt.MainGui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Objects;

public class ContentManager {
     public static boolean isTutorial = false;
     public static String currLanguage = "czech";

    public static Parent switchContent(String fileName){
        Map<String, Object> data = loadLanguageYaml(currLanguage);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContentManager.class.getResource(fileName + ".fxml"));
        loader.getNamespace().putAll(data);
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(Objects.equals(fileName, "Uceni") || Objects.equals(fileName, "")){// TODO v budoucnu bude druhá podmínka nastavení
            // bruh yapom2l jsem co sem tu cht2l ud2lat
        }
        return root;
    }

    public static Map<String, Object> loadLanguageYaml(String language){
        InputStream inputStream = null;
        inputStream = (ContentManager.class.getResourceAsStream("Languages/"+language + ".yml"));
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        return data;
    }
}
