import React from "react";
import { Helmet } from "react-helmet";
import ProfileCard from "../../widgets/cards/profile/ProfileCard";
import Search from "../../widgets/search/Search";
import SideBar from "../../shared/ui/sidebar/SideBar";
import './ProfilePage.css'

function ProfilePage() {
    return (
        <div className="profile-container">
            <Helmet>
                <title> nova • profile </title>
            </Helmet>
            <SideBar>gnatykdm</SideBar>
            <Search />
            <ProfileCard username={"gnatykdm"}
                   fullname={"Dmytro Gnatyk"}
                   followers={"30"}
                   posts={"10"}
                   likes={"123"}
                   bins={"32"}
                   joined={"01.01.2025"}
                   bio={"CEO of Nova Platforms"}
                   location={"Rzeszow, Poland"} />
        </div>
    )
}
export default ProfilePage;