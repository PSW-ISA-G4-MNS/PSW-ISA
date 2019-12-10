import { API_URL } from "./../../config";
import axios from "axios"

export default class CareTypeService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/careType/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/careType/" + id);
    }
    
    
    static create(x)
    {
        return axios.post(API_URL + "/careType/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/careType/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/careType/" + id);
    }
}