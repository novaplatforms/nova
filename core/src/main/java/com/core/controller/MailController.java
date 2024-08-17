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

import com.core.model.UserModel;
import com.core.service.mail.IMailService;
import com.core.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;

@RestController
@RequestMapping("/api/v1/mail")
public class MailController {

    @Autowired
    private IMailService mailService;

    @Autowired
    private IUserService userService;

    private final Logger logger = LoggerFactory.getLogger(MailController.class);

    private String authCode;

    /**
     * Sends an authentication code to the provided email for verification.
     *
     * @param email the email address to send the authentication code to
     * @return ResponseEntity with a message if email is sent successfully, or conflict if user with this email already exists
     */

    @PostMapping("/send-check-mail")
    public ResponseEntity<String> checkMail(@RequestParam String email) {
        if (email == null) {
            logger.info("Email is null");
            return ResponseEntity.badRequest().body(null);
        }

        UserModel user = userService.getUserByEmail(email);
        if (user == null) {
            authCode = generateAuthCode();
            mailService.sendMail(email, "Auth code", authCode);
            logger.info("Mail sent successfully");
            return ResponseEntity.ok("Auth code sent to email");
        }
        logger.info("User with this email already exists");
        return ResponseEntity.status(409).body("User with this email already exists");
    }

    /**
     * Checks if the provided authentication code is correct.
     *
     * @param code the authentication code to check
     * @return ResponseEntity with a message if the code is correct, or not found if the code is incorrect
     */

    @GetMapping("/check-mail")
    public ResponseEntity<String> checkEmail(@RequestParam String code) {
        if (code == null) {
            logger.info("Code is null");
            return ResponseEntity.badRequest().body("Code is null");
        }

        if (code.equals(authCode)) {
            logger.info("Code is correct");
            return ResponseEntity.ok("Code is correct");
        }
        logger.info("Invalid code");
        return ResponseEntity.status(404).body("Invalid code");
    }

    /**
     * Generates a random authentication code.
     *
     * @return the generated authentication code
     */

    private String generateAuthCode() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        return String.format("%05d", num);
    }
}
