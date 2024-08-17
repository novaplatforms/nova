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

package com.core.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;


/**
 * Model for user.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class UserModel {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotNull
    @Size(min = 4, max = 10)
    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(name = "fullname", nullable = false)
    private String fullName;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(name = "email", unique = true, nullable = false)
    private String userEmail;

    @NotNull
    @Size(min = 4, max = 50)
    @Column(name = "password", nullable = false)
    private String userPassword;

    @NotNull
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public UserModel(String userName, String fullName, String userEmail, String userPassword) {
        this.userName = userName;
        this.fullName = fullName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserModel userModel = (UserModel) object;
        return Objects.equals(userId, userModel.userId) && Objects.equals(userName, userModel.userName) && Objects.equals(fullName, userModel.fullName) && Objects.equals(userEmail, userModel.userEmail) && Objects.equals(userPassword, userModel.userPassword) && Objects.equals(createdAt, userModel.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, fullName, userEmail, userPassword, createdAt);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
