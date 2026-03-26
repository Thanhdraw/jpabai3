package com.cybersoft.jpabai3.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {

    @NotBlank(message = "Ten sinh vien khong được để trống")
    @Size(min = 2,max = 50,message = "Tên phải từ 2 đến 50 kí tự")
    private String name;

    @NotBlank(message = "Email không được trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @Min(value = 18, message = "Tuổi sinh viên phải từ 18 trở lên")
    @Max(value = 100, message = "Tuổi không hợp lệ")
    private int age;
}
