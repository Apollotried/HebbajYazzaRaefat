import React, { useEffect, useState } from "react";
import { fetchStudents } from "../../api/studentApi";
import {fetchStudentById} from "../../api/studentApi";
import './StudentList.css';
import Modal from 'react-modal';


const StudentList = () => {
    const [students, setStudents] = useState([]);
    const [selectedStudent, setSelectedStudent] = useState(null);
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [coursesOpen, setCoursesOpen] = useState(false);

    // Example courses data
     const exampleCourses = [
     { id: 1, name: 'Mathématiques Avancées', professor: 'Dr. Dupont' },
     { id: 2, name: 'Informatique', professor: 'Mme. Bernard' },
     { id: 3, name: 'Physique Quantique', professor: 'Dr. Martin' } ];

    useEffect(() => {
        const getStudents = async () => {
            try {
                const fetchedStudents = await fetchStudents();
                setStudents(fetchedStudents);
                console.log("Fetched Students:", fetchedStudents);
            } catch (error) {
                console.error("Error fetching students:", error);
            }
        };

        getStudents();
    }, []);
    const handleRowClick = async (id) => {
        try{
            const student = await fetchStudentById(id);
            setSelectedStudent(student);
            setModalIsOpen(true);
        }catch(error){
            console.error("Error fetching student id:", error);
        }

    };

    const closeModal = ()=>{
        setModalIsOpen(false);
        setSelectedStudent(null);
    }
    return (
        <main>
            <h1>Gestion Des Ecoles 2024/2025</h1>
            <div className="hori">
                <h6 className="title">Gestion des Etudiants</h6>
                <div className="config">
                    <a><i className="fas fa-user"></i> admin</a>
                    <a><i className="fas fa-sign-out-alt"></i> se déconnecter</a>
                </div>
            </div>

            <div className="listeEtud">
                <div className="containerFlex">
                    <h2>Liste des Étudiants</h2>
                    <button className="ajouter">Ajouter un nouveau etudiant</button>
                </div>

                <form action="" method="GET" className="searchBar">
                <input
                        type="text"
                        id="search"
                        placeholder="Rechercher par nom, prénom ou code..."
                        name="search"
                    />
                    <button type="submit">Chercher</button>
                </form>
                <table>
                    <thead>
                    <tr>
                        <th>Code</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                    </tr>
                    </thead>
                    <tbody>
                    {students.map(student => (
                        <tr key={student.id} onClick={() => handleRowClick(student.id)} style={{cursor: 'pointer'}}>
                            <td>{student.id}</td>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td>{student.email}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>

                {selectedStudent && (
                    <Modal
                        isOpen={modalIsOpen}
                        onRequestClose={closeModal}
                        contentLabel="Student Details"
                        className="Modal"
                        overlayClassName="Overlay"
                    >
                        <h2>Détails de l'étudiant</h2>
                        <p><strong>Id:</strong> {selectedStudent.id}</p>
                        <p><strong>Nom:</strong> {selectedStudent.firstName} {selectedStudent.lastName}</p>
                        <p><strong>Email:</strong> {selectedStudent.email}</p>
                        <p><strong>Phone:</strong> {selectedStudent.phone}</p>
                        <p><strong>Address:</strong> {selectedStudent.address}</p>
                        <p><strong>Genre:</strong> {selectedStudent.gender}</p>
                        <p><strong>Date de Naissance:</strong> {selectedStudent.gender}</p>
                        <h3 onClick={() => setCoursesOpen(!coursesOpen)} style={{cursor: 'pointer'}}>
                            Cours Inscrits {coursesOpen ? '-' : '+'}
                        </h3>
                        {coursesOpen && (
                            <ul>
                                {exampleCourses.map(course => (
                                    <li key={course.id}>{course.name} - {course.professor}</li>
                                ))}
                            </ul>
                        )}


                        <button onClick={closeModal}>Fermer</button>
                    </Modal>
                )}

            </div>

        </main>


    );
};

export default StudentList;
