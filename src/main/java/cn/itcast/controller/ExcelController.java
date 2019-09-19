package cn.itcast.controller;

import cn.itcast.model.User;
import cn.itcast.service.impl.UserServiceImpl;
import cn.itcast.utils.ExportUserUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author lijingyu
 * @date 2019/9/19 13:43
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/export")
    public ResponseEntity<Object> export(HttpServletResponse response) throws UnsupportedEncodingException {
        List<User> userList = userService.findAll();
        String fileName = "用户数据.xls";
        String sheetName = "客户数据";
        ByteArrayOutputStream bos = ExportUserUtils.exportUser(userList, sheetName);
        String encode = URLEncoder.encode(fileName, "UTF-8");
        //创建封装响应头信息的对象
        HttpHeaders headers = new HttpHeaders();
        //封装响应内容类型
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",encode);
        return new ResponseEntity<Object>(bos.toByteArray(),headers, HttpStatus.CREATED);
    }
}
