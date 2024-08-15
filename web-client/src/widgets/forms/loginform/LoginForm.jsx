import React, { useState } from 'react';
import './LoginForm.css';

function LoginForm() {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        termsAccepted: false
    });

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData({
            ...formData,
            [name]: type === 'checkbox' ? checked : value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle form submission
    };

    return (
        <form className="registration-form" onSubmit={handleSubmit}>
            <center><h2>Log in • <strong>Nova</strong></h2></center>
            <div className="form-group">
                <label htmlFor="username">- Username or Email</label>
                <input
                    type="text"
                    id="username"
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                />
            </div>
            <div className="form-group">
                <label htmlFor="password">- Password</label>
                <input
                    type="password"
                    id="password"
                    name="password"
                    value={formData.password}
                    onChange={handleChange}
                />
            </div>
            <div className="form-group checkbox-group">
                <input
                    type="checkbox"
                    id="termsAccepted"
                    name="termsAccepted"
                    checked={formData.termsAccepted}
                    onChange={handleChange}
                />
                <label htmlFor="termsAccepted"><a href="#">Accept Terms</a> and <a href="#">Conditions</a></label>
            </div>
            <button type="submit" className="btn-submit">Login</button>
        </form>
    );
}

export default LoginForm;