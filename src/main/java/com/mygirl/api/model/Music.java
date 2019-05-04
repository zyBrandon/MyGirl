package com.mygirl.api.model;

public class Music {
    private String name;
    private String src;
    public Music(){

    }

    public Music(String name,String src){
        this.name = name;
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
