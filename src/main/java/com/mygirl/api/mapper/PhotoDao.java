package com.mygirl.api.mapper;

//import com.example.demo.entity.PhotoUpload;
import com.mygirl.api.model.PhotoUpload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDao extends JpaRepository<PhotoUpload,Integer> {

}
