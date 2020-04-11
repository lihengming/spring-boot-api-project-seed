import React, {Component} from "react";

class ReactForm extends Component {
    constructor(props) {
        super(props);
        this.state = {
            msg: "表单",
            name: "zhansan",
            citys: ["北京", "上海"]
        }
    }

    handleSubmit = (e) => {
        e.preventDefault();
        alert(this.state.name);
    }
    setName = (e) => {
        this.setState({name: e.target.value});
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <input type={Text} defaultValue={this.state.name} onChange={this.setName}/>
                    <button type={"submit"}>提交</button>
                </form>
            </div>
        );
    }

}

export default ReactForm;