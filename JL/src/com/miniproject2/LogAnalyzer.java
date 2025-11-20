package com.MiniProject2;
import java.util.*;
import java.util.concurrent.*;

public class LogAnalyzer {

    private ExecutorService threadPool;
    private ConcurrentHashMap<String, Integer> combinedMap;

    public LogAnalyzer(int poolSize) {
        threadPool = Executors.newFixedThreadPool(poolSize);
        combinedMap = new ConcurrentHashMap<>();
    }

    public void analyze(List<List<String>> allLogs) throws Exception {

        long beginTime = System.currentTimeMillis();

        List<Future<Map<String, Integer>>> futureResults = new ArrayList<>();

        for (List<String> singleLog : allLogs) {
            LogProcessor worker = new LogProcessor(singleLog);
            futureResults.add(threadPool.submit(worker));
        }

        for (Future<Map<String, Integer>> res : futureResults) {
            Map<String, Integer> tempMap = res.get();

            tempMap.forEach((key, val) ->
                    combinedMap.merge(key, val, Integer::sum));
        }

        long finishTime = System.currentTimeMillis();

        System.out.println("\n=== FINAL RESULT ===");
        System.out.println("Execution Time: " + (finishTime - beginTime) + " ms");
        System.out.println("Keyword Counts: " + combinedMap);

        threadPool.shutdown();
    }
}
