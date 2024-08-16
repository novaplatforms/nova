import React from 'react';
import { Helmet } from 'react-helmet';
import './Login.css';
import LoginForm from '../../../widgets/forms/loginform/LoginForm';
import Footer from '../../../shared/ui/footer/Footer';

function LoginPage() {
  return (
    <div className="container">
      <Helmet>
        <title>nova • login</title>
      </Helmet>
      <main>
        <LoginForm />
      </main>
      <div className="footer">
        <Footer />
      </div>
    </div>
  );
}
export default LoginPage;