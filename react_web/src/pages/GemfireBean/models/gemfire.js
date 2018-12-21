import { message } from 'antd';
import { queryGemfireBean, removeGemfireBean, addGemfireBean, updateGemfireBean,batchAddFieldGemfireBean,saveField,queryFieldInfo } from '@/services/api';

export default {
  namespace: 'gemfire',

  state: {
    data: {
      list: [],
      pagination: {},
    },
    loading: false,
  },

  effects: {
    *fetch({ payload }, { call, put }) {
      const response = yield call(queryGemfireBean, payload);
      yield put({
        type: 'query',
        payload: response,
      });
    },
    *add({ payload, callback }, { call,put }) {
       const response = yield call(addGemfireBean, payload);
       if(response.code ===200){
        message.success('提交成功!');
        const rps = yield call(queryGemfireBean, {});
        yield put({
          type: 'query',
          payload: rps,
        });
       }else{
        message.error('提交失败!');
       }
      // yield call(addGemfireBean, payload);
      
      if (callback) callback();
    },
    *batchAddField({ payload, callback }, { call,put }) {
      const response = yield call(batchAddFieldGemfireBean, payload);
      if(response.code ===200){
       message.success('提交成功!');
       const rps = yield call(queryGemfireBean, {});
       yield put({
         type: 'query',
         payload: rps,
       });
      }else{
       message.error('提交失败!');
      }
     // yield call(addGemfireBean, payload);
     
     if (callback) callback();
   },
    *remove({ payload, callback }, { call, put }) {
      const response = yield call(removeGemfireBean, payload);
      if(response.code ===200){
        message.success('删除成功!'); 
        const rps = yield call(queryGemfireBean, {});
        yield put({
          type: 'query',
          payload: rps,
        });      
       }else{
        message.error('删除失败!');
       }
      if (callback) callback();
    },
    *update({ payload, callback }, { call }) {
      const response = yield call(updateGemfireBean, payload);
       if(response.code ===200){
        message.success('提交成功!');
       }else{
        message.error('提交失败!');
       }
      if (callback) callback();
    },
  },
 
  reducers: {
    save(state, action) {
      return {
        ...state,
        data: action.payload,
      };
    },
    query(state,action){
      return {
          ...state,
          data: action.payload,
        }
    },
    queryField(state,action){
      return {
          ...state,
          data: action.payload.fieldList,
          indexData: action.payload.indexList
        }
    }

  },
};
