package com.workintech.main;

import com.workintech.enums.Priority;
import com.workintech.enums.Status;
import com.workintech.model.Task;
import com.workintech.model.TaskData;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task task1 = new Task("Java Collections", "Write List",
                "Ann", Priority.LOW, Status.ASSIGNED);
        Task task2 = new Task("Java Collections", "Write Set",
                "Bob", Priority.LOW, Status.ASSIGNED);
        Task task3 = new Task("Java Collections", "Write LinkedList",
                "Carol", Priority.LOW, Status.ASSIGNED);
        Task task4 = new Task("Java Collections", "Write Map",
                "Bob", Priority.LOW, Status.ASSIGNED);
        Task task5 = new Task("Java Collections", "Write ArrayList",
                "Ann", Priority.LOW, Status.ASSIGNED);
        Task task6 = new Task("Java Collections", "Write List in Set",
                "", Priority.MED, Status.IN_QUEUE);
        Task task7 = new Task("Java Collections", "Write ArrayList",
                "Bob", Priority.MED, Status.IN_QUEUE);
        Task task8 = new Task("Java Collections", "Write Map",
                "Ann", Priority.HIGH, Status.IN_PROGRESS);

        Set<Task> totalTasks = new HashSet<>();
        totalTasks.add(task1);
        totalTasks.add(task2);
        totalTasks.add(task3);
        totalTasks.add(task4);
        totalTasks.add(task5);
        totalTasks.add(task6);

        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(task1);
        annsTask.add(task5);

        Set<Task> bobsTask = new LinkedHashSet<>();
        bobsTask.add(task2);
        bobsTask.add(task4);

        Set<Task> carolsTask = new LinkedHashSet<>();
        carolsTask.add(task3);
        carolsTask.add(task7);
        carolsTask.add(task8);


        TaskData taskData = new TaskData(annsTask, bobsTask, carolsTask);
//        List<Set<Task>> tasks = new ArrayList<>();
//        tasks.add(annsTask);
//        tasks.add(bobsTask);
//        tasks.add(carolsTask);
//        System.out.println(taskData.getUnion(tasks));


        System.out.println("All tasks: ");
        System.out.println(taskData.getTasks("all"));

        System.out.println("***********************");

        System.out.println("Ann's task: ");
        System.out.println(taskData.getTasks("ann"));
        System.out.println("***********************");

        System.out.println("Bob's task: ");
        System.out.println(taskData.getTasks("bob"));
        System.out.println("***********************");

        System.out.println("Carol's task: ");
        System.out.println(taskData.getTasks("carol"));
        System.out.println("***********************");


        System.out.println(taskData.getDifference(totalTasks, taskData.getTasks("all")));

        System.out.println("***********************");

        System.out.println("Ann+Carol: " + taskData.getIntersection(annsTask, carolsTask));
        System.out.println("Bob+Carol: " + taskData.getIntersection(bobsTask, carolsTask));
        System.out.println("Ann+Bob: " + taskData.getIntersection(annsTask, bobsTask));

    }

}