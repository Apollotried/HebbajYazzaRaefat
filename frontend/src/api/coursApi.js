import axiosInstance from "./axiosInstance";

export const fetchCoursCount = async () => {
    const response = await axiosInstance.get("/courses/count");
    return response.data;
}