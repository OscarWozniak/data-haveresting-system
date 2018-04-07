import { TestBed, inject } from '@angular/core/testing';

import { DynamicTwitterService } from './dynamic-twitter.service';

describe('DynamicTwitterService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DynamicTwitterService]
    });
  });

  it('should be created', inject([DynamicTwitterService], (service: DynamicTwitterService) => {
    expect(service).toBeTruthy();
  }));
});
