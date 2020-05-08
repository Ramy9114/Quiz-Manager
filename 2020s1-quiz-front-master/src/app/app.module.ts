import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule , routingComponents} from './app-routing.module';
import { AppComponent } from './app.component';
import { QuestionAnswerFormComponent } from './components/question-answer-form/question-answer-form.component';
import { QuizExecutionComponent } from './components/quiz-execution/quiz-execution.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { QuizCreatorComponent } from './components/quiz-creator/quiz-creator.component';
import { LandPageComponent } from './components/land-page/land-page.component';
import { ExamResultPageComponent } from './components/exam-result-page/exam-result-page.component';



@NgModule({
  declarations: [
    AppComponent,
    QuestionAnswerFormComponent,
    routingComponents,
    HomePageComponent,
    QuizCreatorComponent,
    LandPageComponent,
    ExamResultPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
