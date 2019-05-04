package com.mygirl.api.repository;

//import com.example.demo.entity.PhotoUpload;
import com.mygirl.api.model.PhotoUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface photoName extends JpaRepository<PhotoUpload,Integer> {
    @Query(value = "update photo_upload set image=?1 where id=?2 ", nativeQuery = true)//有nativeQuery = true时，是可以执行原生sql语句，所谓原生sql，也就是说这段sql拷贝到数据库中，然后把参数值给一下就能运行了
    @Modifying
    @Transactional
    public void updateOne(byte[] image, Integer id);

}
