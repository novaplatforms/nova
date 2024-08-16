import React from 'react';
import { Helmet } from 'react-helmet';
import './Registration.css';
import RegistrationForm from '../../../widgets/forms/registrationform/RegistrationForm';
import Footer from '../../../shared/ui/footer/Footer';

function RegistrationPage() {
  return (
    <div className="container">
      <Helmet>
        <title>nova • register</title>
      </Helmet>
      <main>
        <RegistrationForm />
      </main>
      <div className="footer">
        <Footer />
      </div>
    </div>
  );
}

export default RegistrationPage;