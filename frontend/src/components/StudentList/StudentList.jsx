import React from 'react';


const StudentList = () => {
    // Static data for now
    const students = [
        { id: 1, nom: 'Dupont', prenom: 'Jean', nom_cours: 'Cours A' },
        { id: 2, nom: 'Martin', prenom: 'Marie', nom_cours: 'Cours B' },
        { id: 3, nom: 'Durand', prenom: 'Luc', nom_cours: 'Cours C' },
    ];

    return (
        <div className="listeEtud">
            <h2>Liste des Étudiants Inscrits</h2>
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
                    <th>Cours</th>
                </tr>
                </thead>
                <tbody>
                {students.map(student => (
                    <tr key={student.id}>
                        <td>{student.id}</td>
                        <td>{student.nom}</td>
                        <td>{student.prenom}</td>
                        <td>{student.nom_cours}</td>
                    </tr>
                ))}
                </tbody>
            </table>

        </div>
    );
};

export default StudentList;
