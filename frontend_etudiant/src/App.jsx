// App.jsx

import { useState } from 'react';
import './App.css';
import './index.css';
import Landing from './Landing.jsx';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import StudentDetails from './StudentDetails.jsx';  // L'importation par défaut
import StudentResults from "./StudentResults.jsx";

function App() {
    return (
        <Router>
            <div>
                <ToastContainer />
                <Routes>
                    <Route path="/" element={<Landing />} />
                    <Route path="/StudentDetails" element={<StudentDetails />} />
                    <Route path="/StudentResults" element={<StudentResults />} />
                </Routes>
            </div>
        </Router>
    );
}

export default App;
