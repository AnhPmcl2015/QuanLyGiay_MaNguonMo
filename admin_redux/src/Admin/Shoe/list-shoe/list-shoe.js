import React, { Component } from "react";
import PropTypes from "prop-types";
import { GetGiayById } from "../../../actions/giay/sua-giayAction";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import "../../Common/Loader/loader.css";
import matchSorter from "match-sorter";
import "react-table/react-table.css";
import { Button, Table, Icon, Modal, Col, Row } from "antd";
import Search from "antd/lib/input/Search";

class ListShoe extends Component {
  state = {
    items: null,
    filter: null,
    modal: false,
    loadingTable: true
  };
  updateClick = () => {
    console.log("click sua");
    this.props.GetGiayById(1);
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
          console.log(result);

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
  componentWillReceiveProps(myProps) {}

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
  // filterWithConditions(value){
  //   let list_temp= this.state.items;
  //   if(value){
  //      list_temp = matchSorter(list_temp, value, {
  //       keys: ["maGiay"]
  //     })
  //   }
  //   if(value){
  //     list_temp =  matchSorter(list_temp, value, {
  //       keys: ["maGiay"]
  //     })
  //   }
  //   this.setState({filter: list_temp})
  // }
  onDelete = value => {
    Modal.confirm({
      title: 'Thông báo',
      content: 'Bạn có chắc muốn xóa không?',
      okText: 'Đồng ý',
      cancelText: 'Hủy',
      onOk(){
        console.log(value);
        const data = this.state.items.filter(function(s) {
          return s != value;
        })
        this.setState({
          items: data
        });
      },
    });
  };

  deleteShoe= () => {
    console.log('ok')
    // fetch("/admin/api/shoe/delete-giay", {
    //   method: "POST",
    //   body: JSON.stringify(value.idGiay)
    // })
    //   .then(res => res.json())
    //   .then(
    //     result => {
    //       if (result.status === "success") {
    //         this.deleteSuccess();
    //         const data = this.state.items.filter(function(s) {
    //           return s != value;
    //         });
            // this.setState({
            //   items: data
            // });
    //       }
    //     },
    //     error => {
    //       console.log("Lỗi đăng nhập " + error);
    //     }
    //   );
  }
  onEdit = value => {
    this.props.GetGiayById(value.idGiay);
    this.props.history.push("/admin/danh-sach-giay/sua-giay");
  };

  render() {
    // if (this.state.items === null) {
    //   return <div className="loader" />;
    // }

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
            <Button onClick={() => this.onEdit(record)}>
              <Icon type="edit" theme="filled" />
            </Button>
            <Button onClick={() => this.onDelete(record)} className="ml-1">
              <Icon type="delete" theme="filled" />
            </Button>
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
                <i className="far fa-plus-square" />
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
            />
          </Col>
        </Row>
      </div>
    );
  }
}
ListShoe.propTypes = {
  GetGiayById: PropTypes.func.isRequired
};
//functions props từ login action
const mapDispatchToProps = {
  GetGiayById
};
export default connect(
  null,
  mapDispatchToProps
)(ListShoe);
