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

package com.core.repository;

import com.core.model.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing user information in the database.
 * Extends JpaRepository to provide basic CRUD operations.
 */

@Repository
public interface IUserInfoRepository extends JpaRepository<UserInfoModel, Integer> {

    /**
     * Retrieves the user information for a user with the specified username.
     *
     * @param username the username of the user whose information is to be retrieved
     * @return the UserInfoModel of the user with the specified username, or null if no such user exists
     */

    @Query("SELECT u FROM UserInfoModel u WHERE u.user.userName = ?1")
    UserInfoModel getUserByUserName(String username);
}
