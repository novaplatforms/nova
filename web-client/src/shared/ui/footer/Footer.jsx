import React from "react";
import './Footer.css';

function Footer() {
    return (
        <div className="footer">
            <div className="footer-content">
            <p>&copy; 2024 Nova Platforms. All rights reserved.</p>
            <div className="footer-menu">
                <a href="/about" target="_blank" rel="noopener noreferrer">About Us</a>
                <a href="/contact" target="_blank" rel="noopener noreferrer">Contact</a>
                <a href="/privacy-policy" target="_blank" rel="noopener noreferrer">Privacy Policy</a>
                <a href="/terms-of-service" target="_blank" rel="noopener noreferrer">Terms of Service</a>
            </div>
            </div>
        </div>
    );
}
export default Footer;