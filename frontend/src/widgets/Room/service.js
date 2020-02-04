import { API_URL } from "./../../config";
import axios from "axios"

export default class RoomService 
{
    constructor(self) 
    {
        this.self = self;
    }

    static list() 
    {
        return axios.get(API_URL + "/room/");
    }

    static get(id) 
    {
        return axios.get(API_URL + "/room/" + id);
    }
    
    
    
    static cares(id) 
    {
        return axios.get(API_URL + "/room/" + id + "/cares");
    }
    
    

    static create(x)
    {
        return axios.post(API_URL + "/room/", x);
    }

    static update(id, data) 
    {
        return axios.post(API_URL + "/room/" + id, data);
    }

    static delete(id) 
    {
        return axios.delete(API_URL + "/room/" + id);
    }

    static next(id) {
        return axios.get(API_URL + "/room/" + id + "/next");
    }
}