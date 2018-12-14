import React, { PureComponent, Fragment } from 'react';
import { connect } from 'dva';
import {
  Row,
  Col,
  Card,
  Form,
  Table,
  Input,
  Select,
  Spin,
  Icon,
  Button,
  Dropdown,
  Menu,
  Modal,
  message,
  Divider,
  Steps,
} from 'antd';
import debounce from 'lodash/debounce';
import DescriptionList from '@/components/DescriptionList';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import FieldList from './fieldList';
import IndexList from './indexList'
import { stringify } from 'qs';

const { Description } = DescriptionList;

const FormItem = Form.Item;
const Option =Select.Option;
const Search = Input.Search;

import styles from './TableList.less';
import { log } from 'util';

@Form.create()
class EditFormBean extends PureComponent {
  constructor(props) {
    super(props);
    this.lastFetchId =0;
    this.fetchSource = debounce(this.fetchSource,800);
    this.state = {
      formVals: {
        classId : props.values.id,
        className: props.values.className,
        classCnName: props.values.classCnName,
        remark: props.values.remark,
      },
      loading:false,
      data:[],
      value:"",
      dbValue:"",
      fetching:false,
      sourceData:[],   
    };
  }

  state ={
    
  }

  componentDidMount() {    
    this.fetchSource();
  }

  
  okHandle = () => {
    const { form, handleEditField } = this.props;
    const { formVals: oldValue } = this.state;
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      const formVals = { ...oldValue, ...fieldsValue };
      this.setState({formVals,},
        () => {          
            handleEditField(formVals);
        }
      );
    });
  };
  
  fetchSource = (value) => {
    console.log('fetching user', value);
    this.lastFetchId += 1;
    const fetchId = this.lastFetchId;
    this.setState({ sourceData: [] });
    fetch('/api/databaseConfigs/list')
      .then(response => response.json())
      .then((body) => {
        if (fetchId !== this.lastFetchId) { // for fetch callback order
          return;
        }
        const sourceData = body.list.map(item => ({
          text: `${item.id} ${item.name}`,
          value: item.id,
        }));
        // const dbValue = sourceData.length>0 ? sourceData[0]:'';
        this.setState({ sourceData });
      });
  }

  handleDBChange =(dbValue) =>{
    this.setState({
      dbValue,
    });
  }

  handleSearch = value =>{
    const {dbValue} = this.state;
    const param={baseId:dbValue,tableName:value};
    this.setState({ data: [], fetching: true });
    fetch(`/api/gemfireFields/findTableField?${stringify(param)}`)
      .then(response => response.json())
      .then((body) => {
        console.log(body);
        const data = body.list.map((item,index) => ({
          id: `NEW_TEMP_ID_${index}`,
          fieldCode: item.fieldCode,
          fieldName: item.fieldName,
          fieldType: item.fieldType,
          comment: item.fieldName,
          editable:false,     
        }));
        this.setState({ data, fetching: false });
      });
  }


  render() {
    const { modalVisible, handleEditBeanModalVisible, form } = this.props;
    const { formVals, loading, value, dbValue, sourceData, fetching, data } = this.state;

    return (
      <Modal
        width={1280}
        bodyStyle={{ padding: '10px 40px 48px' }}
        destroyOnClose
        visible={modalVisible}
        title="编辑Bean字段"
        onOk={this.okHandle}
        onCancel={() => handleEditBeanModalVisible()}
      >
        <DescriptionList size="large" title="Bean信息">
          <Description term="类名称">{formVals.className}</Description>
          <Description term="类中文名称">{formVals.classCnName}</Description>
        </DescriptionList>
        
        <Divider />
        <Row>
          <Col span={8}><div className={styles.title}>字段信息</div> </Col>
          <Col span={16} style={{textAlign:"right"}}>
            <Select
              showSearch
              value={dbValue}
              style={{ width: 200, marginRight:10  }}
              placeholder="Select a DB"
              optionFilterProp="children"
              onChange={this.handleDBChange}
              filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}              
            >
              {sourceData.map(d => <Option key={d.value}>{d.text}</Option>)}
            </Select>

            <Search
              style={{width:300, marginRight:10}}
              placeholder="input search table name"
              onSearch={this.handleSearch}
              enterButton="添加字段"
            />
          </Col>
        </Row>        
        <FieldList data={data} loading={fetching} />
        <Divider />
        <Row>
          <Col span={8}><div className={styles.title}>索引信息</div> </Col>
          <Col span={8} offset={8} style={{textAlign:"right"}}><Button type="primary">添加索引</Button></Col>
        </Row>
        <IndexList values={[]} />
      </Modal>
    );
  }
}


export default EditFormBean;
