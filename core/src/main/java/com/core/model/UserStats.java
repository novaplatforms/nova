package com.core.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "user_stats")
@NoArgsConstructor
public class UserStats {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "followers", nullable = false)
    private Integer followers;

    @Column(name = "following", nullable = false)
    private Integer following;

    @Column(name = "posts", nullable = false)
    private Integer posts;

    @Column(name = "likes", nullable = false)
    private Integer likes;

    public UserStats(UserModel user, Status status, Integer followers, Integer following, Integer posts, Integer likes) {
        this.user = user;
        this.status = status;
        this.followers = followers;
        this.following = following;
        this.posts = posts;
        this.likes = likes;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        UserStats userStats = (UserStats) object;
        return Objects.equals(id, userStats.id) && Objects.equals(user, userStats.user) && status == userStats.status && Objects.equals(followers, userStats.followers) && Objects.equals(following, userStats.following) && Objects.equals(posts, userStats.posts) && Objects.equals(likes, userStats.likes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, status, followers, following, posts, likes);
    }
}
