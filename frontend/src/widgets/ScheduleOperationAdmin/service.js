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
        return axios.get(API_URL + "/operationRequests");
    }

    static listPredefinedCaresForClinic(id) 
    {
        return axios.get(API_URL + "/care/getPredefindedCaresForClinic/" + id);
    }

    static reservate(id)
    {
        return axios.post(API_URL + "/care/reservate/" + id);
    }

    static get(id) 
    {
        return axios.get(API_URL + "/care/" + id);
    }

}