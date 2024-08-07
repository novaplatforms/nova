package com.core.dto;

import com.core.model.UserModel;
import lombok.Getter;
import lombok.Setter;


/**
 * DTO for user-info-related operations.
 */
@Getter
@Setter
public class UserInfoDto {
    private UserModel user;
    private String bio;
    private String location;
    private String icon;

    public UserInfoDto(UserModel user, String bio, String location, String icon) {
        this.user = user;
        this.bio = bio;
        this.location = location;
        this.icon = icon;
    }
}
