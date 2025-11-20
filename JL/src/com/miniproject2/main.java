package com.MiniProject2;
import java.util.*;
public class Main {

    public static void main(String[] args) throws Exception {

        List<String> fileA = Arrays.asList(
                "Error occurred in module",
                "Module failed to load"
        );

        List<String> fileB = Arrays.asList(
                "User login success",
                "User loaded dashboard"
        );

        List<String> fileC = Arrays.asList(
                "Network error detected",
                "Retry connection error"
        );

        List<List<String>> dataset = Arrays.asList(fileA, fileB, fileC);

        LogAnalyzer analyzerTool = new LogAnalyzer(3);

        analyzerTool.analyze(dataset);
    }
}
