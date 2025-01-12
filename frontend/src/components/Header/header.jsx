import React from 'react';
import './header.css';
import '../styles.css';
import {Link} from "react-router-dom";

const Header = () => {
    return (
        <header>
            <img src="../../../public/logo.png" alt="Logo" />
            <nav className="vert">
                <ul>
                    <Link to ="/"><li><i className="fas fa-home"></i> Accueil</li></Link>
                    <Link to="/students"><li><i className="fas fa-user-graduate"></i> Gestion des Etudiants</li></Link>
                    <li><i className="fas fa-book"></i> Gestion des Cours</li>
                    <li><i className="fas fa-user-tie"></i> Gestion des Enseignants</li>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
