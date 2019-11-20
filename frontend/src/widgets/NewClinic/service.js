import { API_URL } from "../../config";
import axios from "axios"

export default class PatientProfileService
{
    constructor(self)
    {
        this.self = self;
    }

    static show()
    {
        return axios.get(API_URL + "/profile");
    }

}