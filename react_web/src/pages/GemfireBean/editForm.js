
import React, {PureComponent,Fragment} from 'react';
 import {connect} from 'dva';
import {
  Row,
  Col,
  Form,
  Input,
  Select,
  Button,
  Divider,
  Drawer,
} from 'antd';

import debounce from 'lodash/debounce';
import DescriptionList from '@/components/DescriptionList';
import FieldList from './fieldList';
import IndexList from './indexList'
import styles from './TableList.less';

const {Description} = DescriptionList;
// const  FormItem = Form.Item;
const {Option} = Select;
const {Search} = Input;

@connect(({field, loading}) => ({field, loading: loading.models.field}))
@Form.create()
class EditForm extends PureComponent {
  constructor(props) {
    super(props);
    this.lastFetchId = 0;
    this.fetchSource = debounce(this.fetchSource, 800);
    this.state = {
      formVals: {
        classId: props.values.id,
        className: props.values.className,
        classCnName: props.values.classCnName,
        remark: props.values.remark
      },
      loading: false,
      fieldData: [],
      indexData: [],
      value: "",
      dbValue: "",
      fetching: false,
      sourceData: [],
      selectFieldRows: [],
      
    };
  }

  componentDidMount() {
    this.fetchSource();

    const {formVals} = this.state;
    const {dispatch} = this.props;

    dispatch({
      type: 'field/fetchFieldInfo',
      payload: {
        classId:formVals.classId,
      }
    });
  }

  okHandle = () => {
    const {formVals, fieldData, indexData} = this.state;

    const {
      form: { validateFieldsAndScroll },
      dispatch,
      handleEditBeanModalVisible,
    } = this.props;
    validateFieldsAndScroll((error, values) => {
      if (!error) {
        const newData = values.field.map((item) => ({
          id: item.id.indexOf('NEW_TEMP_ID')? item.id :'',
          fieldCode: item.fieldCode,
          fieldName: item.fieldName,
          fieldType: item.fieldType,
          isKey: item.isKey,
          isNull: item.isNull,
          comment: item.fieldName,
          classId:formVals.classId
        }));        
       
      
        const newIndexData =values.index.map((item) =>({
          id: item.id.indexOf('NEW_INDEX_ID_')? item.id:'',
          fieldCode: item.fieldCode,
          classId:formVals.classId
        }));
      
        dispatch({
          type: 'field/saveField',
          payload: {
            fieldList:newData,
            indexList:newIndexData,
            classId:formVals.classId,
          }
        });       
      }
    });    
  
    handleEditBeanModalVisible();

  };

  fetchSource = () => {
    this.lastFetchId += 1;
    const fetchId = this.lastFetchId;
    this.setState({sourceData: []});
    fetch('/api/databaseConfigs/list')
      .then(response => response.json())
      .then((body) => {
        if (fetchId !== this.lastFetchId) { // for fetch callback order
          return;
        }
        const sourceData = body.list.map(item => ({text: `${item.id}_${item.name}`, value: item.id}));

        this.setState({
          sourceData,
          dbValue: sourceData[0].value || null
        });
      });
  }

  handleDBChange = (dbValue) => {
    this.setState({dbValue});
  }

  handleSearch = value => {
    const {dbValue} = this.state;
    const { form} = this.props;    
    const param = {
      baseId: dbValue,
      tableName: value
    };
    form.getFieldInstance('field').fetchField(param);
  }

  handleFieldChange = value => {
    this.setState({fieldData:value});

  }

  handleSelectFieldRows = rows => {
    this.setState({selectFieldRows: rows});
  }

  handleAddIndex = () => {
    const {selectFieldRows} = this.state;
    const { form} = this.props;
    
   form.getFieldInstance('index').handleAdd(selectFieldRows);
    // this.setState({indexData: newData});
    // form.getFieldInstance('field').fetchField(param);
  }

  handleChandgeIndexData = data => {
    this.setState({indexData: data})
  }

  render() {
   
    const {field: {
      data
    },modalVisible, handleEditBeanModalVisible, form} = this.props;
    const {
      formVals,
      loading,
      value,
      dbValue,
      sourceData,
      indexData,
      fetching,
      fieldData
    } = this.state;

    return (
      <Drawer
        width={1128}
        placement="right"
        destroyOnClose
        bodyStyle={{padding: '10px 40px 48px'}}
        visible={modalVisible}
        title="编辑Bean字段"
        onClose={() => handleEditBeanModalVisible()}
      >
       
        <DescriptionList size="large" title="Bean信息">
          <Description term="类名称">{formVals.className}</Description>
          <Description term="类中文名称">{formVals.classCnName}</Description>
        </DescriptionList>

        <Divider />
        <Row>
          <Col span={8}>
            <div className={styles.title}>字段信息</div>
          </Col>
          <Col span={16} style={{textAlign: "right"}}>
            <Select
              showSearch
              value={dbValue}
              style={{
              width: 200,
              marginRight: 10
            }}
              placeholder="Select a DB"
              optionFilterProp="children"
              onChange={this.handleDBChange}
              filterOption={(input, option) => option.props.children.toLowerCase().indexOf(input.toLowerCase()) >= 0}
            >
              {sourceData.map(d => <Option key={d.value}>{d.text}</Option>)}
            </Select>

            <Search style={{ width: 300, marginRight: 10 }} placeholder="input search table name" onSearch={this.handleSearch} enterButton="添加字段" />
          </Col>
        </Row>
        <Form layout="vertical">
          <Form.Item>
            {form.getFieldDecorator('field', {
                initialValue: data.fieldList,
              })(<FieldList onSelectFieldRows={this.handleSelectFieldRows} />)} 
          </Form.Item>      
          <Divider />
          <Row>
            <Col span={8}>
              <div className={styles.title}>索引信息</div>
            </Col>
            <Col span={8} offset={8} style={{ textAlign: "right" }}>
              <Button type="primary" onClick={this.handleAddIndex}>添加索引</Button>
            </Col>
          </Row>
          <Form.Item>
            {form.getFieldDecorator('index', {
                initialValue: data.indexList,
              })(<IndexList />)}
          </Form.Item>
        </Form>
        <Divider />
        <div style={{position: 'absolute', left: 0, bottom: 0, width: '100%', padding: '10px 16px', textAlign: 'right' }}>
          <Button type="primary" onClick={() => handleEditBeanModalVisible()} style={{ marginRight: 8 }}>取消 </Button>
          <Button type="primary" onClick={this.okHandle}>确定</Button>
        </div>
        
      </Drawer>
    );
  }
}

export default EditForm;
