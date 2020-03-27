package com.example.cj.web01.controller;

import com.example.cj.web01.common.Web01Exception;
import com.example.cj.web01.util.ResponseUtil;
import com.example.cj.web01.vo.FormVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class ContentController {
    @PostMapping(path = "/content")
    public ResponseUtil.Response generateCode(@RequestBody @Valid FormVO formVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError error : bindingResult.getAllErrors()) {
                throw new Web01Exception(error.getDefaultMessage());
            }
        }
        Map<String, String> data = new HashMap<>();
        data.put("content", UUID.randomUUID().toString());
        return ResponseUtil.buildSuccess(data);
    }
}
