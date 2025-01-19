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
                    <Link to="/">
                        <li><i className="fas fa-home"></i> Accueil</li>
                    </Link>
                    <Link to="/students">
                        <li><i className="fas fa-user-graduate"></i> Gestion des Etudiants</li>
                    </Link>
                    <Link to="/courses">
                        <li><i className="fas fa-book"></i> Gestion des Cours</li>
                    </Link>
                    <Link to="/grades">
                        <li><i className="fas fa-book-open"></i> Gestion des Notes</li>
                    </Link>
                    <Link to="/results">
                        <li><i className="fas fa-graduation-cap"></i> Gestion des Résultats</li></Link>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
