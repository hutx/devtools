import {message} from 'antd';
import {
  saveField,
  queryFieldInfo,
  batchAddField,
  batchAddFieldIndex
} from '@/services/api';

export default {
  namespace : 'field',

  state : {
    data: {
      fieldData:[],
      indexData:[],
    },
    loading: false
  },

  effects : {
    *fetchFieldInfo({
      payload
    }, {call, put}) {
      const response = yield call(queryFieldInfo, payload);
      yield put({type: 'queryField', payload: response});
    },
    *saveField({
      payload,
      callback
    }, {call}) {
      const response = yield call(saveField, payload);
      if (response.code === 200) {
        message.success('提交成功!');
      } else {
        message.error('提交失败!');
      }
      // yield call(addGemfireBean, payload);

      if (callback) 
        callback();
      }
    ,
    *batchAddField({
      payload,
      callback
    }, {call}) {
      const response = yield call(batchAddField, payload);
      if (response.code === 200) {
        message.success('提交成功!');
      } else {
        message.error('提交失败!');
      }
      // yield call(addGemfireBean, payload);

      if (callback) 
        callback();
      }
    ,
    *batchAddFieldIndex({
      payload,
      callback
    }, {call}) {
      const response = yield call(batchAddFieldIndex, payload);
      if (response.code === 200) {
        message.success('提交成功!');
      } else {
        message.error('提交失败!');
      }
      // yield call(addGemfireBean, payload);

      if (callback) 
        callback();
      }
    ,
    },

    reducers: {
      queryField(state, action) {
        return {
          ...state,
          data: action.payload.list,
        }
      }
    },
  };
