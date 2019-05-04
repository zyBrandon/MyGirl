package com.mygirl.api.model;

public class Message {
    public String content;
    public String message_time;

    public Message(){

    }

    public Message(String content,String message_time){
        this.content = content;
        this.message_time = message_time;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMessage_time(String message_time) {
        this.message_time = message_time;
    }

    public String getMessage_time() {
        return message_time;
    }

    public String getContent() {
        return content;
    }
}
