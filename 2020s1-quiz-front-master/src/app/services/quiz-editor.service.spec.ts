import { TestBed } from '@angular/core/testing';

import { QuizEditorService } from './quiz-editor.service';

describe('QuizEditorService', () => {
  let service: QuizEditorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuizEditorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
