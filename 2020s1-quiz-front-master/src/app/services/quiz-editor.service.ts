import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class QuizEditorService {
  url :string ="http://localhost:8080/quiz-manager-rest/rest/editor/get-all-questions/";

  url2 :string ="http://localhost:8080/quiz-manager-rest/rest/editor/get-choices/";


  result = [];
  choices_result = [];

  constructor(private httpClient: HttpClient) { }

  getAllQuestions(){

    this.httpClient.get(this.url.concat(localStorage.getItem("currentExam")), {responseType: 'json'}).toPromise().then(data => {
      console.log(data);

      for(let key in data){
        if(data.hasOwnProperty(key)){
          this.result.push(data[key]);
        }
      }
      
    });
    console.log(this.result)
    return this.result;
  }

  getChoices(questionId){
    // console.log(questionId)
    this.httpClient.get(this.url2.concat(questionId), {responseType: 'json'}).toPromise().then(data => {
      console.log(data);
      for(let key in data){
        if(data.hasOwnProperty(key)){
          this.choices_result.push(data[key]);
        }
      }

    });

    return this.choices_result
  }

    

}
