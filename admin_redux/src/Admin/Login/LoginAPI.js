import { request } from '../APIUtils';
import { API_BASE_URL } from '../../Common/Constants/common';

export function login(loginRequest) {
    return request({
        url: API_BASE_URL + "/auth/signin",
        method: 'POST',
        body: JSON.stringify(loginRequest)
    });
}