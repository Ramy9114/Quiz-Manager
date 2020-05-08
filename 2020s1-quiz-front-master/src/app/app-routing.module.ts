import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { QuizExecutionComponent } from './components/quiz-execution/quiz-execution.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { QuizCreatorComponent } from './components/quiz-creator/quiz-creator.component';
import { LandPageComponent } from './components/land-page/land-page.component';
import { ExamResultPageComponent } from './components/exam-result-page/exam-result-page.component';

const routes: Routes = [
  {path: "home-page", component: HomePageComponent},
  {path: "quiz-creator", component: QuizCreatorComponent},
  {path: "quiz-execution", component: QuizExecutionComponent},
  {path: "exam-result-page", component: ExamResultPageComponent},
  {path: "", component: LandPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [HomePageComponent ,QuizCreatorComponent, QuizExecutionComponent, ExamResultPageComponent]
