import { API_URL } from "./../../config";
import axios from "axios"

export default class AddAdminClinicService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static accept(id)
    {
        return axios.post(API_URL + "/adminClinic/"+id);
    }

    static list() 
    {
        return axios.get(API_URL + "/adminClinic/all/");
    }
    static get(id) 
    {
        return axios.get(API_URL + "/adminClinic/" + id);
    }
}