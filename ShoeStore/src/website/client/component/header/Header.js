import React, {Component} from 'react';
import './Header.css';
import $ from 'jquery';
import Select2 from 'react-select2-wrapper';
window.jQuery = $;
window.$ = $;
global.jQuery = $;

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = ({
            data: [
                'bug', 'feature', 'documents', 'discussion'
            ],
            options: {
                placeholder: 'Tìm kiếm tên giày',
                allowClear: true,
                width: '300px'
            }
        });
    }
    render() {

        return (

            <React.Fragment>
                <header className="row align-items-center">
                    <div className="col-lg-8 col-xl-10">
                        <img id="logo" src="/images/logo.png" className="mr-3" alt="Không có hình ảnh"/>
                        <Select2 data={this.state.data} options={this.state.options}/>
                    </div>

                    <div className="col-lg-4 col-xl-2 text-right">
                        <ul className="list-inline">
                            <li class="list-inline-item">Đăng nhập |</li>
                            <li class="list-inline-item">$0 <i class="fa fa-arrow-down"></i></li>
                        </ul>
                    </div>
                </header>
            </React.Fragment>
        );
    }
}

export default Header;