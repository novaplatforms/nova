import React from "react";
import './VerifyPage.css'
import '../../../widgets/forms/validation/ValidationForm'
import Footer from '../../../shared/ui/footer/Footer';
import { Helmet } from "react-helmet";
import ValidatonForm from "../../../widgets/forms/validation/ValidationForm";

function VerifyPage() {
    return (
    <div className="container">
        <Helmet>
            <title>nova • verify</title>
        </Helmet>
        <main>
            <ValidatonForm />
        </main>
        <div className="footer">
            <Footer />
        </div>
    </div>
    )
}
export default VerifyPage;