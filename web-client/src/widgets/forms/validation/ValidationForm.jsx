import React from "react";
import './ValidatonForm.css'
import { useState } from "react";
import logo from '../../../shared/assets/images/sparkle.png'
import AuthButton from "../../../shared/ui/buttons/authbutton/AuthButton";

function ValidatonForm() {
    const [formData, setFormData] = useState({
        authenthicationCode: '',
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
        <center><h2>Verify your Email</h2></center>
        <br />

        <div className="form-group">
        <label htmlFor="authenthicationCode"><strong>- Enter authentication code</strong></label>
        <input
            type="text"
            id="authenthicationCode"
            name="authenthicationCode"
            value={formData.username}
            onChange={handleChange}
            required
        />
        </div>
        <br />
        <AuthButton>Submit</AuthButton>
    </form>    
    )
}
export default ValidatonForm;