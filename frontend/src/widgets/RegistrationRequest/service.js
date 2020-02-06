import { API_URL } from "./../../config";
import axios from "axios"

export default class RegistrationRequestService
{
    constructor(self) 
    {
        this.self = self;
    }
    static list() 
    {
        return axios.get(API_URL + "/registrationRequests/all/");
    }

    static accept(id)
    {
        return axios.put(API_URL + "/registrationRequests/approve/" + id);
    }

    static decline(id)
    {
        return axios.put(API_URL+"/registrationRequests/decline/" + id);
    }

    

    static get(id) 
    {
        return axios.get(API_URL + "/registrationRequests/" + id);
    }

    static sentResponse(id) 
    {
        return axios.get(API_URL + "/registrationRequests/response" + id);
    }
}
