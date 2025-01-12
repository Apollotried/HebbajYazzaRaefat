// Main.js
import React, { useEffect, useState } from 'react';
import './Main.css';
import Card from "../Card/Card.jsx";
import StudentList from "../StudentList/StudentList.jsx";
import { fetchStudentCount } from '../../api/studentApi';

const Main = () => {
    const [studentCount, setStudentCount] = useState(null); // State to hold student count

    useEffect(() => {
        const getStudentCount = async () => {
            try {
                const count = await fetchStudentCount();
                setStudentCount(count);
            } catch (error) {
                console.error("Error fetching student count:", error);
            }
        };

        getStudentCount();
    }, []); // Empty dependency array to run only once on mount

    return (
        <main>
            <h1>Gestion Des Ecoles 2024/2025</h1>
            <div className="hori">
                <h6 className="title">Page d'accueil</h6>
                <div className="config">
                    <a><i className="fas fa-user"></i> admin</a>
                    <a><i className="fas fa-sign-out-alt"></i> se déconnecter</a>
                </div>
            </div>

            <div className="cards">
                {/* Pass the studentCount to the Card component */}
                <Card
                    count={studentCount}
                    label="Etudiants"
                    description="Nombre d'étudiants"
                />
            </div>

            <StudentList />
        </main>
    );
};

export default Main;
