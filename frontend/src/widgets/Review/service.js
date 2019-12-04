import { API_URL } from "./../../config";
import axios from "axios"

export default class ReviewService 
{
    constructor(self) 
    {
        this.self = self;
    }


    static getDiagnosis() 
    {
        return axios.get(API_URL + "/adminClinic/all/");
    }

    static getDrugs() 
    {
        return axios.get(API_URL + "/adminClinic/all/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/adminClinic/" + id);
    }

    static addDrug(id) 
    {
        return axios.post(API_URL + "/adminClinic/" + id);
    }

    static submit(id) 
    {
        return axios.post(API_URL + "/adminClinic/" + id);
    }
}