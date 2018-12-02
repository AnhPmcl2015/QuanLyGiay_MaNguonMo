import * as types from '../constants/ActionTypes';

var initialState = {
    listTenGiay: []
}

var myReducer = (state = initialState, action) => {
    switch (action.type) {
        case types.LIST_TEN_GIAY:
            state.listTenGiay = action.listTenGiay;
            return state;
        default:
            return state;
    }
};

export default myReducer;