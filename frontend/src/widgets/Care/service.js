import { API_URL } from "./../../config";
import axios from "axios"

export default class CareService
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

    static get(id) 
    {
        return axios.get(API_URL + "/care/" + id);
    }

}