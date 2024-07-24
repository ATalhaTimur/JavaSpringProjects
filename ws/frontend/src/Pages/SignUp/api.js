import axios from "axios";

export function signUp(body) {
    return axios.post("/api/1.0/users", body);
}