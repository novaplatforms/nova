import React, { useState } from "react";
import './SocialBar.css';

const SocialBar = () => {
    const [activeTab, setActiveTab] = useState('');

    const handleTabClick = (tab) => {
        setActiveTab(tab);
    }

    return (
        <div className="social-bar-form">
            <div className="social-bar-content">
                <div className="action-buttons">
                    <span
                        className={activeTab === 'recommendations' ? 'active' : ''}
                        onClick={() => handleTabClick('recommendations')}
                    >
                        Recommendations
                    </span>
                    <span
                        className={activeTab === 'following' ? 'active' : ''}
                        onClick={() => handleTabClick('following')}
                    >
                        Following
                    </span>
                </div>
                <div className="content-display">
                    {activeTab === 'recommendations' && (
                        <div className="recommendations">
                            <p>Here are your recommendations.</p>
                        </div>
                    )}
                    {activeTab === 'following' && (
                        <div className="following">
                            <p>Here are the accounts you are following.</p>
                        </div>
                    )}
                </div>
            </div>
        </div>
    )
}
export default SocialBar;
