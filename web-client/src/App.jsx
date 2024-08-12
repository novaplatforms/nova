import React from 'react';
import { Route, Routes, Link } from 'react-router-dom';
import Login from './pages/auth/login/Login';
import Registration from './pages/auth/registration/Registration';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        {/* Navigation Buttons */}
        <button name='switchToLogin'>
          <Link to='/login'>Login</Link>
        </button>
        <button name='switchToRegister'>
          <Link to='/register'>Register</Link>
        </button>
        
        {/* Routes Definition */}
        <Routes>
          <Route path='/login' element={<Login />} />
          <Route path='/register' element={<Registration />} />
        </Routes>
      </header>
    </div>
  );
}

export default App;
