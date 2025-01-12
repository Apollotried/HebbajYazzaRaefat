import React, { useEffect, useState } from "react";
import { fetchStudents } from "../../api/studentApi";
import './StudentList.css';

const StudentList = () => {
    const [students, setStudents] = useState([]);

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
                <h2>Liste des Étudiants</h2>
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
                        <tr key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.firstName}</td>
                            <td>{student.lastName}</td>
                            <td>{student.email}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </div>

        </main>


    );
};

export default StudentList;
