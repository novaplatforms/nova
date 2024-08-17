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

package com.core.service.user;

import com.core.model.UserModel;
import com.core.repository.IUserModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing user-related operations.
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private IUserModelRepository userModelRepository;

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public void saveUser(UserModel userModel) {
        if (userModel == null) {
            logger.error("User is null");
        }
        logger.info("User saved successfully");
        userModelRepository.save(userModel);
    }

    @Override
    public void deleteUser(UserModel userModel) {
        if (userModel == null) {
            logger.error("User is null");
        }
        logger.info("User deleted successfully");
        userModelRepository.delete(userModel);
    }

    @Override
    public void updateUser(UserModel userModel) {
        if (userModel == null) {
            logger.error("User is null");
        }
        logger.info("User updated successfully");
        userModelRepository.save(userModel);
    }

    @Override
    public UserModel getUserById(int id) {
        if (id < 0) {
            logger.error("Id is negative");
        }
        logger.info("User found successfully");
        return userModelRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel getUserByName(String name) {
        if (name == null) {
            logger.error("Name is null");
        }
        logger.info("User found successfully");
        return userModelRepository.findByUsername(name);
    }

    @Override
    public UserModel getUserByEmail(String email) {
        if (email == null) {
            logger.error("Email is null");
        }
        logger.info("User found successfully");
        return userModelRepository.findByEmail(email);
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userModelRepository.findAll();
    }
}
