const React = require('react');

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

export default QuestionList;