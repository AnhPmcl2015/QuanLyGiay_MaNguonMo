import React, {Component} from 'react';
import ListShoe from '../list-shoe/ListShoe';
import SideNav from '../side-nav/SideNav';
import CarouselCustom from '../carousel/Carousel';

class Home extends Component {
    render() {
        return (
            <React.Fragment>
                <CarouselCustom/>
                <h1 className="mt-5 mb-4 text-center">Nổi bật nhất</h1>
                <div className="row main-content">
                    <div className="col-2"><SideNav/></div>

                    <div className="col-10"><ListShoe/></div>
                </div>
            </React.Fragment>
        );
    }
}

export default Home;
