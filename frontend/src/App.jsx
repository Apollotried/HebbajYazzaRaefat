import { useState } from 'react'
import './App.css'
import "./index.css"
import Landing from "./Landing.jsx";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import StudentManagement from "./StudentManagement.jsx";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import EditStudent from "./components/EditStudent.jsx";
import CoursesManagement from "./CoursesManagement.jsx";

import ResultManagement from "./ResultManagement.jsx"
import EditCourse from "./components/CoursesManagement/EditCourse.jsx";

import AddSyllabus from "./components/CoursesManagement/CourseList/addSyllabus.jsx";
import ViewSyllabus from "./components/CoursesManagement/CourseList/viewSyllabus.jsx";
import GradeManagement from "./GradeManagement.jsx";


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
                  <Route path="/edit-course/:id" element={<EditCourse />} />
                  <Route path="/add-syllabus" element={<AddSyllabus />} />
                  <Route path="/view-syllabus" element={<ViewSyllabus />} />
                  <Route path="/courses" element={<CoursesManagement />} />
                  <Route path="/results" element={<ResultManagement />} />
                  <Route path="/grades" element={<GradeManagement />} />
              </Routes>
          </div>

      </Router>


  )
}

export default App
