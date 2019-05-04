package com.mygirl.api.mapper;

import com.mygirl.api.model.*;
import org.apache.ibatis.annotations.*;

import java.util.Vector;

@Mapper
public interface UserMapper {


    @Insert("insert into message values(#{message_time},#{content})")
    int addMessage(@Param("content") String content,@Param("message_time") String message_time);

    @Select("select * from message")
    Vector<Message> getMessage();

    @Delete("delete from message where content=#{content} and message_time=#{message_time}")
    int delMessage(@Param("content") String content,@Param("message_time") String message_time);

    @Select("select * from music")
    Vector<Music> getMusic();

    @Insert("insert into music values(#{name},#{src})")
    int addMusic(@Param("name") String name,@Param("src") String src);

    @Select("select count(*) from photo_upload")
    int getNum();
}
