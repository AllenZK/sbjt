package com.example.sbjt.web.controller;

import com.example.sbjt.common.annos.Alog;
import com.example.sbjt.common.beans.MessageVo;
import com.example.sbjt.service.impl.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @auth: Created by zk on 2018/7/13
 * @description: 文件上传
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

    @Autowired
    private FileService fileService;

    @Alog("文件上传")
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) throws IOException {
        if (file.isEmpty()){
            //重定向隐藏参数
            redirectAttributes.addFlashAttribute("message","please select a file to upload");
            return "redirect:/file/uploadStatus";
        }
        String path = fileService.upload(file);
        if (StringUtils.isEmpty(path)){
            redirectAttributes.addFlashAttribute("message","upload failed!");
        }else {
            redirectAttributes.addFlashAttribute("message","filepath:" + path);
        }
        return "redirect:/file/uploadStatus";
    }

    @Alog("图片上传状态")
    @RequestMapping(value = "/uploadStatus",method = RequestMethod.GET)
    public String uploadStatus(@ModelAttribute MessageVo message, HttpServletRequest request){
        request.setAttribute("message",message.getMessage());
        return "success";
    }

}
