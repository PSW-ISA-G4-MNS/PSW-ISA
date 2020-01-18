import { API_URL } from "./../../config";
import axios from "axios"

export default class ClinicService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/clinic/");
    }

    static report(id) 
    {
        return axios.get(API_URL + "/clinic/" + id + "/report/10");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/clinic/" + id);
    }
    
    
    
    static addRoom(id, data) 
    {
        return axios.post(API_URL + "/clinic/" + id + "/addRoom");
    }
    
    
    
    static addNurse(id, data) 
    {
        return axios.post(API_URL + "/clinic/" + id + "/addNurse");
    }
    
    
    
    static listEmployees(id) 
    {
        return axios.get(API_URL + "/clinic/" + id + "/listEmployees");
    }
    
    
    
    static listRooms(id) 
    {
        return axios.get(API_URL + "/clinic/" + id + "/listRooms");
    }
    
    
    
    static getAdmin(id) 
    {
        return axios.get(API_URL + "/clinic/" + id + "/getAdmin");
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/clinic/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/clinic/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/clinic/" + id);
    }
}
