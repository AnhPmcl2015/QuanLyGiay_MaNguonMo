import React, {Component} from 'react';
import './SideNav.css';

class SideNav extends Component {
    render() {

        return (

            <React.Fragment>
                <div id="side-nav mt-0 ml-0">

                    <h5 className="mt-3">Giới tính</h5>
                    <hr/>
                    <div className="card card-body">

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="gioiTinh"
                                id="gioiTinh"
                                value="tatCa"
                                checked/>
                            <label className="form-check-label" htmlFor="gioiTinh">
                                Tất cả
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="gioiTinh"
                                id="gioiTinh"
                                value="nam"/>
                            <label className="form-check-label" htmlFor="gioiTinh">
                                Nam
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="gioiTinh"
                                id="gioiTinh"
                                value="nu"/>
                            <label className="form-check-label" htmlFor="gioiTinh">
                                Nữ
                            </label>
                        </div>
                    </div>

                    <h5 className="mt-3">Loại giày</h5>
                    <hr/>
                    <div className="card card-body">

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="tatCa"
                                checked/>
                            <label className="form-check-label" htmlFor="loaiGiay">
                                Tất cả
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="airJordan"/>
                            <label className="form-check-label" htmlFor="loaiGiay">
                                Air Jordan
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="nike"/>
                            <label className="form-check-label" htmlFor="loaiGiay">
                                Nike
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="adidas"/>
                            <label className="form-check-label" htmlFor="loaiGiay">
                                Adidas
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="yeezy"
                                />
                            <label className="form-check-label" htmlFor="loaiGiay">
                                Yeezy
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="vans"/>
                            <label className="form-check-label" htmlFor="loaiGiay">
                                Vans
                            </label>
                        </div>
                    </div>

                    <h5 className="mt-3">Size giày</h5>
                    <hr/>
                    <div className="card card-body mb-3">
                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="tatCa"
                                checked/>
                            <label className="form-check-label" htmlFor="sizeGiay">
                                Tất cả
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="38"/>
                            <label className="form-check-label" htmlFor="sizeGiay">
                                38
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="39"/>
                            <label className="form-check-label" htmlFor="sizeGiay">
                                39
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="40"/>
                            <label className="form-check-label" htmlFor="sizeGiay">
                                40
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="41"/>
                            <label className="form-check-label" htmlFor="sizeGiay">
                                41
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="42"/>
                            <label className="form-check-label" htmlFor="sizeGiay">
                                42
                            </label>
                        </div>

                        <div className="form-check">
                            <input
                                className="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="43"/>
                            <label className="form-check-label" htmlFor="sizeGiay">
                                43
                            </label>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}

export default SideNav;