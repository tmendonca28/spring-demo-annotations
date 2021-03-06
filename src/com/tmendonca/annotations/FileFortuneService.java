package com.tmendonca.annotations;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

@Component
public class FileFortuneService implements FortuneService{
    String chosenFortune;
    @Override
    public String getFortune() {
        try {
            String content = new Scanner(new File("src/fortunes.txt")).useDelimiter("\\Z").next();
            String[] fortuneArray = content.split("\\.");
            Random myRandom = new Random();
            int index = myRandom.nextInt(fortuneArray.length);
            chosenFortune = fortuneArray[index];

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
        return chosenFortune;
    }

    @PostConstruct
    public void startupFileFortuneService() {
        System.out.println("On startup I am called");
    }

    @PreDestroy
    public void destroyFileFortuneService() {
        System.out.println("On destroy I am called");
    }
}
