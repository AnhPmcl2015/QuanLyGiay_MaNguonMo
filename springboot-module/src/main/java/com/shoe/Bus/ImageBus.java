package com.shoe.Bus;

import com.shoe.entities.Giay;
import com.shoe.jpa.JpaGiay;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ImageBus {

    @Value("${file.upload-dir}")
    private String pathImg;

    @Autowired
    private JpaGiay jpa;

    //luu dang file
    public void uploadImage(MultipartFile[] files, String idGiay) throws IOException {
        File uploadRootDir = new File(pathImg);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        List<String> pathImgs = new ArrayList<>();
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                continue;
            }
            byte[] bytes = file.getBytes();
            Path path = Paths.get(pathImg + file.getOriginalFilename());
            String pathImg = "http://localhost:8080/upload/image/" + file.getOriginalFilename();
            System.out.println(pathImg);
            pathImgs.add(pathImg.trim());
            Files.write(path, bytes);
        }
        if (pathImgs.size() <= 4) {
            Optional<Giay> giayOpt = jpa.findById(Integer.parseInt(idGiay));
            if (giayOpt.isPresent()) {
                Giay giay = giayOpt.get();
                giay.setImg1(pathImgs.get(0));
                giay.setImg2(pathImgs.get(1));
                giay.setImg3(pathImgs.get(2));
                giay.setImg4(pathImgs.get(3));
                jpa.save(giay);
            }
        }
    }

    public void saveImage(String[] files, MultipartFile[] fileParts, String idGiay) throws IOException {
        if (fileParts.length == 4) {
            uploadImage(fileParts, idGiay);
        } else if (files.length == 4) {
            return;
        } else {
            List<String> pathImgs = new ArrayList<>();
            for (MultipartFile file : fileParts) {
                if (file.isEmpty()) {
                    continue;
                }
                byte[] bytes = file.getBytes();
                Path path = Paths.get(pathImg + file.getOriginalFilename());
                String pathImg = "http://localhost:8080/upload/image/" + file.getOriginalFilename();
                System.out.println(pathImg);
                pathImgs.add(pathImg.trim());
                Files.write(path, bytes);
            }

            List<String> pathImages = new ArrayList<>();

            for (String i : files) {
                pathImages.add(i);
            }

            pathImgs.forEach(i -> {
                pathImages.add(i);
            });

            Optional<Giay> giayOpt = jpa.findById(Integer.parseInt(idGiay));
            if (giayOpt.isPresent()) {
                Giay giay = giayOpt.get();
                giay.setImg1(pathImages.get(0));
                giay.setImg2(pathImages.get(1));
                giay.setImg3(pathImages.get(2));
                giay.setImg4(pathImages.get(3));
                jpa.save(giay);
            }
        }


    }

}
