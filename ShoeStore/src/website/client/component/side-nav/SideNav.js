import React, {Component} from 'react';
import './SideNav.css';

class SideNav extends Component {
    constructor(props) {
        super(props);
    }
    render() {

        return (

            <React.Fragment>
                <div id="side-nav mt-0 ml-0">

                    <h5 className="mt-3">Giới tính</h5>
                    <hr/>
                    <div className="card card-body">

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="gioiTinh"
                                id="gioiTinh"
                                value="tatCa"
                                checked/>
                            <label class="form-check-label" for="gioiTinh">
                                Tất cả
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="gioiTinh"
                                id="gioiTinh"
                                value="nam"/>
                            <label class="form-check-label" for="gioiTinh">
                                Nam
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="gioiTinh"
                                id="gioiTinh"
                                value="nu"/>
                            <label class="form-check-label" for="gioiTinh">
                                Nữ
                            </label>
                        </div>
                    </div>

                    <h5 className="mt-3">Loại giày</h5>
                    <hr/>
                    <div className="card card-body">

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="tatCa"
                                checked/>
                            <label class="form-check-label" for="loaiGiay">
                                Tất cả
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="airJordan"/>
                            <label class="form-check-label" for="loaiGiay">
                                Air Jordan
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="nike"/>
                            <label class="form-check-label" for="loaiGiay">
                                Nike
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="adidas"/>
                            <label class="form-check-label" for="loaiGiay">
                                Adidas
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="yeezy"
                                />
                            <label class="form-check-label" for="loaiGiay">
                                Yeezy
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="loaiGiay"
                                id="loaiGiay"
                                value="vans"/>
                            <label class="form-check-label" for="loaiGiay">
                                Vans
                            </label>
                        </div>
                    </div>

                    <h5 className="mt-3">Size giày</h5>
                    <hr/>
                    <div className="card card-body mb-3">
                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="tatCa"
                                checked/>
                            <label class="form-check-label" for="sizeGiay">
                                Tất cả
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="38"/>
                            <label class="form-check-label" for="sizeGiay">
                                38
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="39"/>
                            <label class="form-check-label" for="sizeGiay">
                                39
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="40"/>
                            <label class="form-check-label" for="sizeGiay">
                                40
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="41"/>
                            <label class="form-check-label" for="sizeGiay">
                                41
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="42"/>
                            <label class="form-check-label" for="sizeGiay">
                                42
                            </label>
                        </div>

                        <div class="form-check">
                            <input
                                class="form-check-input"
                                type="radio"
                                name="sizeGiay"
                                id="sizeGiay"
                                value="43"/>
                            <label class="form-check-label" for="sizeGiay">
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