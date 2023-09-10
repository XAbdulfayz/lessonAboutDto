package com.xa.lessonAboutDto.dto.accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreateDto {

    private String name;
    private String password;
    private String phoneNumber;


}
