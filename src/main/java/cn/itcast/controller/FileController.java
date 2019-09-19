package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author lijingyu
 * @date 2019/9/14 12:42
 */
@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/load")
    public String upload(HttpServletRequest request,@RequestParam(required = true) MultipartFile file){
        String realPath = request.getSession().getServletContext().getRealPath("/load/");
        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        String uuid = UUID.randomUUID().toString().replace("_", "");
        String s = uuid+"_"+file.getOriginalFilename();
        try {
            file.transferTo(new File(realPath,s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
