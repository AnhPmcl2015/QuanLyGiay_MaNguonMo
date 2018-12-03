import { request } from '../APIUtils';
import { API_BASE_URL } from '../../Common/Constants/common';

const PAGE_URL = '/invoice';
export function getOrderDetail(id) {
    return request({
        url: API_BASE_URL + PAGE_URL + "/get-order-detail?id=" + id,
        method: 'GET'
    });
}