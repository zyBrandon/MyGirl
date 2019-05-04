package com.mygirl.api.model;

import javax.persistence.*;

//图片上传的实体类
@Entity
public class PhotoUpload {

    @Id
    @GeneratedValue    //表示Id自增
    private Integer id;

    //图片的二进制存储类型在数据库中用Blob或者longBlob存储

    //Blob用来存储二进制文件的字段类型
    //longBlob用来存储二进制大对象

    @Lob    //表示该属性持久化为Blob或者Clob类型
    @Column(name="image", columnDefinition="longblob")  //声明该属性与数据库字段的映射---->为longblob
    private byte[] image;

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
