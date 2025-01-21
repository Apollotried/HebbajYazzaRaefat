import React from 'react';
import './header.css';
import '../styles.css';
import { Link } from "react-router-dom";

const Header = () => {
    return (
        <header>
            <img src="/logo.png" alt="Logo" />
            <nav className="vert">
                <ul>
                    <Link to="/"><li><i className="fas fa-home"></i> Accueil</li></Link>
                    <Link to="/students"><li><i className="fas fa-user-graduate"></i> Gestion des Étudiants</li></Link>
                    <Link to="/courses"><li><i className="fas fa-book"></i> Gestion des Cours</li></Link>
                    <Link to="/send-notification"><li><i className="fas fa-envelope"></i> Envoyer Notification</li></Link>
                    <Link to="/notifications"><li><i className="fas fa-bell"></i> Liste des Notifications</li></Link>
                    <Link to="/kafka-notifications"><li><i className="fas fa-exchange-alt"></i> Kafka Notifications</li></Link>
                </ul>
            </nav>
        </header>
    );
}

export default Header;
