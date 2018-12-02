import React, {Component} from 'react';
import './Carousel.css';
import ReactDOM from 'react-dom';
import "react-responsive-carousel/lib/styles/carousel.min.css";
import {Carousel} from 'react-responsive-carousel';

class CarouselCustom extends Component {
    render() {
        return (
            <React.Fragment>
                <Carousel className="mt-2" showThumbs={false} showStatus={false}>
                    <div><img src="images/logo.png"/></div>
                    <div>
                        <img src="images/logo.png"/>
                    </div>
                    <div>
                        <img src="images/logo.png"/>
                    </div>
                </Carousel>
            </React.Fragment>
        );
    }
}

export default CarouselCustom;
