import { TestBed, inject } from '@angular/core/testing';

import { DynamicLinkedInService } from './dynamic-linked-in.service';

describe('DynamicLinkedInService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DynamicLinkedInService]
    });
  });

  it('should be created', inject([DynamicLinkedInService], (service: DynamicLinkedInService) => {
    expect(service).toBeTruthy();
  }));
});
