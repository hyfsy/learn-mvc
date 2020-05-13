package com.hyf.mvc.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 * 由于前后台请求方式不一样，所以只能采用这种重定向的方式返回(表单post, 页面get)
 * <p>
 * 请求转发、重定向不会走视图解析器
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/firstTest")
    @ResponseBody
    public String firstTest() {
        System.out.println("success");
        return "success";
    }

    /**
     * 普通表单上传文件
     * <p>
     * 和 SpringMVC配置的文件解析器冲突！！！
     *
     * @param req 带文件的请求
     */
    @RequestMapping(value = "/commonFileUpload")
    public String commonFileUpload(HttpServletRequest req) throws Exception {
        System.out.println("start common file upload...");
        // 设置本地存放的文件夹路径
        String realPath = req.getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 创建一个工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 创建一个解析请求的对象
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        // 通过请求获取每个文件项
        List<FileItem> fileItems = fileUpload.parseRequest(req);

        // 遍历请求中的每个文件
        for (FileItem item : fileItems) {
            // 说明不是普通表单项，即上传项
            if (!item.isFormField()) {
                String fileName = item.getName();
                File saveFile = new File(file, fileName);
                System.out.println(saveFile.getAbsolutePath());
                item.write(saveFile);
                item.delete();
            }
        }
        System.out.println("success common file upload");

        //由于前后台请求方式不一样，所以只能采用这种重定向的方式返回(表单post, 页面get)
        return "redirect:/pages/success.html";
    }

    /**
     * springMVC上传文件
     * <p>
     * 此处的 file2 与表单中的 <code>type="file" name="file2"</code>的name要一致
     *
     * @param req   带文件信息的请求
     * @param file2 解析完 请求中的文件 的对象
     */
    @RequestMapping("/mvcFileUpload")
    public String mvcFileUpload(HttpServletRequest req, MultipartFile file2) throws Exception {
        System.out.println("start mvc file upload...");

        // 设置本地存放的文件夹路径，此处在target目录中
        String realPath = req.getServletContext().getRealPath("/uploads/");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 生成不容易重复的新文件名
        String fileName = UUID.randomUUID() + "_" + file2.getOriginalFilename();
        File saveFile = new File(file, fileName);
        System.out.println(saveFile.getAbsolutePath());
        //上传文件
        file2.transferTo(saveFile);

        // 此处将文件名写入到数据库中
        // ......

        System.out.println("success mvc file upload");
        return "redirect:/pages/success.html";
    }

    /**
     * 远程上传文件
     * <p>
     * 失败：405,已配置tomcat readonly
     *
     * @param file3 解析完 请求中的文件 的对象
     */
    @RequestMapping("/remoteFileUpload")
    public String remoteFileUpload(MultipartFile file3) throws Exception {

        /*
         * path 服务器上传路径需要修改
         * fileName 文件名不能为中文
         */


        // 定义上传文件路径，要事先创建文件夹，否则报409(conflict)
        String path = "http://localhost:8102/fileserver/uploads/";
        // 获取文件名
        String fileName = file3.getOriginalFilename() != null ? file3.getOriginalFilename() : "";
        fileName = URLEncoder.encode(fileName, "UTF-8");
        String remoteFilePath = path + fileName;
        System.out.println("start remote file upload...: " + remoteFilePath);

        try {
            // 创建客户端对象
            Client client = Client.create();
            System.out.println("create client success: " + client);

            // 和图片服务器进行连接
            WebResource resource = client.resource(remoteFilePath);
            System.out.println("create webResource success: " + resource);

            // 上传文件到服务器
            resource.put(file3.getBytes());
            System.out.println("upload success!!!");
        }catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return "redirect:/pages/success.html";
    }
}
