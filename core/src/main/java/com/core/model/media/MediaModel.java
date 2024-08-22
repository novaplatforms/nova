package com.core.model.media;

import com.core.model.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "media")
@NoArgsConstructor
public class MediaModel {
    @Id
    @Column(name = "media_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mediaId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;

    @JoinColumn(name = "photo")
    @Column(name = "photos", nullable = false)
    private Photo photos;
}
