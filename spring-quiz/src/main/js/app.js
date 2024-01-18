'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

import QuestionList from './QuestionList.js';

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {questions: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/quiz'}).done(response => {
			this.setState({questions: response.entity.questions});
		});
	}

	render() {
		return (
			<QuestionList questions={this.state.questions}/>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
