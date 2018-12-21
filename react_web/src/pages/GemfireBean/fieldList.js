/* eslint-disable prefer-destructuring */
import React, {PureComponent, Fragment} from 'react';
import {
  Table,
  Button,
  Input,
  Checkbox,
  message,
  Popconfirm,
  Divider
} from 'antd';
import {stringify} from 'qs';
import styles from './style.less';
import Ellipsis from '@/components/Ellipsis';

class FieldList extends PureComponent {
  cacheOriginData = {};

  constructor(props) {
    super(props);

    this.state = {
      data: props.value,
      loading: props.loading,
      selectedRows: [],
      value: props.value,
    };
  }

  getRowByKey(id, newData) {
    const {data} = this.state;
    return (newData || data).filter(item => item.id === id)[0];
  }

  toggleEditable = (e, id) => {
    e.preventDefault();
    const {data} = this.state;
    const newData = data.map(item => ({
      ...item
    }));
    const target = this.getRowByKey(id, newData);
    if (target) {
      // 进入编辑状态时保存原始数据
      if (!target.editable) {
        this.cacheOriginData[id] = {
          ...target
        };
      }
      target.editable = !target.editable;
      this.setState({data: newData});
    }
  }

  newMember = () => {
    const {data} = this.state;
    const {onChange} = this.props;
    const newData = data
      ? data.map(item => ({
        ...item
      }))
      : [];
    newData.push({
      id: `NEW_TEMP_ID_${newData.length}`,
      fieldCode: '',
      fieldName: '',
      fieldType: '',
      comment: '',
      classId: '',
      isKey: 0,
      isNull: 0,
      editable: true
    });
    this.setState({data: newData});
    onChange(newData);
  }

  remove = (id) => {
    const {data} = this.state;
    const {onChange} = this.props;
    const newData = data.filter(item => item.id !== id);
    this.setState({data: newData});
    onChange(newData);
  }

  handleKeyPress = (e, id) => {
    if (e.id === 'Enter') {
      this.saveRow(e, id);
    }
  }

  handleFieldChange = (e, fieldName, id) => {
    const {data} = this.state;
    const newData = data.map(item => ({
      ...item
    }));
    const target = this.getRowByKey(id, newData);
    if (target) {
      target[fieldName] = e.target.value;
      this.setState({data: newData});
    }
  }

  saveRow = (e, id) => {
    e.persist();
    this.setState({loading: true});
    setTimeout(() => {
      if (this.clickedCancel) {
        this.clickedCancel = false;
        return;
      }
      const target = this.getRowByKey(id) || {};
      if (!target.workId || !target.name || !target.department) {
        message.error('请填写完整字段信息。');
        e
          .target
          .focus();
        this.setState({loading: false});
        return;
      }
      delete target.isNew;
      this.toggleEditable(e, id);
      const {data} = this.state;
      const {onChange} = this.props;
      onChange(data);
      this.setState({loading: false});
    }, 500);
  }

  cancel = (e, key) => {
    this.clickedCancel = true;
    e.preventDefault();
    const {data} = this.state;
    const newData = data.map(item => ({
      ...item
    }));
    const target = this.getRowByKey(key, newData);
    if (this.cacheOriginData[key]) {
      Object.assign(target, this.cacheOriginData[key]);
      delete this.cacheOriginData[key];
    }
    target.editable = false;
    this.setState({data: newData});
    this.clickedCancel = false;
  }

  fetchField = value => {
    this.setState({data: [], loading: true});
    const {onChange} = this.props;      
    fetch(`/api/gemfireFields/findTableField?${stringify(value)}`)
      .then(response => response.json())
      .then((body) => {
        // console.log(body);
        const data = body.list.map((item, index) => ({
            id: `NEW_TEMP_ID_${index}`,
            fieldCode: item.fieldCode,
            fieldName: item.fieldName,
            fieldType: item.fieldType,
            isKey: item.isKey,
            isNull: item.isNull,
            comment: item.fieldName,
            editable: false
          }));
        this.setState({data, loading: false});
        onChange(data);
      });
  }

  handleSelectRows = (rows, selectedRows) => {
    const {onSelectFieldRows} = this.props;
    this.setState({selectedRows: rows});
    const data = selectedRows.map(row => row.fieldCode);
    onSelectFieldRows(data.join(','));
  };

  render() {
    const columns = [
      {
        title: '字段CODE',
        dataIndex: 'fieldCode',
        key: 'fieldCode',
        width: 200,
        render: (text, record) => {
          if (record.editable) {
            return (<Input
              value={text}
              autoFocus
              onChange={e => this.handleFieldChange(e, 'fieldCode', record.id)}
              onKeyPress={e => this.handleKeyPress(e, record.id)}
              placeholder="字段CODE"
            />);
          }
          return text;
        }
      }, {
        title: '字段类型',
        dataIndex: 'fieldType',
        key: 'fieldType',
        width: 100,
        render: (text, record) => {
          if (record.editable) {
            return (<Input
              value={text}
              onChange={e => this.handleFieldChange(e, 'fieldType', record.id)}
              onKeyPress={e => this.handleKeyPress(e, record.id)}
              placeholder="字段类型" 
            />);
          }
          return text;
        }
      }, {
        title: '字段描述',
        dataIndex: 'comment',
        key: 'comment',
        width: 350,
        render: (text, record) => {
          if (record.editable) {
            return (<Input
              value={text}
              onChange={e => this.handleFieldChange(e, 'comment', record.id)}
              onKeyPress={e => this.handleKeyPress(e, record.id)}
              placeholder="字段描述" 
            />);
          }
          return (
            <Ellipsis tooltip lines={2}>{text}</Ellipsis>
          );
        }
      }, {
        title: '是否主键',
        dataIndex: 'isKey',
        key: 'isKey',
        width: 100,
        render: (text, record) => {
          if (record.editable) {
            return (<Checkbox
              checked={text === 1}
              value={1}
              onChange={e => this.handleFieldChange(e, 'isKey', record.id)}
              onKeyPress={e => this.handleKeyPress(e, record.id)}
              placeholder="是否主键" 
            />);
          }
          return text === 1
            ? "是"
            : "否";
        }
      }, {
        title: '是否为空',
        dataIndex: 'isNull',
        key: 'isNull',
        width: 100,
        render: (text, record) => {
          if (record.editable) {
            return (<Checkbox
              checked={text === 1}
              value={1}
              onChange={e => this.handleFieldChange(e, 'isNull', record.id)}
              onKeyPress={e => this.handleKeyPress(e, record.id)}
              placeholder="是否为空" 
            />);
          }
          return text === 1
            ? "是"
            : "否";;
        }
      }, {
        title: '操作',
        key: 'action',
        width: 100,
        render: (text, record) => {
          const {loading} = this.state;
          if (!!record.editable && loading) {
            return null;
          }
          if (record.editable) {
            if (record.isNew) {
              return (
                <span>
                  <a onClick={e => this.saveRow(e, record.id)}>添加</a>
                  <Divider type="vertical" />
                  <Popconfirm title="是否要删除此行？" onConfirm={() => this.remove(record.id)}>
                    <a>删除</a>
                  </Popconfirm>
                </span>
              );
            }
            return (
              <span>
                <a onClick={e => this.saveRow(e, record.id)}>保存</a>
                <Divider type="vertical" />
                <a onClick={e => this.cancel(e, record.id)}>取消</a>
              </span>
            );
          }
          return (
            <span>
              <a onClick={e => this.toggleEditable(e, record.id)}>编辑</a>
              <Divider type="vertical" />
              <Popconfirm title="是否要删除此行？" onConfirm={() => this.remove(record.id)}>
                <a>删除</a>
              </Popconfirm>
            </span>
          );
        }
      }
    ];

    
    const {data, loading, selectedRows} = this.state;
    const rowSelection = {
      selectedRows,
      onChange: this.handleSelectRows
    };
    return (
      <Fragment>
        <Table
          rowKey={record => record.id}
          loading={loading}
          columns={columns}
          dataSource={data}
          pagination={false}
          rowSelection={rowSelection}
          scroll={{
          y: 250
        }}
          rowClassName={record => (record.editable
          ? styles.editable
          : '')} 
        />
        <Button
          style={{
          width: '100%',
          marginTop: 16,
          marginBottom: 8
        }}
          type="dashed"
          onClick={this.newMember}
          icon="plus"
        >
          新增字段
        </Button>
      </Fragment>
    );
  }
}

export default FieldList;
