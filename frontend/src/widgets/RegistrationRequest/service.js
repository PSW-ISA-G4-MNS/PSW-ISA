import { API_URL } from "./../../config";
import axios from "axios"

export default class RegistrationRequestService
{
    constructor(self) 
    {
        this.self = self;
    }


    static accept(id)
    {
        return axios.post(API_URL + "/registrationRequests/approved/"+id);
    }

    static decline(id)
    {
        return axios.post(API_URL + "/registrationRequests/decline/"+id);
    }

}
