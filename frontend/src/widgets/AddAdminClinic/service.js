import { API_URL } from "./../../config";
import axios from "axios"

export default class AddAdminClinicService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static submit(id)
    {
        return axios.post(API_URL + "/adminClinic/"+id);
    }

    static list() 
    {
        return axios.get(API_URL + "/adminClinic/all");
    }
    
    static add(x){
        return axios.post(API_URL+"/adminClinic/addClinic",x)
    }

    static getClinics(){
        return axios.get(API_URL + "/clinic");
    }


    static get(id) 
    {
        return axios.get(API_URL + "/adminClinic/" + id);
    }
}