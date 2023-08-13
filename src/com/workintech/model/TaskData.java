package com.workintech.model;

import java.util.*;

public class TaskData {
    Set<Task> annsTasks = new  HashSet<>();
    Set<Task> bobsTasks = new  HashSet<>();
    Set<Task> carolsTasks = new  HashSet<>();

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks,
                    Set<Task> carolsTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
    }

    public Set<Task> getTasks(String taskOwner){
        if(taskOwner.equals("ann")){
            return annsTasks;
        }
        if(taskOwner.equals("bob")){
            return bobsTasks;
        }
        if(taskOwner.equals("carol")){
            return carolsTasks;
        }
        if(taskOwner.equals("all")){
            List<Set<Task>> taskList = new ArrayList<>();
            taskList.add(annsTasks);
            taskList.add(carolsTasks);
            taskList.add(bobsTasks);
            return getUnion(taskList);
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(List<Set<Task>> taskList){
        Set<Task> totals = new LinkedHashSet<>();
        for(Set<Task> tasks: taskList){
            totals.addAll(tasks);
        }
        return totals;

    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second){
        first.retainAll(second);
        //Set<Task> intersection = new HashSet<>(first);
        //intersection.retainAll(second);
        return first;
    }

    public Set<Task> getDifference(Set<Task> first, Set<Task> second){
        Set<Task> differences = new HashSet<>(first);
        differences.removeAll(second);
        return differences;
    }
}
