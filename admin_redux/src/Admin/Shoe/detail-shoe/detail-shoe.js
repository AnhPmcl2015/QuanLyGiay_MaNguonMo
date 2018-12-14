import React, { Component } from 'react';
import { Button, Table, Icon, Radio, Col, Row, Popconfirm, message, Tooltip } from "antd";
import EditableCell, { EditableFormRow, EditableContext } from './edit-table-cell';
import './detail-shoe.css';
class DetailShoe extends Component {

    state = {
        dataSource: null,
        editingKey: '',
        idGiay: null
    }
    isEditing = record => {
        return record.idChiTietGiay === this.state.editingKey
    };
    initTable(id) {
        this.setState({
            idGiay: id
        })
        fetch("/admin/api/detail-shoe/get-chitietgiay-by-id", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(id)
        })
            .then(res => res.json())
            .then(
                result => {
                    this.setState({
                        dataSource: result
                    })
                },
                error => {
                    console.log("Lỗi get image " + error);
                }
            );
    }
    componentWillMount() {
        this.initTable(this.props.shoe.idGiay)
    }
    componentWillReceiveProps(myProps) {
        this.initTable(myProps.shoe.idGiay)
    }
    columns = [
        {
            title: "Size giày",
            dataIndex: "size",
            key: "size",
            onFilter: (value, record) => record.size.indexOf(value) === 0,
            sorter: (a, b) => {
                return a.size.localeCompare(b.size);
            },
            editable: true
        },
        {
            title: "Số lượng",
            dataIndex: "soluong",
            key: "soluong",
            onFilter: (value, record) => record.size.indexOf(value) === 0,
            sorter: (a, b) => {
                return a.size.localeCompare(b.size);
            },
            editable: true
        },
        {
            title: "Chức năng",
            dataIndex: "idChiTietGiay",
            width: '30%',
            render: (text, record) => (

                <div>
                    <EditableContext.Consumer>
                        {form => (
                            <Button onClick={() => this.saveDetailShoe(form, record)} disabled={!this.isEditing(record)}>
                                <Icon type="save" />
                            </Button>
                        )}
                    </EditableContext.Consumer>
                    <Popconfirm placement="topRight" title="Bạn có chắc muốn xóa không?" onConfirm={() => this.handleDelete(record)} okText="Đồng ý" cancelText="Hủy">
                        <Button className="ml-1" placeholder="Xóa">
                            <Icon type="delete" theme="filled" />
                        </Button>
                    </Popconfirm>
                </div>
            )
        }
    ];
    saveDetailShoe(form, value) {
        form.validateFields((error, row) => {
            if (error) {
                console.log('error')
                return;
            } else {
                value.size = row.size;
                value.soluong = row.soluong;
                console.log(value);
                fetch("/admin/api/detail-shoe/save-chitietgiay", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(value)
                })
                    .then(res => res.json())
                    .then(
                        result => {
                            console.log(result)
                            if (result.status == 'success') {
                                message.success('Lưu thành công!');
                            } else {
                                message.error('Lưu thất bại!');
                            }
                            this.setState({ editingKey: '' });
                        },
                        error => {
                            console.log("Lỗi get image " + error);
                        }
                    );
            }

        });
    }
    handleDelete(key) {
        fetch("/admin/api/detail-shoe/delete-chitietgiay", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(parseInt(key.idChiTietGiay))
        })
            .then(res => res.json())
            .then(
                result => {
                    console.log(result)
                    if (result.status == 'success') {
                        message.success('Xóa thành công!');
                        const data = this.state.dataSource.filter(s => {
                            return s !== key;
                        })
                        this.setState({ dataSource: data });
                    } else {
                        message.error('Xóa thất bại!');
                    }
                    this.setState({ editingKey: '' });
                },
                error => {
                    console.log("Lỗi get image " + error);
                }
            );

    }
    handleAdd = () => {
        const { dataSource } = this.state;

        const newData = {
            size: '',
            idChiTietGiay: Math.random().toString(36).substring(2, 15) + Math.random().toString(36).substring(2, 15),
            soluong: '',
            idGiay: this.state.idGiay
        };
        this.setState({
            dataSource: [newData, ...dataSource]
        });
    }
    onRowClick(selectedRow) {
        this.setState({ editingKey: selectedRow.idChiTietGiay });
    }
    render() {
        const cols = this.columns.map((col) => {
            if (!col.editable) {
                return col;
            }
            return {
                ...col,
                onCell: record => ({
                    record,
                    inputType: 'text',
                    dataIndex: col.dataIndex,
                    title: col.title,
                    editing: this.isEditing(record),
                }),
            };
        });
        const components = {
            body: {
                row: EditableFormRow,
                cell: EditableCell,
            },
        };
        return (
            <div>
                <Tooltip placement="topLeft" title="Thêm size giày" >
                    <Button onClick={this.handleAdd} style={{ marginBottom: 16 }}>
                        <Icon type="plus-square" />
                    </Button>
                </Tooltip>
                <Table
                    onRow={(record) => {
                        return {
                            onClick: () => this.onRowClick(record),       // click row
                        };
                    }}
                    components={components}

                    columns={cols}
                    dataSource={this.state.dataSource}
                    pagination={{ pageSize: 5 }} />
            </div>
        );
    }
}

export default DetailShoe;