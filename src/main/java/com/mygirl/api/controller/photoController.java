package com.mygirl.api.controller;

//import com.example.demo.Dao.PhotoDao;
//import com.example.demo.entity.PhotoUpload;
import com.mygirl.api.mapper.PhotoDao;
import com.mygirl.api.model.PhotoUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Vector;

//用于文件上传


@RestController
public class photoController {

    @Autowired
    private PhotoDao photoDao;

    //MultipartFile对象：代表HTML中form data方式上传的文件，包含二进制数据。

    @PostMapping(value = "/PhotoSave")   //注解用于存储数据时的跨域问题
    public void save(@RequestParam(name="fileField",required=false) MultipartFile fileField) throws IOException //required默认为true表示不允许为空
    {
        PhotoUpload photoUpload = new PhotoUpload();

        //传入的文件内容是否为空
        if(fileField==null)
        {
            photoUpload.setImage(null);
        }else {
            // getBytes()将文件的内容作为字节数组返回。
            photoUpload.setImage(fileField.getBytes());  //getBytes()方法会抛出异常
        }
        photoDao.save(photoUpload);   //调用jps的save方法将前端的图片文件保存到数据库中
    }



    @GetMapping(value="/companyPhoto/{id}")
    public void getPhotoById (@PathVariable("id") Integer id, HttpServletResponse response)throws IOException
    {
        PhotoUpload photoUpload = photoDao.getOne(id);
        byte[] data = photoUpload.getImage();

        //response.getOutputStream()获得字节流----->outputStream
        //BufferedOutputStream 构造一个字节缓冲输出流对象outputStream
        OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());  //getOutputStream()方法会抛出异常
        //通过字节流outputStream的write向response缓冲区写入字节，再由tomcat服务器将字节内容组成Http相应返回给浏览器。
        outputStream.write(data);   //输出data数据
        outputStream.close();  //关闭字节流
    }
    @PostMapping(value = "/Photoupdate")
    @CrossOrigin(origins = "http://127.0.0.1:8020")    //注解用于存储数据时的跨域问题
    public void update(@RequestParam(name="fileField",required=false) MultipartFile fileField, @RequestParam("id") Integer id) throws IOException //required默认为true表示不允许为空
    {
        PhotoUpload photoUpload = new PhotoUpload();
        photoUpload.setId(id);
        //传入的文件内容是否为空
        if(fileField==null)
        {
            photoUpload.setImage(null);
        }else {
            // getBytes()将文件的内容作为字节数组返回。
            photoUpload.setImage(fileField.getBytes());  //getBytes()方法会抛出异常
        }
        photoDao.save(photoUpload);   //调用jps的save方法将前端的图片文件保存到数据库中
    }
}