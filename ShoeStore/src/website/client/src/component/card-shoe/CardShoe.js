import React, {Component} from 'react';
import {Card} from 'antd';
import { withRouter } from 'react-router-dom';

import './CardShoe.css';

class CardShoe extends Component {

    constructor(props) {
        super(props);

    }

    handleClick = (idGiay) => {
        window.scrollTo(0, 0);
        this.props.history.push('/chi-tiet-giay/' + idGiay);

    }

    render() {

        var {listGiay} = this.props;

        if(!listGiay || listGiay.length <= 0) {
            return <div></div>;
        }

        var eleListGiay = listGiay.map((giay, index) => {
            return (
                <div className="col-md-6 col-lg-3 mt-2 " key={index}>
                    <Card className="card-shoe" onClick={()=>this.handleClick(giay.idGiay)}>
                        <div>
                            <img
                                alt={giay.tenGiay}
                                width="100%"
                                style={{
                                height: '100px'
                            }}
                                src={giay.img}/>
                        </div>
                        <div className="mt-4">
                            <p>{giay.loaiGiay}</p>
                            <hr/>
                            <h6>{giay.tenGiay}</h6>
                            <p>{giay.giaBan}$</p>
                        </div>
                    </Card>
                </div>

            );
        });

        return (
            <React.Fragment>
                <div className="row equal">
                    {eleListGiay}
                </div>

            </React.Fragment>
        );
    }
}

export default withRouter(CardShoe);
