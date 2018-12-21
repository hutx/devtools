import React, { PureComponent, Fragment } from 'react';
import { Table} from 'antd';
import isEqual from 'lodash/isEqual';

class IndexList extends PureComponent {
  index = 0;

  cacheOriginData = {};

  constructor(props) {
    super(props);

    this.state = {
      data: props.value,
      loading: false,
      value: props.value,
    };
  }

  // static getDerivedStateFromProps(nextProps, preState) {
  //   if (isEqual(nextProps.value, preState.value)) {
  //     return null;
  //   }
  //   return {
  //     data: nextProps.value,
  //     value: nextProps.value,
  //   };
  // }  

  handleDelete =(e,record) => {
    const { data } = this.state;
    const { onChange} = this.props;
    const newData = data.filter(item => item.id !== record.id);
    this.setState({ data: newData });
    onChange(newData);
  }

  handleAdd = fieldCodes =>{
    const { data } = this.state;
    const { onChange} = this.props;
    const newData = data ? data.map(item => ({  ...item })) : [];
    newData.push({id: `NEW_INDEX_ID_${newData.length}`, fieldCode: fieldCodes});
    this.setState({ data: newData });
    onChange(newData);
  }

  render() {
    const columns = [
      {
        title: '索引字段',
        dataIndex: 'fieldCode',
      },
      {
        title: '操作',
        render: (text, record) => (
            // eslint-disable-next-line react/jsx-indent
            <Fragment><a onClick={() => this.handleDelete(true, record)}>删除</a></Fragment>          
        ),
      },
    ];

    const { loading ,data} = this.state;
    // const {data} = this.props;
    // this.setState({data});

    return (
      <Fragment>
        <Table
          rowKey={record => record.id}
          loading={loading}
          columns={columns}
          dataSource={data}
          pagination={false}
          scroll={{y:120}}
        />       
      </Fragment>
    );
  }
}

export default IndexList;
