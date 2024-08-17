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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "message")
@NoArgsConstructor
public class MessageModel {
    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    @Column(name = "sender", nullable = false)
    private UserModel messageSender;

    @Column(name = "receiver", nullable = false)
    private UserModel messageReceiver;

    @Column(name = "content", nullable = false)
    private String messageContent;

    @Column(name = "time", nullable = false)
    private LocalDateTime messageDateTime = LocalDateTime.now();

    public MessageModel(UserModel messageSender, UserModel messageReceiver, String messageContent) {
        this.messageSender = messageSender;
        this.messageReceiver = messageReceiver;
        this.messageContent = messageContent;
    }

    @Override
    public boolean equals(Object o ) {
        if (o == this) return true;
        if (! (o instanceof MessageModel)) return false;
        MessageModel that = (MessageModel) o;
        return that.messageId.equals(messageId) && that.messageSender.equals(messageSender)
                && that.messageReceiver.equals(messageReceiver) && that.messageContent.equals(messageContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, messageSender, messageReceiver, messageContent, messageDateTime);
    }
}
