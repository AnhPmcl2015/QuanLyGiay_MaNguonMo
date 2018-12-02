import * as types from '../constants/ActionTypes';

export const list_ten_giay = (listTenGiay) => {
    return {
        type: types.LIST_TEN_GIAY,
        listTenGiay
    }
};