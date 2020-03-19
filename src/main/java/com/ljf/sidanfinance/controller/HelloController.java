package com.ljf.sidanfinance.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.ljf.sidanfinance.dao.mapper.ProjectMapper;
import com.ljf.sidanfinance.dao.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


@RestController
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    ProjectMapper projectMapper;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request, HttpServletResponse response){
        PageHelper.startPage(2,3);
        List<Project> projects = projectMapper.selectAll();
//        List<Project> projects = projectMapper.getAll();
        logger.info(JSON.toJSONString(projects));
        return JSON.toJSONString(projects);
    }

    @RequestMapping("/test/img")
    public void test(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //方式一
//		BufferedImage bi = ImageIO.read(new File("C:/Users/ljf/Pictures/girl.jpg"));
//
//		// 设置浏览器不缓存本页
//		response.setHeader("Cache-Control", "no-cache");
//		// 设置图片类型
//		response.setContentType("image/jpg");
//		// 输出验证码给客户端
//		ImageIO.write(bi, "JPEG", response.getOutputStream());

        //方式二
        File image = new File("C:/Users/ljf/Pictures/girl.jpg");
        FileInputStream fis = new FileInputStream(image);
        int length = fis.available();
        byte data[] = new byte[length];
        response.setContentLength(length);
        String fileName = image.getName();
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        response.setContentType(fileType);
        fis.read(data);
        OutputStream os = response.getOutputStream();
        os.write(data);
        os.flush();
        fis.close();
    }

}
