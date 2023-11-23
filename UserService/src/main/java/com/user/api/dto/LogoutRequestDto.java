package com.user.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogoutRequestDto {

    private String token;
    private Long userId;
}
