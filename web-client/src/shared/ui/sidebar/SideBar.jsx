import React from "react";
import logo from '../../../shared/assets/images/sparkle.png';
import home from '../../../shared/assets/icons/home.png';
import message from '../../../shared/assets/icons/paper-plane.png';
import community from '../../../shared/assets/icons/users.png';
import bookmark from '../../../shared/assets/icons/bookmark.png';
import post from '../../../shared/assets/icons/add.png';
import more from '../../../shared/assets/icons/align-justify.png';
import user from '../../../shared/assets/icons/user.png';
import news from '../../../shared/assets/icons/envelope.png';
import folder from '../../../shared/assets/icons/folder.png';
import userlogo from '../../../shared/assets/icons/userlogo.png'
import { Link } from "react-router-dom";
import './SideBar.css';

function SideBar({ children }) {
    return (
        <div className="side-bar-form">
            <div className="side-bar-content">
                <div className="side-bar-logo">
                    <img src={logo} alt="logo" />
                </div>
                <div className="nav-list">
                    <div className="top-section">
                        <ul>
                            <li className="nav-item">
                                <img src={home} alt="home-ico" />
                                <span className="nav-link"><Link to="#">Home</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={news} alt="news-ico" />
                                <span className="nav-link"><Link to="#">Notifications</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={bookmark} alt="bookmark-ico" />
                                <span className="nav-link"><Link to="#">Bookmarks</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={message} alt="message-ico" />
                                <span className="nav-link"><Link to="#">Messages</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={community} alt="community-ico" />
                                <span className="nav-link"><Link to="#">Groups</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={folder} alt="archive-ico" />
                                <span className="nav-link"><Link to="#">Bucket</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={post} alt="post-ico" />
                                <span className="nav-link"><Link to="#">Post</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={userlogo} alt="userlogo-ico" />
                                <span className="nav-link"><Link to="#">Profile</Link></span>
                            </li>
                        </ul>
                    </div>
                    <div className="bottom-section">
                        <ul>
                            <li className="nav-item">
                                <div className="user-ico"><img src={user} alt="user-ico" /></div>
                                <span className="nav-link"><Link to="#">{ children }</Link></span>
                            </li>
                            <li className="nav-item">
                                <img src={more} alt="more-ico" />
                                <span className="nav-link"><Link to="#">More</Link></span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    );
}
export default SideBar;
