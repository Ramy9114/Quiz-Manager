import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExamResultService {
  url :string ="http://localhost:8080/quiz-manager-rest/rest/exam/get-all-answers";
  url2 :string ="http://localhost:8080/quiz-manager-rest/rest/exam/get-exam-result";

  answers = [];
  result :any ;
  constructor(private httpClient: HttpClient) { }


  getAllAnswers(){
    this.httpClient.get(this.url, {responseType: 'json'}).toPromise().then(data => {
      console.log(data);

      for(let key in data){
        if(data.hasOwnProperty(key)){
          this.answers.push(data[key]);
        }
      }
      
    });
    return this.answers;
  }

  getScore(){

    this.httpClient.get(this.url2, {responseType: 'json'}).toPromise().then(data => {
      console.log(data);

      for(let key in data){
        if(data.hasOwnProperty(key)){
          this.answers.push(data[key]);
        }
      }
      this.result = data
      
    });
    return this.result;
  }
}
