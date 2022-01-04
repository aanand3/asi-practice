import axios, { AxiosError } from 'axios';

export const httpClient = axios.create({ headers: { Accept: 'application/json' } });

export function isAxiosError<T = any>(error: AxiosError | any): error is AxiosError<T> {
    return error && error.isAxiosError;
}
