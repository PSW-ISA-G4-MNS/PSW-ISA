import { API_URL } from "./../../config";
import axios from "axios"

export default class CalendarService
{
    constructor(self) 
    {
        this.self = self;
    }
    static list() 
    {
        return axios.get(API_URL + "/care/all/");
    }

    static reservate(id)
    {
        return axios.put(API_URL + "/careRequest/reservate/" + id);
    }

    static getCares(id) 
    {
        return axios.get(API_URL + "/care/careForDoctor/"+ id);
    }

    static getOperations(id) 
    {
        return axios.get(API_URL + "/operation/operationForDoctor/"+ id);
    }

    static getVacation(id) 
    {
        return axios.get(API_URL + "/doctor/vacationDoctor/"+ id);
    }

}