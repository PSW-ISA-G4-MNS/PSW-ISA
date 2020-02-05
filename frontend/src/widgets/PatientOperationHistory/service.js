import { API_URL } from "../../config";
import axios from "axios"

export default class OperationHistoryService
{
    constructor(self)
    {
        this.self = self;
    }

    static getOperationHistory()
    {
        return axios.get(API_URL + "/operation/history");
    }

    static filterOperationHistory(date)
    {
        return axios.get(API_URL + "/operation/history/" + date);
    }

}