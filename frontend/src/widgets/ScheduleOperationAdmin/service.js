import { API_URL } from "./../../config";
import axios from "axios"

export default class ScheduleOperationService
{
    constructor(self) 
    {
        this.self = self;
    }
    static list() 
    {
        return axios.get(API_URL + "/operationRequest/forClinic");
    }

    static doctors(){
        return axios.get(API_URL + "/doctor/forClinic");
    }

    static reservate(x){
        return axios.post(API_URL + "/operation/adminSave",x);
    }

    static deleteOperationRequest(id){
        return axios.get(API_URL + "/operationRequest/delete/"+id);
    }
}