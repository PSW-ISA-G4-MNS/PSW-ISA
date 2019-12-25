import { API_URL } from "./../../config";
import axios from "axios"

export default class ReviewService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static get(id) 
    {
        return axios.get(API_URL + "/care/");
    
    }

    static submit(id) 
    {
        return axios.post(API_URL + "/care/" + id);
    }

}