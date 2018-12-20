import React, {Component} from 'react';
import './Carousel.css';
import {Carousel} from 'antd';

class CarouselCustom extends Component {
    render() {
        return (
            <React.Fragment>
                <Carousel autoplay className="mt-2 mx-auto text-center">
                    <div>
                        <img src="/images/carousel1.jpg" alt="carousel"/>
                    </div>
                    <div>
                        <img src="/images/carousel2.jpg" alt="carousel"/>
                    </div>
                    <div>
                        <img src="/images/carousel3.jpg" alt="carousel"/>
                    </div>

                </Carousel>
            </React.Fragment>
        );
    }
}

export default CarouselCustom;
