package com.Projekt.MainGui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;
import java.util.Objects;

public class ContentManager {
     public static File file;
     public static boolean isTutorial = false;
     public static String currLanguage = "czech";

    public static Parent switchContent(String fileName){
        System.out.println(currLanguage);
        Map<String, Object> data = loadLanguageYaml(currLanguage);
        System.out.println(data);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ContentManager.class.getResource(fileName + ".fxml"));
        loader.getNamespace().putAll(data);
        Parent root;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(root.getStylesheets());

        if(Objects.equals(fileName, "Uceni") || Objects.equals(fileName, "")){// TODO v budoucnu bude druhá podmínka nastavení
            // bruh yapom2l jsem co sem tu cht2l ud2lat
        }
        return root;
    }

    public static Map<String, Object> loadLanguageYaml(String language){
        file = new File(ContentManager.class.getResource("Languages/"+language + ".yml").getFile());
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(inputStream);
        return data;
    }



}
