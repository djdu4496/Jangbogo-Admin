package com.jangbogo.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
@Slf4j
public class UploadController {

    @GetMapping("/display")
    @ResponseBody
    public ResponseEntity<byte[]> getFile(String fileName) {
//        log.info("fileName: " + fileName); // 받아온 파일 이름 확인

        File file = new File("/Users/jiwoo/jangbogo-3rd/upload/temp/" + fileName); // 파일 업로드할 폴더 경로랑 파일 이름 합쳐서 파일 객체 생성.

//        log.info("file: " + file); // 파일 객체 제대로 만들어졌나 로그로 확인

        ResponseEntity<byte[]> result = null; // 바이트 배열 지네릭의 responseEntity null로 초기화.

        try {
            HttpHeaders header = new HttpHeaders();// 새로운 HttpHeaders를 생성한다.

            header.add("Content-Type", Files.probeContentType(file.toPath())); // content type을 지정한다. 컨텐트 타입 조사메서드를 쓴다.
            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK); // 바이트배열로 카피한 파일과, 헤더, 상태코드 200을 지네릭 바이트 배열에 담는다.

        } catch (IOException e) {
            e.printStackTrace(); //에러가 생길 경우 로그를 찍는다.

        }
        return result;
    }
}
