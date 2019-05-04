package com.mygirl.api.controller;

import com.mygirl.api.mapper.UserMapper;
import com.mygirl.api.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Vector;

@RequestMapping("user/")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    //添加留言
    @RequestMapping(value = "/addMessage",method = RequestMethod.GET)
    public int addMessage(@RequestParam String content,@RequestParam String message_time){
        int i = userMapper.addMessage(content,message_time);
        return i;
    }

    //获取所有的留言
    @RequestMapping(value = "getMessage",method = RequestMethod.GET)
    public Vector<Message> getMessage(){
        Vector<Message> messages = userMapper.getMessage();
        return messages;
    }

    //删除留言
    @RequestMapping(value = "delMessage",method = RequestMethod.GET)
    public int delMessage(@RequestParam String content,@RequestParam String message_time){
        int i = userMapper.delMessage(content,message_time);
        return i;
    }

    //获取所有歌单
    @RequestMapping(value = "getMusic",method = RequestMethod.GET)
    public Vector<Music> getMusic(){
        Vector<Music> music = userMapper.getMusic();
        return music;
    }

    //添加歌单
    @RequestMapping(value = "addMusic",method = RequestMethod.GET)
    public int addMusic(@RequestParam String name,@RequestParam String src){
        int i = userMapper.addMusic(name,src);
        return i;
    }


    //获取图片个数
    @RequestMapping(value = "getNum",method = RequestMethod.GET)
    public int getNum(){
        int i = userMapper.getNum();
        return i;
    }






}
