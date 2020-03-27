package com.example.cj.web01.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormVO {
    @NotBlank(message = "名称不能为空")
    private String name;
    // 好一点还可以写个正则校验日期格式
    @Size(min = 10, max = 10, message = "日期格式为YYYY-mm-dd")
    private String startTime;
    @Size(min = 10, max = 10, message = "日期格式为YYYY-mm-dd")
    private String endTime;
    @NotBlank(message = "code不能为空")
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
