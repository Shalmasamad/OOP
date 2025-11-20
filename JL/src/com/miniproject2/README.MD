Mini-Project: Multi-Threaded Log File Analyzer (Java Concurrency)

This mini-project demonstrates the use of Java Concurrency, including Thread Pools, Callable tasks, Future results, and ConcurrentHashMap, to analyze multiple log files at the same time. It shows how multithreading improves performance compared to sequential execution by using parallel threads for analyzing logs and safely combining results.

Features

Analyze multiple log files concurrently

Each log file is processed by a separate worker thread

Uses ExecutorService with a fixed thread pool

Uses Callable to return per-file keyword counts

Aggregates results using ConcurrentHashMap (thread-safe)

Measures total execution time

Displays final summary of keyword counts

Supports easy extension for real log files

Class Structure
1. LogProcessor.java

Represents the worker task (thread) that processes an individual log file.

Responsibilities:

Implements Callable<Map<String, Integer>>

Reads a list of log entries

Counts keywords such as error, success, load

Returns a map containing keyword counts for that log

Key Methods:

call() → Processes logs and returns keyword count map

2. LogAnalyzer.java

Manages multithreading and combines results from all worker threads.

Responsibilities:

Creates a thread pool using Executors.newFixedThreadPool()

Submits each log file to a LogProcessor worker

Collects results using Future

Merges all results into a ConcurrentHashMap

Calculates total execution time

Shuts down the executor after all logs are processed

Data Structures:

ExecutorService threadPool

ConcurrentHashMap<String, Integer> combinedMap

Key Methods:

analyzeLogs(List<List<String>> allLogs) → Executes all workers and merges results

3. MainDemo.java

Main driver class for the project.

Responsibilities:

Creates sample log data (or can be modified to load real logs)

Defines number of worker threads

Calls LogAnalyzer to start processing

Displays:

Aggregated keyword counts

Total processing time

Program Output Includes:

Processing messages from worker threads

Merged final keyword count

Execution time in milliseconds

Concurrency Strategy (Simple Explanation)
Thread Pool (ExecutorService)

A fixed number of threads are reused to process multiple logs efficiently.

Callable Tasks

Used instead of Runnable so each worker can return a result map.

Future Objects

Allow retrieving results from each thread after computation.

ConcurrentHashMap

Used for safe and efficient merging of results without data corruption.

Example Output
Processing logs with 3 threads...
Thread pool-1-thread-1 processed Log 1
Thread pool-1-thread-2 processed Log 2
Thread pool-1-thread-3 processed Log 3

Aggregated Keyword Counts:
{error=3, load=2, success=1}

Total Execution Time: 14 ms