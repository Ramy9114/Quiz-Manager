import { Injectable } from '@angular/core';
import { Answer } from '../datamodel/answer';
import { HttpClient } from '@angular/common/http';
import { Exam } from '../datamodel/exam';

@Injectable({
  providedIn: 'root'
})
export class ExamService {
  url :string ="http://localhost:8080/quiz-manager-rest/rest/exam/answer";
  url2 :string ="http://localhost:8080/quiz-manager-rest/rest/exam/create-exam";
  


  constructor(private httpClient: HttpClient) { }

  createExam(exam : Exam){
    
    this.httpClient.post(this.url2, exam).subscribe((data : any) => {
    console.log(data)
    // localStorage.setItem(exam.title, data.id);
    localStorage.setItem("currentExam", data.id);
    });
  }

  submitAnswer(answer : Answer){
    this.httpClient.post(this.url, answer).subscribe((data : any) => {
      console.log(data)
      });
  }


}