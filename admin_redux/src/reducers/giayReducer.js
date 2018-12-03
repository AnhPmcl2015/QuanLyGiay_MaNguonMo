import { getGiayById } from '../actions/types';

const initialState = {
  giayInfo: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case getGiayById.GET_GIAY_BY_ID:
      return {
        ...state,
        giayInfo: action.payload
      };
    default:
      return state;
  }
}