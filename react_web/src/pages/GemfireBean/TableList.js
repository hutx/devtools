import React, { PureComponent, Fragment } from 'react';
import { connect } from 'dva';
import {
  Row,
  Col,
  Card,
  Form,
  Input,
  Select,
  Icon,
  Button,
  Dropdown,
  Menu,
  Modal,
  message,
  Divider,
  Steps,
} from 'antd';
import StandardTable from '@/components/StandardTable';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import EditFormBean from './editForm';

import styles from './TableList.less';

const FormItem = Form.Item;

const getValue = obj =>
  Object.keys(obj)
    .map(key => obj[key])
    .join(',');

const CreateForm = Form.create()(props => {
  const { modalVisible, form, handleAdd, handleModalVisible } = props;
  const okHandle = () => {
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      form.resetFields();
      handleAdd(fieldsValue);
    });
  };
  return (
    
    <Modal
      destroyOnClose
      title="新建GemfireBean"
      visible={modalVisible}
      onOk={okHandle}
      onCancel={() => handleModalVisible()}
    >
      <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label="类名称">
        {form.getFieldDecorator('className', {initialValue: '',
          rules: [{ required: true, message: '请输入类型名称！' }],
        })(<Input placeholder="请输入类名称" />)}
      </FormItem>
      <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label="类中文名称">
        {form.getFieldDecorator('classCnName', {
          rules: [{ required: true, message: '请输入类中文名称！' }],
        })(<Input placeholder="请输入类中文名称" />)}
      </FormItem>
      <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label="描述信息">
        {form.getFieldDecorator('remark')(<Input placeholder="请输入描述信息" />)}
      </FormItem>
    </Modal>
  );
});


@Form.create()
class UpdateForm extends PureComponent {
  constructor(props) {
    super(props);

    this.state = {
      formVals: {
        id : props.values.id,
        className: props.values.className,
        classCnName: props.values.classCnName,
        remark: props.values.remark,
      }
    };
  }
  
  okHandle = () => {
    const { form, handleUpdate } = this.props;
    const { formVals: oldValue } = this.state;
    form.validateFields((err, fieldsValue) => {
      if (err) return;
      const formVals = { ...oldValue, ...fieldsValue };
      this.setState({formVals,},
        () => {          
            handleUpdate(formVals);
        }
      );
    });
  };

  render() {
    const { updateModalVisible, handleUpdateModalVisible, form } = this.props;
    const { formVals } = this.state;

    return (
      <Modal
        width={640}
        bodyStyle={{ padding: '32px 40px 48px' }}
        destroyOnClose
        visible={updateModalVisible}
        title="修改Bean"
        onOk={this.okHandle}
        onCancel={() => handleUpdateModalVisible()}
      >
        <Form layout="vertical">
        
          <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label="类名称">
            {form.getFieldDecorator('className', {initialValue: formVals.className,
              rules: [{ required: true, message: '请输入类型名称！' }],
            })(<Input placeholder="请输入类名称" />)}
          </FormItem>

          <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label="类中文名称">
            {form.getFieldDecorator('classCnName', {initialValue: formVals.classCnName,
              rules: [{ required: true, message: '请输入类中文名称！' }],
            })(<Input placeholder="请输入类中文名称" />)}
          </FormItem>

          <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label="描述信息">
            {form.getFieldDecorator('remark',{initialValue: formVals.remark,
            })(<Input placeholder="请输入描述信息" />)}
          </FormItem>

        </Form>
      </Modal>
    );
  }
}

/* eslint react/no-multi-comp:0 */
@connect(({ gemfire, loading }) => ({
  gemfire,
  loading: loading.models.gemfire ,
}))
@Form.create()
class TableList extends PureComponent {
  state = {
    modalVisible: false,
    updateModalVisible: false,
    editBeanModalVisible: false,
    expandForm: false,
    selectedRows: [],
    formValues: {},
    stepFormValues: {},
  };

  columns = [
    {
      title: '类名称',
      dataIndex: 'className',
    },
    {
      title: '类中文名称',
      dataIndex: 'classCnName',
    },
    {
      title: '描述',
      dataIndex: 'remark',
    },
    {
      title: '操作',
      render: (text, record) => (
        <Fragment>
          <a onClick={() => this.handleUpdateModalVisible(true, record)}>修改</a>
          <Divider type="vertical" />
          <a onClick={() => this.handleEditBeanModalVisible(true, record)}>添加Bean字段</a>
        </Fragment>
      ),
    },
  ];

  componentDidMount() {
    const { dispatch } = this.props;
    dispatch({
      type: 'gemfire/fetch',
    });
  }

  handleStandardTableChange = (pagination, filtersArg, sorter) => {
    const { dispatch } = this.props;
    const { formValues } = this.state;

    const filters = Object.keys(filtersArg).reduce((obj, key) => {
       const newObj = { ...obj };
       newObj[key] = getValue(filtersArg[key]);
       return newObj;
    }, {});

    const params = {
      currentPage: pagination.current,
      pageSize: pagination.pageSize,
      ...formValues,
      ...filters,
    };
    if (sorter.field) {
      params.sorter = `${sorter.field}_${sorter.order}`;
    }

    dispatch({
      type: 'gemfire/fetch',
      payload: params,
    });
  };

  handleFormReset = () => {
    const { form, dispatch } = this.props;
    form.resetFields();
    this.setState({
      formValues: {},
    });
    dispatch({
      type: 'gemfire/fetch',
      payload: {},
    });
  };

  toggleForm = () => {
    const { expandForm } = this.state;
    this.setState({
      expandForm: !expandForm,
    });
  };

  handleDeleteClick = () => {
    const { dispatch } = this.props;
    const { selectedRows } = this.state;
    // let ids =[];
    if (!selectedRows) return;
    // electedRows.forEach(row => ids.push({id:row.id}));
    // selectedRows.map(row => row.id)
    dispatch({
      type: 'gemfire/remove',
      payload: {
        id:selectedRows.map(row => row.id)
      },
      callback: () => {
        this.setState({
          selectedRows: [],
        });
      },
    });
  };

  handleSelectRows = rows => {
    this.setState({
      selectedRows: rows,
    });
  };

  handleSearch = e => {
    e.preventDefault();

    const { dispatch, form } = this.props;

    form.validateFields((err, fieldsValue) => {
      if (err) return;

      const values = {
        query:JSON.stringify(fieldsValue)
      };

      this.setState({
        formValues: values,
      });

      dispatch({
        type: 'gemfire/fetch',
        payload: values,
      });
    });
  };

  
  handleModalVisible = flag => {
    this.setState({
      modalVisible: !!flag,
    });
  };

  handleUpdateModalVisible = (flag, record) => {
    this.setState({
      updateModalVisible: !!flag,
      stepFormValues: record || {},
    });
  };

  handleEditBeanModalVisible = (flag,record) =>{
    this.setState({
      editBeanModalVisible: !!flag,
      stepFormValues: record || {},
    })
  }

  handleEditFieldBean =fields =>{
    const { dispatch } = this.props;

    this.handleEditBeanModalVisible();
  }

  handleAdd = fields => {
    const { dispatch } = this.props;
    
    dispatch({
      type: 'gemfire/add',
      payload: fields,
    });  
    this.handleModalVisible();
  };

  handleUpdate = fields => {
    const { dispatch } = this.props;
    dispatch({
      type: 'gemfire/update',
      payload: fields,
    });
    dispatch({
      type: 'gemfire/fetch',
    });
     this.handleUpdateModalVisible();
     
  };

  renderSimpleForm() {
    const {
      form: { getFieldDecorator },
    } = this.props;
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
          <Col md={8} sm={24}>
            <FormItem label="类名称">
              {getFieldDecorator('className')(<Input placeholder="请输入" />)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="类中文名称">
              {getFieldDecorator('classCnName')(<Input placeholder="请输入" />)}
            </FormItem>
          </Col>          
          <Col md={8} sm={24}>
            <span className={styles.submitButtons}>
              <Button type="primary" htmlType="submit">
                查询
              </Button>
              <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>
                重置
              </Button>
            </span>
          </Col>
        </Row>
      </Form>
    );
  }

  renderAdvancedForm() {
    const {
      form: { getFieldDecorator },
    } = this.props;    
    return (
      <Form onSubmit={this.handleSearch} layout="inline">
        <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
          <Col md={8} sm={24}>
            <FormItem label="类名称">
              {getFieldDecorator('className')(<Input placeholder="请输入" />)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="类中文名称">
              {getFieldDecorator('classChName')(<Input placeholder="请输入" />)}
            </FormItem>
          </Col>
          <Col md={8} sm={24}>
            <FormItem label="描述信息">
              {getFieldDecorator('remark')(<Input placeholder="请输入"  />)}
            </FormItem>
          </Col>
        </Row>        
        <div style={{ overflow: 'hidden' }}>
          <div style={{ float: 'right', marginBottom: 24 }}>
            <Button type="primary" htmlType="submit">
              查询
            </Button>
            <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>
              重置
            </Button>
            <a style={{ marginLeft: 8 }} onClick={this.toggleForm}>
              收起 <Icon type="up" />
            </a>
          </div>
        </div>
      </Form>
    );
  }

  renderForm() {
    const { expandForm } = this.state;
    return expandForm ? this.renderAdvancedForm() : this.renderSimpleForm();
  }

  render() {    
    const {
      gemfire: { data },
      loading,
    } = this.props;
    const { selectedRows, modalVisible, updateModalVisible, editBeanModalVisible, stepFormValues } = this.state; 

    const parentMethods = {
      handleAdd: this.handleAdd,
      handleModalVisible: this.handleModalVisible,
    };
    const updateMethods = {
      handleUpdateModalVisible: this.handleUpdateModalVisible,
      handleUpdate: this.handleUpdate,
    }; 
    const editBeanMethods = {
      handleEditBeanModalVisible: this.handleEditBeanModalVisible,
      handleEditField: this.handleEditFieldBean,
    };
    return (      
      <PageHeaderWrapper title="GemfireBean">
        <Card bordered={false}>
          <div className={styles.tableList}>
            <div className={styles.tableListForm}>{this.renderForm()}</div>
            <div className={styles.tableListOperator}>
              <Button icon="plus" type="primary" onClick={() => this.handleModalVisible(true)}>
                新建
              </Button>
              {selectedRows.length > 0 && (
                <span>
                  <Button icon="delete" onClick={() => this.handleDeleteClick(true)}>删除</Button>
                  
                </span>
              )}
            </div>
            <StandardTable
              rowKey={record => record.id}
              selectedRows={selectedRows}
              loading={loading}
              data={data}
              columns={this.columns}
              onSelectRow={this.handleSelectRows}
              onChange={this.handleStandardTableChange}
            />
          </div>
        </Card>
        <CreateForm {...parentMethods} modalVisible={modalVisible} />
        
        {stepFormValues && Object.keys(stepFormValues).length ? (          
          <UpdateForm
            {...updateMethods}
            updateModalVisible={updateModalVisible}
            values={stepFormValues}
          />
        ) : null}  

        {stepFormValues && Object.keys(stepFormValues).length ?(
          <EditFormBean {...editBeanMethods} modalVisible={editBeanModalVisible} values={stepFormValues} />
        ):null}
      </PageHeaderWrapper>
    );
  }
}

export default TableList;
