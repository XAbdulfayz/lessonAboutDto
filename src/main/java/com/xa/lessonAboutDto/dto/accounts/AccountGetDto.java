package com.xa.lessonAboutDto.dto.accounts;

import com.xa.lessonAboutDto.etity.Photo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountGetDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private Photo photo;


}
