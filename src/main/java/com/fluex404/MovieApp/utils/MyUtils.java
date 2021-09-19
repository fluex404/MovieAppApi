package com.fluex404.MovieApp.utils;

import com.fluex404.MovieApp.exception.CustomException;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class MyUtils {
    public String upload(byte imageBytes[], String imageName, Long movieId) throws CustomException {
        File fileTarget = new File("upload/"+movieId+"/");

        if(!fileTarget.exists())
            fileTarget.mkdirs();

        fileTarget = new File(fileTarget.getPath()+"/"+imageName);

        try {

            System.out.println(imageBytes);

            FileUtils.writeByteArrayToFile(fileTarget, imageBytes);
        } catch (IOException e) {
            throw new CustomException("upload image failed!", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return "http://localhost:8080/"+fileTarget.getPath();
    }
}
