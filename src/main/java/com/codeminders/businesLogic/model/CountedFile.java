package com.codeminders.businesLogic.model;


import java.util.ArrayList;

public class CountedFile {
    private long count;
    private String name;
    private ArrayList<CountedFile> childs;

    public CountedFile() {
    }
    public void putChild(CountedFile child) {
        if(childs==null){
            childs = new ArrayList<>();
        }
        childs.add(child);
    }
    public ArrayList<CountedFile> getChilds() {
        return childs;
    }

    public void setChilds(ArrayList<CountedFile> childs) {
        this.childs = childs;
    }

    public CountedFile(long count, String name) {
        this.count = count;
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+" : "+count;
    }
}
