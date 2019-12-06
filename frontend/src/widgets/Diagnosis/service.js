import { API_URL } from "../../config";
import axios from "axios"

export default class  DiagnosisService
{
    constructor(self)
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/diagnosis/");
    }

    static submit(x)
    {
        return axios.post(API_URL + "/diagnosis", x);
    }
}