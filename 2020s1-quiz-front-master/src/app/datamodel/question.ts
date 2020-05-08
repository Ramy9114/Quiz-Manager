import { MCQChoice } from './mcqChoice';
import { Exam } from './exam';

export class Question {
 
    title :string;

    mcqChoices : MCQChoice [] = [];

    // exam : Exam = new Exam();
    examID : string;
    constructor(){}  


    addChoices(firstChoice, secondChoice, thirdChoice, fourthChoice, correctAnswer){
        let firstChoiceObject : MCQChoice = new MCQChoice();
        let secondChoiceObject : MCQChoice = new MCQChoice();
        let thirdChoiceObject : MCQChoice = new MCQChoice();
        let fourthChoiceObject : MCQChoice = new MCQChoice();

        //adding first choice
        firstChoiceObject.choice = firstChoice;
        if(correctAnswer == "first"){
            firstChoiceObject.valid = true;
        }else{
            firstChoiceObject.valid = false;
        }
        
        //adding second choice
        secondChoiceObject.choice = secondChoice;
        if(correctAnswer == "second"){
            secondChoiceObject.valid = true;
        }else{
            secondChoiceObject.valid = false;
        }
        //adding third choice
        thirdChoiceObject.choice = thirdChoice;
        if(correctAnswer == "third"){
            thirdChoiceObject.valid = true;
        }else{
            thirdChoiceObject.valid = false;
        }
        
        //adding fourth choice
        fourthChoiceObject.choice = fourthChoice;
        if(correctAnswer == "fourth"){
            fourthChoiceObject.valid = true;
        }else{
            fourthChoiceObject.valid = false;
        }

        //pushing all choices objects in the mcqChoices list
        this.mcqChoices.push(firstChoiceObject);
        this.mcqChoices.push(secondChoiceObject);
        this.mcqChoices.push(thirdChoiceObject);
        this.mcqChoices.push(fourthChoiceObject);
    }
 
 
 
}