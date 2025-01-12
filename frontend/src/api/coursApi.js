import axiosInstance from "./axiosInstance";

export const fetchCourses = async () => {
    const response = await axiosInstance.get("/COURS-SERVICE/api/courses");
    return response.data;
};

export const fetchCourseCount = async () => {
    const response = await axiosInstance.get("/COURS-SERVICE/api/courses/count");
    return response.data;
}