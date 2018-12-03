import {
    getGiayById
} from '../types';

export const GetGiayById = idGiayData => dispatch => {
    fetch("/admin/api/shoe/get-giay-by-id", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(idGiayData)
        }).then(res => res.json())
        .then(
            result => {
               
                dispatch({
                    type: getGiayById.GET_GIAY_BY_ID,
                    payload: result
                })
            },
            error => {
                console.log('Lỗi không get giay từ id ' + error);
            }
        )
};