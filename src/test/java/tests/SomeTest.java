package tests;

import org.junit.Before;

import org.junit.Test;
import pages.LoginPage;

import java.util.List;

import static helpers.FileHelper.readLinesFromFile;
import static helpers.FileHelper.writeTextToFile;

public class SomeTest {

    @Test
    public void checkFile() {
        /*
        List<String> data = readLinesFromFile("D:\\Projects\\GitHubTestProject\\src\\test\\resources\\log4j2.properties");
        for (String line : data) {
            System.out.println(line.replaceAll("\n", ""));//заменяем абзац

         */

        writeTextToFile("D:\\Projects\\GitHubTestProject\\src\\test\\resources\\Data\\out.txt",
        "First line\nSecond line\nThird line");
        }
    }




