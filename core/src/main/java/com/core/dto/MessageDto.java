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

package com.core.dto;

import lombok.Getter;
import lombok.Setter;


/**
 * DTO for sending messages.
 */
@Getter
@Setter
public class MessageDto {
    private String to;
    private String subject;
    private String body;

    public MessageDto(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
