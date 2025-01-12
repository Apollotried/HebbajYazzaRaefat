import { useState } from 'react'
import './App.css'
import "./index.css"
import Landing from "./Landing.jsx";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import StudentManagement from "./StudentManagement.jsx";

function App() {
  const [count, setCount] = useState(0)

  return (
      <Router>
        <Routes>
          <Route path="/" element={<Landing />} />
          <Route path="/students" element={<StudentManagement />} />
        </Routes>
      </Router>


  )
}

export default App
