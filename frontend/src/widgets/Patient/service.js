import { API_URL } from "../../config";
import axios from "axios"

export default class PatientService
{
    constructor(self)
    {
        this.self = self;
    }

    static get()
    {
        return axios.get(API_URL + "/patients");
    }

    static getAll()
    {
        return axios.get(API_URL + "/patients/all");
    }

    static getSingle(id){
        return  axios.get(API_URL + "/patients/"+id);
    }

    static  careRequest(id, x) {
        return axios.post(API_URL + "/care/scheduleForPatient/" + id, x);
    } 
    
    static  operationRequest(x) {
        return axios.post(API_URL + "/operationRequest", x);
    } 

}