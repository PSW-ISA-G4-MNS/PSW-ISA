import { API_URL } from "./../../config";
import axios from "axios"

export default class VacationRequestService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/vacation/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/vacation/" + id);
    }
    
    
    
    static approve(id, data) 
    {
        return axios.post(API_URL + "/vacation/" + id + "/approve", data);
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/vacation/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/vacation/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/vacation/" + id);
    }
}
