import { Component, OnInit } from '@angular/core';
import { ExamService } from 'src/app/services/exam.service';
import { Exam } from 'src/app/datamodel/exam';
import { Question } from 'src/app/datamodel/question';


@Component({
  selector: 'app-land-page',
  templateUrl: './land-page.component.html',
  styleUrls: ['./land-page.component.css']
})
export class LandPageComponent implements OnInit {

  exam : Exam = new Exam()
  question: Question = new Question()


  constructor(private examService: ExamService) { }

  ngOnInit(): void {
  }

  createExam(examName){
    alert(examName)

    this.exam.title = examName;

    this.examService.createExam(this.exam);
  }

}
