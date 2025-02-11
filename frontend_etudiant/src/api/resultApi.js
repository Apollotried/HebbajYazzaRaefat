import axiosInstance from "./axiosInstance.js";

export const fetchResultDetailsByStudentId = async (studentId) => {
    const response = await axiosInstance.get(`/RESULTAT-SERVICE/api/results/details/${studentId}`);
    return response.data;
}

export const fetchResultsByStudent = async (studentId) => {
    const response = await axiosInstance.get(`/RESULTAT-SERVICE/api/results/student/${studentId}`);
    return response.data;
}

export const fetchCourseInfo = async (id) => {
    const response = await axiosInstance.get(`/RESULTAT-SERVICE/api/results/course-info/${id}`);
    return response.data;
}



export const fetchStudentsGradeByCoursId = async (courseId) => {
    const response = await axiosInstance.get(`/RESULTAT-SERVICE/api/results/course/${courseId}/students-grades`);
    return response.data;
}

