import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Question } from '../datamodel/question';
import { MCQChoice } from '../datamodel/mcqChoice';


@Injectable({
  providedIn: 'root'
})
export class QuizCreationService {
  url :string ="http://localhost:8080/quiz-manager-rest/rest/creator/question-and-choices";

  constructor(private httpClient: HttpClient) { }

  createQuestionAndChoices(question){
    // alert("The Question with the choice has being created");
    console.log(question)
    this.httpClient.post(this.url, question).subscribe((data) =>
    console.log()
    );
    alert("The Question with the choice has being created");
  }
}
