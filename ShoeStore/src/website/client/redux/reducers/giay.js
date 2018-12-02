import * as types from '../constants/ActionTypes';

var myReducer = (state = {}, action) => {
    switch (action.type) {
        case types.LIST_GIAY:
            return state;
        default:
            return state;
    }
};

export default myReducer;