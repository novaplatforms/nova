/*
 * @author Gnatyk Dmytro
 * This file is part of XAPP.
 *
 * XAPP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * XAPP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with XAPP. If not, see <https://www.gnu.org/licenses/>.
 */

package com.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


/**
 * Model for user info.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_info")
public class UserInfoModel {
    @Id
    @Column(name = "info_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer infoId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;

    @Size(min = 4, max = 50)
    @Column(name = "user_bio")
    private String userBio;

    @Size(min = 4, max = 50)
    @Column(name = "user_location")
    private String userLocation;

    @Column(name = "user_icon")
    private String userIcon;

    public UserInfoModel(UserModel user, String userBio, String userLocation, String userIcon) {
        this.user = user;
        this.userBio = userBio;
        this.userLocation = userLocation;
        this.userIcon = userIcon;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserInfoModel that = (UserInfoModel) object;
        return Objects.equals(infoId, that.infoId) && Objects.equals(user, that.user) && Objects.equals(userBio, that.userBio) && Objects.equals(userLocation, that.userLocation) && Objects.equals(userIcon, that.userIcon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infoId, user, userBio, userLocation, userIcon);
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "infoId=" + infoId +
                ", user=" + user +
                ", userBio='" + userBio + '\'' +
                ", userLocation='" + userLocation + '\'' +
                ", userIcon='" + userIcon + '\'' +
                '}';
    }
}
