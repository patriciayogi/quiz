'use strict';

const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

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

class QuestionList extends React.Component{
	render() {
		const questions = this.props.questions.map(question =>
			<Question key={question.id} question={question}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Question</th>
						<th>Options</th>
						<th>Explanation</th>
					</tr>
					{questions}
				</tbody>
			</table>
		)
	}
}



class Question extends React.Component{
	render() {
	    const options = this.props.question.options.map(option =>
    			<Option key={option.id} option={option}/>
    		);
		return (
			<tr>
				<td>{this.props.question.questionText}</td>
				<td>
				    <ul>
                         {options}
                    </ul>
                </td>
				<td>{this.props.question.explanation}</td>
			</tr>
		)
	}
}

class Option extends React.Component{
	render() {
		return (
            <li>{this.props.option.description}</li>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
