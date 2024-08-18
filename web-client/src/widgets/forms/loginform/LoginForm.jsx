import React, { useState } from 'react';
import './LoginForm.css';
import logo from '../../../shared/assets/images/sparkle.png'
import AuthButton from '../../../shared/ui/buttons/authbutton/AuthButton';

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
    
    };

    return (
        <form className="registration-form" onSubmit={handleSubmit} method='post'>
            <center><img src={logo} alt="logo" width={50} height={50}/></center>
            <center><h2>Log in • <strong>Nova</strong></h2></center>
            <br />
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
            <br />
            <AuthButton>Log in</AuthButton>
        </form>
    );
}
export default LoginForm;