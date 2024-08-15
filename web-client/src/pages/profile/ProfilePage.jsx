import React from "react";
import { Helmet } from "react-helmet";
import ProfileCard from "../../widgets/cards/profile/ProfileCard";
import './ProfilePage.css'

function ProfilePage(username) {
    return (
        <div className="profile-container">
            <Helmet>
                <title> nova • profile </title>
            </Helmet>
            <ProfileCard/>
        </div>
    )
}
export default ProfilePage;