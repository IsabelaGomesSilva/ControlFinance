import axios, { AxiosPromise } from "axios"
import { AccountData } from "../interface/AccountData";
import { useQuery } from "@tanstack/react-query";

const API_URL = 'http://localhost:8080/api/v1';

const fetchData = async ():AxiosPromise<AccountData[]> => {
    const response = axios.get(API_URL + '/accounts');
    return response;
}

export function useAccountData(){
    const query = useQuery({
        queryFn: fetchData,
        queryKey:['account-data'],
        retry:2
    })

    return {
        ...query,
        data: query.data?.data
    }
}