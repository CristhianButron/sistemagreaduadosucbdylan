import axios from 'axios';

export class RequestHandler {
    constructor() {
        this.handler = axios.create({
            baseURL: "http://localhost:8080/api/v1", // URL base para el backend
        });
    }

    // Método para realizar una solicitud GET
    async getRequest(url, params = {}) {
        try {
            const response = await this.handler.get(url, { params });
            return response.data;
        } catch (error) {
            this.handleError(error);
        }
    }

    // Método para realizar una solicitud POST
    async postRequest(url, data = {}, params = {}) {
        try {
            const response = await this.handler.post(url, data, { params });
            return response.data;
        } catch (error) {
            this.handleError(error);
        }
    }

    // Método para realizar una solicitud PUT
    async putRequest(url, data = {}, params = {}) {
        try {
            const response = await this.handler.put(url, data, { params });
            return response.data;
        } catch (error) {
            this.handleError(error);
        }
    }

    // Método para realizar una solicitud DELETE
    async deleteRequest(url, params = {}) {
        try {
            const response = await this.handler.delete(url, { params });
            return response.data;
        } catch (error) {
            this.handleError(error);
        }
    }

    // Manejo centralizado de errores
    handleError(error) {
        if (error.response) {
            console.error('Error Response Data:', error.response.data);
            console.error('Error Response Status:', error.response.status);
            console.error('Error Response Headers:', error.response.headers);
        } else if (error.request) {
            console.error('No response received:', error.request);
        } else {
            console.error('Request Error:', error.message);
        }
        console.error('Config:', error.config);
    }
}
