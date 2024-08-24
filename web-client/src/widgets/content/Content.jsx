import React, { useState } from "react";
import './Content.css';

const Content = () => {

    const [activeTab, setActiveTab] = useState('Media');

    const handleTabClick = (tab) => {
        setActiveTab(tab);
    }

    return (
        <div className="content-form">
            <div className="content-types">
                <span
                    className={activeTab === 'Media' ? 'active' : ''}
                    onClick={() => handleTabClick('Media')}
                >
                    Media
                </span>
                <span
                    className={activeTab === 'Posts' ? 'active' : ''}
                    onClick={() => handleTabClick('Posts')}
                >
                    Posts
                </span>
                <span
                    className={activeTab === 'Templates' ? 'active' : ''}
                    onClick={() => handleTabClick('Templates')}
                >
                    Templates
                </span>
            </div>
            <div className="content-head">
                {activeTab === 'Media' && <div>Displaying Media content...</div>}
                {activeTab === 'Posts' && <div>Displaying Posts content...</div>}
                {activeTab === 'Templates' && <div>Displaying Templates content...</div>}
            </div>
        </div>
    )
}
export default Content;
