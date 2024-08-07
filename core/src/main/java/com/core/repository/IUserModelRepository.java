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

package com.core.repository;

import com.core.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing and managing user data in the database.
 * Extends JpaRepository to provide basic CRUD operations.
 */

@Repository
public interface IUserModelRepository extends JpaRepository<UserModel, Integer> {

    /**
     * Retrieves the user details for a user with the specified username.
     *
     * @param username the username of the user whose details are to be retrieved
     * @return the UserModel of the user with the specified username, or null if no such user exists
     */

    @Query("SELECT u FROM UserModel u WHERE u.userName = ?1")
    UserModel findByUsername(String username);

    /**
     * Retrieves the user details for a user with the specified email.
     *
     * @param email the email of the user whose details are to be retrieved
     * @return the UserModel of the user with the specified email, or null if no such user exists
     */

    @Query("SELECT u FROM UserModel u WHERE u.userEmail = ?1")
    UserModel findByEmail(String email);
}
