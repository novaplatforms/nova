import React from "react";
import logo from '../../../shared/assets/icons/Чёрный_супрематический_квадрат._1915._ГТГ.png';
import marker from '../../../shared/assets/icons/marker.png';
import calendar from '../../../shared/assets/icons/calendar.png';
import './ProfileCard.css';
import {Link} from "react-router-dom";

function ProfileCard({ username, fullname, posts, followers, likes, bins, bio, location, joined }) {

    return (
        <div className="profile-card">
            <div className="user-logo">
                <img src={logo} alt="Profile" />
                <div className="location-joined-bio">
                    <div className="location">
                        <img src={marker} alt="Location Marker" />
                        { location }
                    </div>
                    <div className="joined">
                        <img src={calendar} alt="Joined Date" />
                        { joined }
                    </div>
                </div>
            </div>
            <div className="user-content">
                <div className="user-header">
                    <div className="header-top">
                        <span className="username">{ username }</span>
                        <div className="buttons">
                            <button><Link to={"/edit"}/>Edit</button>
                            <button><Link to={"/bucket"}/>Archive</button>
                        </div>
                    </div>
                    <div className="content">
                        <div className="content-item">Posts: <strong>{ posts }</strong></div>
                        <div className="content-item">Followers: <strong>{ followers }</strong></div>
                        <div className="content-item">Likes: <strong>{ likes }</strong></div>
                        <div className="content-item">Templates: <strong>{ bins }</strong></div>
                    </div>
                    <div className="fullname"><span>{ fullname }</span></div>
                    <div className="bio">
                        { bio }
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProfileCard;
