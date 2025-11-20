Multi-Threaded Log File Analyzer (Java Concurrency)

This Java mini-project demonstrates the use of multithreading, thread pools, Callable tasks, Future results, and ConcurrentHashMap to analyze multiple log files simultaneously.
It highlights how parallel computation improves performance compared to sequential processing.

🚀 Features

✔ Analyze multiple log files concurrently
✔ Each log is processed by a separate worker thread
✔ Uses ExecutorService (fixed thread pool)
✔ Worker uses Callable to return keyword counts
✔ Combines results using ConcurrentHashMap (thread-safe)
✔ Measures total execution time
✔ Prints aggregated keyword counts
✔ Easily extendable to real log files

🏗️ Class Structure
1. LogProcessor.java

Represents the worker task (individual thread) that processes a single log file.

Responsibilities

Implements Callable<Map<String, Integer>>

Reads log entries

Counts keywords (error, success, load, etc.)

Returns a map containing keyword counts

Key Method

call() → Processes logs and returns keyword count map

2. LogAnalyzer.java

Coordinates multithreading and merges the results of all worker threads.

Responsibilities

Creates a thread pool using Executors.newFixedThreadPool()

Submits each file to a LogProcessor

Collects results using Future

Merges results into a ConcurrentHashMap

Calculates total execution time

Shuts down the thread pool

Data Structures

ExecutorService threadPool

ConcurrentHashMap<String, Integer> combinedMap

Key Method

analyzeLogs(List<List<String>> allLogs) → Runs tasks and merges results

3. MainDemo.java

The main driver class for the project.

Responsibilities

Provides sample or real log data

Defines the number of worker threads

Calls LogAnalyzer

Displays:

Per-thread completion messages

Final aggregated keyword counts

Total processing time

🧠 Concurrency Strategy (Simple Explanation)
Thread Pool (ExecutorService)

Creates a fixed number of reusable worker threads to efficiently process multiple logs.

Callable Tasks

Unlike Runnable, a Callable can return values, allowing each worker to return its keyword count map.

Future Objects

Hold the results returned by each worker thread.

ConcurrentHashMap

Used to safely merge keyword results from all threads without race conditions.

🖥️ Example Output
Processing logs with 3 threads...
pool-1-thread-1 processed Log 1
pool-1-thread-2 processed Log 2
pool-1-thread-3 processed Log 3

Aggregated Keyword Counts:
{error=3, load=2, success=1}

Total Execution Time: 14 ms

📄 How to Compile & Run
Compile:
javac LogProcessor.java LogAnalyzer.java MainDemo.java

Run:
java MainDemo

📁 Suggested Folder Structure
/MultiThreadedLogAnalyzer
│
├── LogProcessor.java
├── LogAnalyzer.java
├── MainDemo.java
└── README.md

✅ Submission Deliverables

Full source code

Execution screenshot

README.md (this file)

Optional: performance comparison (sequential vs multithreaded)