import { API_URL } from "./../../config";
import axios from "axios"

export default class OldReviewChangeService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static get(id) 
    {
        return axios.get(API_URL + "/care/" + id);
    
    }

    static list() 
    {
        return axios.get(API_URL + "/care/oldReviews/");
    }

    static getMedicalRecord(id) 
    {
        return axios.get(API_URL + "/medicalRecord/" + id);
    
    }

    static submit(x) 
    {
        return axios.post(API_URL + "/care/review/", x);
    }

    static change(x) 
    {
        return axios.post(API_URL + "/medicalRecord/change/", x);
    }
   
   

    static accept(x) 
    {
        return axios.post(API_URL + "/prescription", x);
    }
}