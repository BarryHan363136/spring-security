package com.barry.security.controller;

import com.barry.security.vo.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MultipartFileHandlerController {

    private static final Logger log = LoggerFactory.getLogger(MultipartFileHandlerController.class);

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String saveAuto(
            @RequestPart(value = "json") JsonPojo pojo,
            @RequestParam(value = "some-random") String random,
            @RequestParam(value = "data", required = false) List<MultipartFile> files) {
        System.out.println("=====saveAuto-1=======>"+random);
        System.out.println("=====saveAuto-2=======>"+pojo.getJson());
        for (MultipartFile file : files) {
            System.out.println("=====saveAuto-3=======>"+file.getOriginalFilename());
        }
        return "success";
    }

    @PostMapping
    @RequestMapping("/upload")
    public FileInfo upload(MultipartFile file){
        log.info("=====upload======>"+file.getName());
        log.info("=====upload======>"+file.getOriginalFilename());
        log.info("=====upload======>"+file.getSize());

        FileInfo fileInfo = new FileInfo();
        fileInfo.setPath("testing path...");
        return fileInfo;
    }


    static class JsonPojo {
        private String json;

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

    }








}
