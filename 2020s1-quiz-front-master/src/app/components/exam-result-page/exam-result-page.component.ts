import { Component, OnInit } from '@angular/core';
import { ExamService } from 'src/app/services/exam.service';
import { ExamResultService } from 'src/app/services/exam-result.service';

@Component({
  selector: 'app-exam-result-page',
  templateUrl: './exam-result-page.component.html',
  styleUrls: ['./exam-result-page.component.css']
})
export class ExamResultPageComponent implements OnInit {

  answers =[];
  result : any;
  constructor(private examResultService : ExamResultService) { }

  ngOnInit(): void {
  }

  getAllAnswers(){
    this.answers = this.examResultService.getAllAnswers();
  }

  getResult(){
    this.result = this.examResultService.getScore()
    alert("Your Score is: " +this.result + "/" + this.answers.length)
  }
}
