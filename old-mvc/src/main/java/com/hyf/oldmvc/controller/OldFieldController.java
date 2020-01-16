package com.hyf.oldmvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class OldFieldController {

    /**
     * 测试老对象的文件下载
     */
    @RequestMapping("/testOldField")
    public ResponseEntity<byte[]> testOldField(RequestEntity<String> requestEntity, HttpServletRequest request) throws IOException {

        // 设置响应内容
        ServletContext context = request.getServletContext();
        InputStream is = context.getResourceAsStream("/static/default_converters.txt");
        byte[] body = new byte[is.available()];
        is.read(body);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=asdf.txt");

        // 设置响应码
        HttpStatus status = HttpStatus.OK;

        // 生成响应对象
        ResponseEntity<byte[]> response = new ResponseEntity<>(body, headers, status);
        return response;
    }

}
