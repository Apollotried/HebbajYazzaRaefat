import { useState } from 'react'
import './App.css'
import "./index.css"
import Landing from "./Landing.jsx";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import StudentManagement from "./StudentManagement.jsx";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import EditStudent from "./components/EditStudent.jsx";


function App() {
  const [count, setCount] = useState(0)

  return (
      <Router>
          <div>
              <ToastContainer />
              <Routes>

                  <Route path="/" element={<Landing />} />
                  <Route path="/students" element={<StudentManagement />} />
                  <Route path="/edit-student/:id" element={<EditStudent />} />
              </Routes>
          </div>

      </Router>


  )
}

export default App
