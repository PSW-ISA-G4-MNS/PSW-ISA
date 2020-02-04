import { API_URL } from "../../config";
import axios from "axios"

export default class CareHistoryService
{
    constructor(self)
    {
        this.self = self;
    }

    static getCareHistory()
    {
        return axios.get(API_URL + "/care/history");
    }

    static filterCareHistory(careTypeID, date)
    {
        return axios.get(API_URL + "/care/history/" + careTypeID + "/" + date);
    }

}