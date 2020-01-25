import { API_URL } from "./../../config";
import axios from "axios"

export default class DoctorService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/doctor/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/doctor/" + id);
    }
    
    
    
    static password(id, data) 
    {
        return axios.post(API_URL + "/doctor/" + id + "/password", data);
    }
    
    
    
    static cares(id) 
    {
        return axios.get(API_URL + "/doctor/" + id + "/cares");
    }
    
    
    
    static assignCare(id, data) 
    {
        return axios.post(API_URL + "/doctor/" + id + "/assignCare", data);
    }
    
    
    
    static submit(data) 
    {
        return axios.post(API_URL + "/adminClinic/clinicDoctors/", data);
    }
    
    static listForClinic() 
    {
        return axios.get(API_URL + "/adminClinic/clinicDoctors/");
    }
    
    
    
    static vacationRequests(id) 
    {
        return axios.get(API_URL + "/doctor/" + id + "/vacationRequests");
    }
    
    
    
    static vacationRequestsNew(id, data) 
    {
        return axios.post(API_URL + "/doctor/" + id + "/vacationRequestsNew", data);
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/doctor/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/doctor/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/adminClinic/clinicDoctors/" + id);
    }
}
