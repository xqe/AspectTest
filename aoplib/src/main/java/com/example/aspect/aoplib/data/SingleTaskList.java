package com.example.aspect.aoplib.data;

import java.util.ArrayList;
import java.util.List;
/**singleTask模式的集合，用于去除重复trace*/
public class SingleTaskList {
    private List<String> traceList;

    public SingleTaskList() {
        traceList = new ArrayList<>();
    }

    public void add(String element) {
        if (traceList.contains(element)) {
            //删除index 及index之后的元素
            int index = traceList.indexOf(element);
            List<String> deleteList = new ArrayList<>();
            for (int i = index; i < traceList.size(); i++) {
                deleteList.add(traceList.get(i));
            }
            traceList.removeAll(deleteList);
        }
    }

    public void remove(String element) {
        traceList.remove(element);
    }

    public void toTrace() {

    }


}
