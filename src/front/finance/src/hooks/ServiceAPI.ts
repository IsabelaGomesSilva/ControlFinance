import axios, { AxiosPromise } from "axios"
import { AccountData } from "../interface/AccountData";
import { useQuery } from "@tanstack/react-query";
import { CashData } from "../interface/CashData";
import { ExpensesData } from "../interface/ExpensesData";

const apiUrl = import.meta.env.VITE_API_URL

const fetchAccount = async ():AxiosPromise<AccountData[]> => {
    const response = axios.get(apiUrl + '/accounts');
    return response;
}

export function useAccountData(){
    const query = useQuery({
        queryFn: fetchAccount,
        queryKey:['account-data'],
        retry:2
    })

    return {
        ...query,
        data: query.data?.data
    }
}
const fetchCash = async ():AxiosPromise<CashData[]> => {
    const response = axios.get(apiUrl + '/cash');
    return response;
}

export function useCashData(){
    const query = useQuery({
        queryFn: fetchCash,
        queryKey:['cash-data'],
        retry:2
    })

    return {
        ...query,
        data: query.data?.data
    }
}
const fetchExpenses = async ():AxiosPromise<ExpensesData[]> => {
    const response = axios.get(apiUrl + '/expenses');
    return response;
}

export function useExpensesData(){
    const query = useQuery({
        queryFn: fetchExpenses,
        queryKey:['expenses-data'],
        retry:2
    })

    return {
        ...query,
        data: query.data?.data
    }
}