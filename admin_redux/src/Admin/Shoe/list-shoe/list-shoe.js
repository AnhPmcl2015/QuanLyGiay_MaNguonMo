import React, { Component } from "react";
import PropTypes from "prop-types";
import { GetGiayById } from "../../../actions/giay/sua-giayAction";
import { connect } from "react-redux";
import {
  Button,
  Row,
  Col,
  Input,
  Modal,
  ModalHeader,
  ModalBody,
  ModalFooter
} from "reactstrap";
import { Link } from "react-router-dom";
import "../../Common/Loader/loader.css";
import ReactTable from "react-table";
import "react-table/react-table.css";
import Pagination from "../../Common/Pagination/Pagination";
class ListShoe extends Component {
  state = {
    items: null,
    search: "",
    modal: false,
    item: null
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
            items: result
          });
        },
        error => {
          console.log("Lỗi get data giày: " + error);
        }
      );
  }
  componentWillReceiveProps(myProps) {
    console.log(myProps.giayInfo);
  }

  onSearchChange = e => {
    this.setState({
      search: e.target.value
    });
  };

  onDelete = value => {
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
    //         this.setState({
    //           items: data
    //         });
    //       }
    //     },
    //     error => {
    //       console.log("Lỗi đăng nhập " + error);
    //     }
    //   );
  };
  // onEdit = value => {
  //   this.props.GetGiayById(value.idGiay);
  //   this.props.history.push("/admin/danh-sach-giay/sua-giay");
  // };

  // toggle = () => {
  //   this.onDelete(this.state.item);
  //   this.setState({
  //     modal: !this.state.modal
  //   });
  // }

  // toggleDelete = (value) => {
  //   this.setState({
  //     item: value,
  //     modal: !this.state.modal
  //   });
  // }

  render() {
    if (this.state.items === null) {
      return <div className="loader" />;
    }

    const columns = [
      {
        Header: "Mã giày",
        accessor: "maGiay",
        id: "maGiay"
      },
      {
        Header: "Tên giày",
        accessor: "tenGiay",
        id: "tenGiay"
      },
      {
        Header: "Giới tính",
        accessor: "tenGioiTinh"
      },
      {
        Header: "Loại giày",
        accessor: "tenLoaiGiay"
      },
      {
        Header: "Nhà sản xuất",
        accessor: "tenHangSanXuat"
      },
      {
        Header: "Chức năng",
        accessor: "idGiay",
        Cell: row => (
          <div align="center">
            <Button
              color="info"
              className="rounded-circle"
              onClick={() => this.onEdit(row.original)}
            >
              <i className="fas fa-edit" />
            </Button>
            <Button
              color="secondary"
              className="rounded-circle ml-1"
              onClick={() => this.toggleDelete(row.original)}
            >
              <i className="far fa-trash-alt" />
            </Button>
          </div>
        )
      }
    ];
    const data = this.state.items.filter(row => {
      return (
        row.maGiay.includes(this.state.search) ||
        row.tenGiay.includes(this.state.search)
      );
    });
    return (
      <div>
        <Row>
          <Col xs={3}>
            <Input
              value={this.state.search}
              onChange={this.onSearchChange}
              type="text"
              placeholder="Tìm kiếm"
            />
          </Col>
          <Col>
            <Link to="/admin/danh-sach-giay/them-giay">
              <Button color="primary" className="rounded-circle float-right">
                <i className="far fa-plus-square" />
              </Button>
            </Link>
          </Col>
        </Row>
        <Row className="mt-1">
          <Col xs={12}>
            <ReactTable
              ref={r => (this.reactTable = r)} // get ref gọi this.reactTable
              PaginationComponent={Pagination} // custom giao diện phần phân trang
              data={data} // dữ liệu đổ vào table
              columns={columns} // dữ liệu cột và header
              defaultPageSize={5} // số records/page
              sortable={true}
              previousText={"<"} // custom text lùi về 1 trang
              showPageSizeOptions={false} // hiển thị select box cho phép chọn số records hiển thị trong 1 trang
              showPagination={true} // hiển thị phân trang
              nextText={">"} // custom text đi tới 1 trang
              noDataText={"Không tìm thấy"} // custom text
              pageText={"Trang"} // custom text
              ofText={"/"} // custom text
              rowsText={"dòng"} // custom text
              pageJumpText={"Đi tới trang"} // custom text
              rowsSelectorText={"dòng/1 trang"} // custom text
              // defaultFilterMethod={(filter, row) =>
              //   String(row[filter.id]).includes(this.state.search)
              // }
            />
          </Col>
        </Row>
        <Modal
          isOpen={this.state.modal}
          toggle={this.toggle}
          className={this.props.className}
        >
          <ModalHeader toggle={this.toggle}>Thông báo</ModalHeader>
          <ModalBody>
            Bạn có chắc muốn xóa không?
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={this.toggle}>
              Đồng ý
            </Button>{" "}
            <Button color="secondary" onClick={this.toggle}>
              Hủy
            </Button>
          </ModalFooter>
        </Modal>
      </div>
    );
  }
}

ListShoe.propTypes = {
  giayInfo: PropTypes.object
};
//functions props từ login action
const mapDispatchToProps = {
  GetGiayById
};
//state of reducer, loginInfo là props của Component này, state là của redux
const mapStateToProps = state => ({
  giayInfo: state.giayInfo
});
export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ListShoe);
