import React from 'react'
import { useState } from 'react';
import './RegistrationForm.css'
import logo from '../../../shared/assets/images/novalogo.png'

function RegistrationForm() {
    const [formData, setFormData] = useState({
        username: '',
        name: '',
        email: '',
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
        if (formData.termsAccepted) {
          console.log('Form Data:', formData);
          // I will implement this in the future
        } else {
          alert('You must accept the terms and conditions.');
        }
      };

    return (
        <form className="registration-form" onSubmit={handleSubmit} action='post'>
        <center><img src={logo} alt="logo" width={50} height={50}/></center>
        <center><h2>Registration • <strong>Nova</strong></h2></center>

        <div className="form-group">
        <label htmlFor="username">- Username</label>
        <input
            type="text"
            id="username"
            name="username"
            value={formData.username}
            onChange={handleChange}
            required
        />
        </div>

        <div className="form-group">
        <label htmlFor="name">- Fullname</label>
        <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
        />
        </div>

        <div className="form-group">
        <label htmlFor="email">- Email</label>
        <input
            type="email"
            id="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            required
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
            required
        />
        </div>

        <div className="form-group checkbox-group">
        <input
            type="checkbox"
            id="termsAccepted"
            name="termsAccepted"
            checked={formData.termsAccepted}
            onChange={handleChange}
            required
        />
        <label htmlFor="termsAccepted">
            I accept the{' '}
            <a href="/terms" target="_blank" rel="noopener noreferrer">
                Terms of Service
            </a>
            ,{' '}
            <a href="/privacy" target="_blank" rel="noopener noreferrer">
                Privacy Policy
            </a>{' '}
            and{' '}
            <a href="/cookie-policy" target="_blank" rel="noopener noreferrer">
                Cookie Policy
            </a>.
        </label>
        </div>

        <button type="submit" className="btn-submit">
            Register
        </button>
    </form>    
    )
}
export default RegistrationForm;