import React, { PureComponent, Fragment } from 'react';
import { Table} from 'antd';

class IndexList extends PureComponent {
  index = 0;

  cacheOriginData = {};

  constructor(props) {
    super(props);

    this.state = {
      data: props.value,
      loading: false,
      /* eslint-disable-next-line react/no-unused-state */
      value: props.value,
    };
  }
  

  handleDelete(record) {
    const { data } = this.state;
    const newData = data.filter(item => item.id !== record.id);
    this.setState({ data: newData });
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

    const { loading, data } = this.state;

    return (
      <Fragment>
        <Table
          rowKey={record => record.id}
          loading={loading}
          columns={columns}
          dataSource={data}
          pagination={false}
        />       
      </Fragment>
    );
  }
}

export default IndexList;
