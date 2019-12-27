import { API_URL } from "./../../config";
import axios from "axios"

export default class AuthenticatePrescriptionService
{
    constructor(self) 
    {
        this.self = self;
    }
    static list() 
    {
        return axios.get(API_URL + "/authenticateRequests/all/");
    }

    static accept(id)
    {
        return axios.put(API_URL + "/authenticateRequests/approve/" + id);
    }

    static decline(id)
    {
        return axios.put(API_URL + "/authenticateRequests/decline/"+id);
    }

    static get(id) 
    {
        return axios.get(API_URL + "/authenticateRequests/" + id);
    }

    
}
