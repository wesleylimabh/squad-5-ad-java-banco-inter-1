import axios from "axios";
import {getToken} from "../services/auth"

const api = axios.create({
  // baseURL: "https://central-erros-squad5.herokuapp.com",
  baseURL: "http://localhost:8080",
  timeout: 5000,
});

api.interceptors.request.use(async config => {
  const token = getToken();
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
