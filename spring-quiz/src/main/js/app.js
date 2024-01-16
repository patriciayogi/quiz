'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {questions: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/questions'}).done(response => {
			this.setState({questions: response.entity._embedded.questions});
		});
	}

	render() { // <3>
		return (
			<QuestionList questions={this.state.questions}/>
		)
	}
}
// end::app[]

// tag::employee-list[]
class QuestionList extends React.Component{
	render() {
		const questions = this.props.questions.map(question =>
			<Employee key={question._links.self.href} question={question}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Question</th>
						<th>Explanation</th>
					</tr>
					{questions}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class Employee extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.question.questionText}</td>
				<td>{this.props.question.explanation}</td>
			</tr>
		)
	}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]