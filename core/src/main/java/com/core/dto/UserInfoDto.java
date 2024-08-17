/*
 * @author Gnatyk Dmytro
 * This file is part of NOVA.
 *
 * NOVA is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NOVA is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NOVA. If not, see <https://www.gnu.org/licenses/>.
 */

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
