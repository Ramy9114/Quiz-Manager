import { Component, OnInit } from '@angular/core';
import { QuizEditorService } from 'src/app/services/quiz-editor.service';
import { Exam } from 'src/app/datamodel/exam';
import { ExamService } from 'src/app/services/exam.service';
import { Answer } from 'src/app/datamodel/answer';
import { Question } from 'src/app/datamodel/question';

@Component({
  selector: 'app-quiz-execution',
  templateUrl: './quiz-execution.component.html',
  styleUrls: ['./quiz-execution.component.css']
})
export class QuizExecutionComponent implements OnInit {

  Examquestions : any;
  Examchoices : any;

  answer : Answer = new Answer();
  // question : Question = new Question();
  // exam : Exam = new Exam();


  constructor(private quizEditorService : QuizEditorService, private examService : ExamService) {}

  ngOnInit(): void {
  }

  getQuestions(){
    this.Examquestions =  this.quizEditorService.getAllQuestions()
   }
 
   getChoices(){
     var name = []
    for(var key in this.Examquestions){
     if(this.Examquestions.hasOwnProperty){
       name.push(this.Examquestions[key].id)
     }
    }
    console.log(name)
    for(var id in name){
      this.Examchoices = this.quizEditorService.getChoices(name[id]);
    }
    console.log(this.Examchoices)
   }

   submitAnswer(answer, questionId){
    // console.log(answer)
    // console.log(questionId)
    let id = this.Examquestions[questionId].id
    // console.log(id)
    let choice : any;
    let choiceId : any;
      
      for (var i = 0; i < this.Examchoices.length; i++) {
        if(this.Examchoices[i].question.id == id){
          // this.question.mcqChoices.push(this.Examchoices[i])

          if(this.Examchoices[i].choice === answer){
            this.answer.content = answer
            
            this.answer.questionId = Number(this.Examchoices[i].question.id)

            this.answer.examId = Number(localStorage.getItem("currentExam"))
            if(this.Examchoices[i].valid == true){
                this.answer.isCorrect = true
            }else{
              this.answer.isCorrect = false
            }
          }
        }
      }
      
      this.examService.submitAnswer(this.answer);
      
    }
      

      
   

  



}
