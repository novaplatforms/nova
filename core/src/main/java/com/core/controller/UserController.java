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

package com.core.controller;

import com.core.dto.UserDto;
import com.core.model.UserModel;
import com.core.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;
    private final Logger logger = Logger.getLogger(UserController.class.getName());

    @GetMapping("/all")
    public ResponseEntity<List<UserModel>> getAllUsers() {
        logger.info("Getting all users");
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        if (userId == null) {
            return ResponseEntity.accepted().body("User ID is null");
        }
        UserModel user = userService.getUserById(userId);
        if (user != null) {
            userService.deleteUser(user);
            logger.info("User with ID " + userId + " deleted");
            return ResponseEntity.ok("User with ID " + userId + " deleted");
        }
        logger.info("User with ID " + userId + " not found");
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/upgrade")
    public ResponseEntity<UserModel> upgradeUser(@RequestBody UserDto userDto) {
        if (userDto == null) {
            logger.info("User is null");
            return ResponseEntity.status(404).body(null);
        }

        UserModel user = userService.getUserByName(userDto.getUsername());
        if (user != null) {
            logger.info("User upgraded successfully");
            userService.updateUser(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();
    }
}
