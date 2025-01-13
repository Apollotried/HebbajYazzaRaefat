import axiosInstance from "./axiosInstance";

export const fetchStudents = async () => {
    const response = await axiosInstance.get("/ETUDIANT-SERVICE/api/students");
    return response.data;
};

export const fetchStudentCount = async () => {
    const response = await axiosInstance.get("/ETUDIANT-SERVICE/api/students/count");
    return response.data;
}


export const fetchStudentById = async (id) => {
    const response = await axiosInstance.get(`/ETUDIANT-SERVICE/api/students/${id}`);

    return response.data;
}

export const addStudent = async (student) => {
    const response = await axiosInstance.post("/students", student);
    return response.data;
};
