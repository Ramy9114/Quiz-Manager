import { Component, OnInit } from '@angular/core';
import { applySourceSpanToStatementIfNeeded } from '@angular/compiler/src/output/output_ast';
import { Question } from 'src/app/datamodel/question';
import { QuizCreationService } from 'src/app/services/quiz-creation.service';
import { MCQChoice } from 'src/app/datamodel/mcqChoice';

@Component({
  selector: 'app-quiz-creator',
  templateUrl: './quiz-creator.component.html',
  styleUrls: ['./quiz-creator.component.css']
})
export class QuizCreatorComponent implements OnInit {

  question : Question = new Question()
  currentCorrectAnswer: String

  choices : MCQChoice[] = [];

  constructor(private quizCreationService: QuizCreationService) {
    // console.log(localStorage.getItem)
   }

  ngOnInit(): void {
  }

  show(){
    alert(this.question.title)
  }

  create(questionTitle : string, firstChoice: string, secondChoice : string, thirdChoice : string, fourthChoice : string, correctAnswer : string){
    // alert("the question is: " + questionTitle + " and the choices are: " +firstChoice+", " + secondChoice+", " +thirdChoice+ ", " + fourthChoice);
    // alert("the correct answer question is: " + correctAnswer);

    this.question.title = questionTitle;
    console.log(this.question.title);

    //adding choices process
    this.question.addChoices(firstChoice, secondChoice, thirdChoice, fourthChoice, correctAnswer);

    // this.question.exam.title = localStorage.getItem("currentExam")
    this.question.examID = localStorage.getItem("currentExam")

    this.quizCreationService.createQuestionAndChoices(this.question);
  }
  

}

