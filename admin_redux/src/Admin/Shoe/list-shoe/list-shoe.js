import React, { Component } from "react";
import PropTypes from "prop-types";
import { GetGiayById, getImageByIdGiay } from "../../../actions/giay/sua-giayAction";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import "../../Common/Loader/loader.css";
import matchSorter from "match-sorter";
import "react-table/react-table.css";
import { Button, Table, Icon, Modal, Col, Row, Popconfirm, message, Tooltip } from "antd";
import Search from "antd/lib/input/Search";
import UploadImg from "../upload-img/upload-img";
import DetailShoe from "../detail-shoe/detail-shoe";

class ListShoe extends Component {
  state = {
    items: null,
    filter: null,
    modal: false,
    loadingTable: true,
    shoe: null
  };
  async componentDidMount() {
    // lấy dữ liệu từ Server
    await this.loadDatatable();
  }
  loadDatatable() {
    fetch("/admin/api/shoe/list-shoe", {
      method: "POST",
      body: JSON.stringify("")
    })
      .then(res => res.json())
      .then(
        result => {

          this.setState({
            items: result,
            filter: result,
            loadingTable: false
          });
        },
        error => {
          console.log("Lỗi get data giày: " + error);
        }
      );
  }
  componentWillReceiveProps(myProps) { }

  onSearchChange = e => {
    const value = this.filter(e.target.value);
    this.setState({
      filter: value
    });
  };

  filter(value) {
    return value
      ? matchSorter(this.state.items, value, {
        keys: ["maGiay", "tenGiay"]
      })
      : this.state.items;
  }

  deleteShoe(value) {

    fetch("/admin/api/shoe/delete-giay", {
      method: "POST",
      body: JSON.stringify(value.idGiay)
    })
      .then(res => res.json())
      .then(
        result => {
          if (result.status === "success") {
            const data = this.state.items.filter(s => {
              console.log(s);
              return s !== value;
            })
            this.setState({
              items: data,
              filter: data
            });
            message.success('Xóa thành công')
          }
        },
        error => {
          console.log("Lỗi đăng nhập " + error);
        }
      );
  }
  onEdit = value => {
    this.props.GetGiayById(value.idGiay);
    this.props.history.push("/admin/danh-sach-giay/sua-giay");
  };

  showDetailShoe(value) {
    this.setState({
      modal: true,
      shoe: value
    })
  }

  onCancel = () => {
    this.setState({
      modal: false
    })
  }
  showImage(value) {
    this.props.getImageByIdGiay(value.idGiay)
    this.props.history.push("/admin/danh-sach-giay/anh-giay");
  }
  render() {
    const columns = [
      {
        title: "Mã giày",
        dataIndex: "maGiay",
        key: "maGiay",
        onFilter: (value, record) => record.name.indexOf(value) === 0,
        sorter: (a, b) => {
          return a.maGiay.localeCompare(b.maGiay);
        }
      },
      {
        title: "Tên giày",
        dataIndex: "tenGiay",
        key: "tenGiay",
        sorter: (a, b) => {
          return a.tenGiay.localeCompare(b.tenGiay);
        }
      },
      {
        title: "Giới tính",
        dataIndex: "tenGioiTinh",
        key: "tenGioiTinh"
      },
      {
        title: "Loại giày",
        dataIndex: "tenLoaiGiay",
        key: "tenLoaiGiay"
      },
      {
        title: "Nhà sản xuất",
        dataIndex: "tenHangSanXuat",
        key: "tenHangSanXuat"
      },
      {
        title: "Chức năng",
        dataIndex: "idGiay",
        render: (text, record) => (
          <div>
            <Button onClick={() => this.onEdit(record)} placeholder="Sửa">
              <Icon type="edit" theme="filled" />
            </Button>
            <Popconfirm placement="topRight" title="Bạn có chắc muốn xóa không?" onConfirm={() => this.deleteShoe(record)} okText="Đồng ý" cancelText="Hủy">
              <Button className="ml-1" placeholder="Xóa">
                <Icon type="delete" theme="filled" />
              </Button>
            </Popconfirm>
            <Button className="ml-1" placeholder="Hình ảnh" onClick={() => this.showImage(record)}>
              <Icon type="picture" />
            </Button>
            <Tooltip placement="topLeft" title="Thêm size giày" >
              <Button className="ml-1" onClick={() => this.showDetailShoe(record)}>
                <Icon type="plus-circle" />
              </Button>
            </Tooltip>
          </div>
        )
      }
    ];
    return (
      <div>
        <Row className="mt-1">
          <Col xs={6}>
            <Search
              placeholder="Tìm kiếm mã giày/tên giày"
              onChange={this.onSearchChange}
            />
          </Col>
          <Col>
            <Link to="/admin/danh-sach-giay/them-giay">
              <Button color="primary" className="float-right">
                <Icon type="plus-square" />
              </Button>
            </Link>
          </Col>
        </Row>
        <Row className="mt-2">
          <Col xs={24}>
            <Table
              dataSource={this.state.filter}
              columns={columns}
              pagination={{ pageSize: 10 }}
              loading={this.state.loadingTable}
              rowKey="maGiay"
            />
          </Col>
        </Row>
        <Modal
          title="Size giày"
          visible={this.state.modal}
          width={800}
          // onOk={this.handleOk}
          // confirmLoading={confirmLoading}
          footer={[
            <div></div>,
          ]}
          onCancel={this.onCancel}
          key="imageShoe"
        >
          <DetailShoe shoe={this.state.shoe} />
        </Modal>
      </div>
    );
  }
}
ListShoe.propTypes = {
  GetGiayById: PropTypes.func.isRequired,
  getImageByIdGiay: PropTypes.func.isRequired
};
//functions props từ login action
const mapDispatchToProps = {
  GetGiayById,
  getImageByIdGiay
};
export default connect(
  null,
  mapDispatchToProps
)(ListShoe);
