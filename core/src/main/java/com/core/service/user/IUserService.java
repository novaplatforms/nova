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

package com.core.service.user;

import com.core.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing user-related operations.
 */
@Service
public interface IUserService {
    void saveUser(UserModel userModel);
    void deleteUser(UserModel userModel);
    void updateUser(UserModel userModel);
    UserModel getUserById(int id);
    UserModel getUserByName(String name);
    UserModel getUserByEmail(String email);
    List<UserModel> getAllUsers();
}
