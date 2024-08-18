import React, { useEffect } from 'react';
import { Route, Routes } from 'react-router-dom';
import logo from './shared/assets/images/novalogo.png';
import './App.css';
import LoginPage from './pages/auth/login/LoginPage';
import RegistrationPage from './pages/auth/registration/RegistrationPage';
import VerifyPage from './pages/auth/verify/VerifyPage';
import { Helmet } from 'react-helmet';
import ProfilePage from './pages/profile/ProfilePage';
import SideBar from './shared/ui/sidebar/SideBar';
import ProfileCard from './widgets/cards/profile/ProfileCard';

function App() {
  useEffect(() => {
    const favicon = document.getElementById('favicon');
    if (favicon) {
      favicon.href = logo;
    } else {
      const link = document.createElement('link');
      link.id = 'favicon';
      link.rel = 'icon';
      link.type = 'image/png';
      link.href = logo;
      document.head.appendChild(link);
    }
  }, [logo]);

  return (
    <div className="App">
      <Helmet>
          <title>nova • app</title>
      </Helmet>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegistrationPage />} />
        <Route path="/profile" element={<ProfilePage />} />
        <Route path="/verify" element={<VerifyPage />} />
      </Routes>
    </div>
  );
}
export default App;