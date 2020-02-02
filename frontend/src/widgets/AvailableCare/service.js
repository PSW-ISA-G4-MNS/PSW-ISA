import { API_URL } from "./../../config";
import axios from "axios"

export default class AvailableCareService
{
    constructor(self) 
    {
        this.self = self;
    }

    static availableCares(careTypeID, doctorID, date) 
    {
        return axios.get(API_URL + "/doctor/getAvailableCaresForDoctor/" + careTypeID + "/"+ doctorID + "/"+ date);
    }

    static sendCareRequest(careRequest)
    {
        return axios.post(API_URL + "/careRequest", careRequest);
    }
    
}