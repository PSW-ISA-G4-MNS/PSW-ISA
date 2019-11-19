import { API_URL } from "../../config";
import axios from "axios"

export default class PatientService
{
    constructor(self)
    {
        this.self = self;
    }

    static get()
    {
        return axios.get(API_URL + "/patients");
    }

}