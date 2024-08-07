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

package com.core.service.userinfo;

import com.core.model.UserInfoModel;
import com.core.repository.IUserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing user-info-related operations.
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Autowired
    private IUserInfoRepository userInfoRepository;

    private final Logger logger = LoggerFactory.getLogger(UserInfoService.class);

    @Override
    public void saveUserInfo(UserInfoModel userInfoModel) {
        if (userInfoModel == null) {
            logger.error("User info is null");
        }

        logger.info("User info saved successfully");
        userInfoRepository.save(userInfoModel);
    }

    @Override
    public void deleteUserInfo(UserInfoModel userInfoModel) {
        if (userInfoModel == null) {
            logger.error("User info is null");
        }

        logger.info("User info deleted successfully");
        userInfoRepository.delete(userInfoModel);
    }

    @Override
    public void updateUserInfo(UserInfoModel userInfoModel) {
        if (userInfoModel == null) {
            logger.error("User info is null");
        }

        logger.info("User info updated successfully");
        userInfoRepository.save(userInfoModel);
    }

    @Override
    public UserInfoModel getUserByUserName(String username) {
        if (username == null) {
            logger.error("Username is null");
        }

        logger.info("User info retrieved successfully");
        return userInfoRepository.getUserByUserName(username);
    }
}
