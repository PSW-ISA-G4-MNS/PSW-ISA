import { API_URL } from "../../config";
import axios from "axios"

export default class  MedicineService
{
    constructor(self)
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/medicine/");
    }
    static submit(x)
    {
        return axios.post(API_URL + "/medicine", x);
    }
}