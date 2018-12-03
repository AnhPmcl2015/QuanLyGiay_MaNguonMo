import { request } from '../Common/APIUtils';
import { API_BASE_URL } from '../Common/Constant/common';

const PAGE_URL = '/invoice';
export function getOrderDetail(id) {
    return request({
        url: API_BASE_URL + PAGE_URL + "/get-order-detail?id=" + id,
        method: 'GET'
    });
}
