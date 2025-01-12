import axiosInstance from "./axiosInstance";

export const fetchStudents = async () => {
    const response = await axiosInstance.get("/students");
    return response.data;
};

export const fetchStudentCount = async () => {
    const response = await axiosInstance.get("/students/count");
    return response.data;
}

export const addStudent = async (student) => {
    const response = await axiosInstance.post("/students", student);
    return response.data;
};
