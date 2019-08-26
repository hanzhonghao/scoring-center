package com.huaxi.scoring.center.util;

import com.huaxi.scoring.center.domain.Project;

import java.util.*;

public class ListUtil {
    public static List<Project> randomProjectName(List<Project> projects){
        Collections.shuffle(projects);
        return projects;
    }

    public static List<Project> getFirstFiveData(List<Project> projects) {
        List<Project> firstList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            firstList.add(projects.get(i));
        }
        return firstList;
    }

    public static List<Project> getEndFiveData(List<Project> projects){
        List<Project> endFirst = new ArrayList();
        for (int i = 5; i < projects.size(); i++) {
            endFirst.add(projects.get(i));
        }
        return endFirst;
    }

}
