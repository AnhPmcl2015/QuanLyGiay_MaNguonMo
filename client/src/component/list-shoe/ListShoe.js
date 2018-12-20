import React, {Component} from 'react';
import './ListShoe.css';
import {
    Card,
    CardImg,
    CardText,
    CardBody,
    CardTitle,
    Button
} from 'reactstrap';

class ListShoe extends Component {
    render() {

        return (
            <React.Fragment>
                <div className="row">
                    <Card className='col-3 pt-2'>
                        <CardImg top className="carImg" src="images/logo.png" alt="Card image cap"/>
                        <CardBody>
                            <CardText>Air Jordans 1</CardText>
                            <hr/>
                            <CardTitle>Air Jordan 1</CardTitle>
                            <CardText>4.378.000đ</CardText>
                            <Button>Xem thông tin</Button>
                        </CardBody>
                    </Card>
                </div>

            </React.Fragment>
        );
    }
}

export default ListShoe;