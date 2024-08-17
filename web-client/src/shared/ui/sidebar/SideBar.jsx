import React from "react";
import logo from '../../../shared/assets/images/sparkle.png'
import home from '../../../shared/assets/icons/home.png'
import likes from '../../../shared/assets/icons/heart.png'
import message from '../../../shared/assets/icons/paper-plane.png'
import community from '../../../shared/assets/icons/users-alt.png'
import storage from '../../../shared/assets/icons/bookmark.png'
import post from '../../../shared/assets/icons/plus.png'
import more from '../../../shared/assets/icons/menu-burger.png'
import user from '../../../shared/assets/icons/user.png'
import news from '../../../shared/assets/icons/envelope.png'
import { Link } from "react-router-dom";
import './SideBar.css'

function SideBar() {
    return (
        <div className="side-bar-form">
            <div className="side-bar-content">
                <div className="side-bar-logo"><img src={logo} alt="logo" /></div>
                <div className="nav-list">
                    <div className="top-section">
                        <ul>
                            <li className="nav-item">
                                <img src={home} alt="home-ico" />
                                <strong><Link to="#">Home</Link></strong>
                            </li>
                            <li className="nav-item">
                                <img src={likes} alt="likes-ico" />
                                <strong><Link to="#">Likes</Link></strong>
                            </li>
                            <li className="nav-item">
                                <img src={news} alt="news-ico" />
                                <strong><Link to="#">Likes</Link></strong>
                            </li>
                            <li className="nav-item">
                                <img src={message} alt="message-ico" />
                                <strong><Link to="#">Messages</Link></strong>
                            </li>
                            <li className="nav-item">
                                <img src={community} alt="community-ico" />
                                <strong><Link to="#">Communities</Link></strong>
                            </li>
                            <li className="nav-item">
                                <img src={storage} alt="storage-ico" />
                                <strong><Link to="#">Storage</Link></strong>
                            </li>
                            <li className="nav-item">
                                <img src={post} alt="post-ico" />
                                <strong><Link to="#">Post</Link></strong>
                            </li>
                            <li className="nav-item">
                                <div className="user-ico"><img src={user} alt="user-ico" /></div>
                                <strong><Link to="#">Profile</Link></strong>
                            </li>
                        </ul>
                    </div>
                    <div className="bottom-section">
                        <ul>
                            <li className="nav-item">
                                <img src={more} alt="more-ico" />
                                <strong><Link to="#">More</Link></strong>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default SideBar;

