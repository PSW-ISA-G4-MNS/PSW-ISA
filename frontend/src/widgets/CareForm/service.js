import { API_URL } from "./../../config";
import axios from "axios"

export default class CareFormService 
{
    constructor(self) 
    {
        this.self = self;
    }


    static submit(x)
    {
        return axios.post(API_URL + "/care/", x);
    }
}