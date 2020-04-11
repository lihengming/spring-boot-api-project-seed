import React from "react";

// import logo from "../logo.svg";
/**
 * react 绑定属性注意点：
 * 1、for 改为htmlFor
 * 2、class 改为className
 * 3、style style={{"color":"red"}}
 */


class New extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            title: "我是一个div",
            message: "sam"
        }
        this.getMessage = this.getMessage.bind(this)
    }

    run() {
        alert("我被点击了");
    }

    getData() {
        alert(this.state.title);
    }

    getMessage() {
        alert(this.state.title);
    }

    getName = () => {
        alert(this.state.title);
    }

    setMessage = (message) => {
        this.setState({message:message})
    };

    render() {
        return (
            <div title={this.state.title}>
                <ul>页面1</ul>
                <ul>页面2</ul>
                <ul>页面3</ul>
                <div className='red'>hello</div>
                <label htmlFor="name">选项</label>
                <input id="name"/>
                <div style={{"color": "red"}}>我是一个红色的div</div>
                {/*<img src={logo}/>*/}
                <button onClick={this.run}>执行方法</button>
                <br/>
                <button onClick={this.getData.bind(this)}>执行方法-第一种改变this指向的方法</button>
                <br/>
                <button onClick={this.getMessage}>执行方法-第二种改变this指向的方法</button>
                <br/>
                <button onClick={this.getName}>执行方法-第三种改变this指向的方法</button>
                <br/>
                <button onClick={this.setMessage.bind(this,"zhansam1")}>执行方法传值</button>
                <div>{this.state.message}</div>


            </div>
        );
    }

}

export default New;