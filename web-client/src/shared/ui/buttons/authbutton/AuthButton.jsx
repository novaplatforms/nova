import React from "react";
import './AddButton.css'

function AuthButton( { children } ) {
    return (
        <button type="submit" className="btn-submit">{ children }</button>
    )
}
export default AuthButton;