import React, {Component} from "react";

class Home extends Component {
    constructor() {
        super();
        this.state = {name: "zhangsna",userinfo:{username:"lisi"}}
    }

    render() {
        return (
            <div>{this.state.name}
                {this.state.userinfo.username}
            </div>
        );
    }

}

export default Home;