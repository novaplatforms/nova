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

package com.core.controller;

import com.core.dto.UserDto;
import com.core.dto.UserInfoDto;
import com.core.model.UserInfoModel;
import com.core.model.UserModel;
import com.core.service.user.IUserService;
import com.core.service.userinfo.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserInfoService userInfoService;

    private final Logger logger = Logger.getLogger(AuthController.class.getName());

    /**
     * Logs in a user with the provided username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return ResponseEntity with UserModel if login is successful, or bad request if login fails
     */

    @GetMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestParam String username,
                                               @RequestParam String password) {
        if (username == null || password == null) {
            logger.warning("Username or password is null");
            return ResponseEntity.badRequest().build();
        }

        if (isValid(username, password)) {
            UserModel user = userService.getUserByName(username);
            logger.info("User logged in successfully");
            return ResponseEntity.ok(user);
        } else {
            logger.warning("Invalid username or password");
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Registers a new user with the provided user details.
     *
     * @param userDto the details of the user to register
     * @return ResponseEntity with UserModel if registration is successful, or bad request if user already exists
     */

    @PostMapping("/sign")
    public ResponseEntity<UserModel> signUser(@RequestBody UserDto userDto) {
        if (userDto == null) {
            logger.warning("User is null");
            return ResponseEntity.badRequest().build();
        }

        UserModel user = new UserModel(userDto.getUsername(), userDto.getFullname(), userDto.getEmail(),
                    userDto.getPassword());

        logger.info("User created successfully");
        userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    /**
     * Saves the user information.
     *
     * @param infoDto the user information to save
     * @return ResponseEntity with a message if user information is saved successfully, or not found if user does not exist
     */

    @PostMapping("/save-info")
    public ResponseEntity<String> saveUserInfo(@RequestBody UserInfoDto infoDto) {
        if (infoDto == null) {
            logger.warning("User info DTO is null");
            return ResponseEntity.badRequest().body("User info cannot be null");
        }

        if (infoDto.getUser() == null || infoDto.getUser().getUserName() == null) {
            logger.warning("User or username is null in info DTO");
            return ResponseEntity.badRequest().body("User and username cannot be null");
        }

        UserModel userModel = userService.getUserByName(infoDto.getUser().getUserName());
        if (userModel != null) {
            UserInfoModel userInfoModel = new UserInfoModel(infoDto.getUser(), infoDto.getBio(),
                    infoDto.getLocation(), infoDto.getIcon());

            userInfoService.saveUserInfo(userInfoModel);
            logger.info("User info saved successfully for user: " + userModel.getUserName());
            return ResponseEntity.ok("User info saved successfully");
        } else {
            logger.warning("User not found with username: " + infoDto.getUser().getUserName());
            return ResponseEntity.status(404).body("User not found");
        }
    }

    private boolean isValid(String username, String password) {
        if (username == null || password == null) {
            logger.warning("Username or password is null");
            return false;
        }

        List<UserModel> users = userService.getAllUsers();
        for (UserModel user : users) {
            if (user.getUserName().equals(username) && user.getUserPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
