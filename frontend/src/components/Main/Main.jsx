import React from 'react';
import './Main.css';
import Card from "../Card/Card.jsx";
import StudentList from "../StudentList/StudentList.jsx";

const Main = () => (
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
            <Card />
            <Card />
            <Card />
            <Card />
        </div>

        <StudentList />
    </main>
);

export default Main;
