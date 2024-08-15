import React from "react";
import './ProfileCard.css';

function ProfileCard({ username, fullname, posts, followers, stars, following, bio, location, joined }) {
    return (
        <header>
            <div className="card">
            <div className="logo">
                <img src="../../../shared/assets/profile/profile.png" alt="logo" />
            </div>
            <div className="profile-header">
                <div className="username">
                    <strong>{username}</strong>
                </div>
                <div className="header-buttons">
                    <button>Change profile</button>
                    <button>Cloud</button>
                </div>
                <div className="user-stats">
                    <div className="stat">Posts: {posts}</div>
                    <div className="stat">Followers: {followers}</div>
                    <div className="stat">Stars: {stars}</div>
                    <div className="stat">Following: {following}</div>
                </div>
                <div className="user-info">
                    <div className="fullname">{fullname}</div>
                    <div className="bio">{bio}</div>
                    <div className="location">{location}</div>
                    <div className="date">{joined}</div>
                </div>
            </div>
        </div>
        </header>
    );
}

export default ProfileCard;
