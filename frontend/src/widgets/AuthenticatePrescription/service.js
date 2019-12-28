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
        return axios.get(API_URL + "/care/notApproved");
    }

   

    
}
