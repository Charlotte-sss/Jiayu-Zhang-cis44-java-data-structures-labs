+--------------------------------+
|           Task                 |
+--------------------------------+
| - description: String          |
| - priority: int                |
+--------------------------------+
| + getDescription(): String     |
| + getPriority(): int           |
| + compareTo(Task): int         |
+--------------------------------+


+--------------------------------+
|       TaskScheduler            |
+--------------------------------+
| - heap: ArrayList<Task>        |
+--------------------------------+
| + addTask(description,prio)    |
| + getNextTask(): Task          |
| + isEmpty(): boolean           |
| - upheap(index): void          |
| - downheap(index): void        |
+--------------------------------+


+--------------------------------+
|             Main               |
+--------------------------------+
| + main(String[]): void         |
+--------------------------------+

This project implements a Task Scheduler using a Min-Heap Priority Queue.
Each task has a description and a numerical priority value, where a lower number means higher priority.
The scheduler allows inserting tasks and automatically retrieving the next task based on priority.

insert (addTask):
Inserts at the bottom + upheap → O(log n)
Guaranteed by the tree height being log n.

removeMin (getNextTask):
Swap root with last element + downheap → O(log n)

Space Complexity:
The heap stores all tasks → O(n)

Unsorted List: insert = O(1), removeMin = O(n)
Sorted List: insert = O(n), removeMin = O(1)
