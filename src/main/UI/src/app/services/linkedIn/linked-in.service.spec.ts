import { TestBed, inject } from '@angular/core/testing';

import { LinkedInService } from './linked-in.service';

describe('LinkedInService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LinkedInService]
    });
  });

  it('should be created', inject([LinkedInService], (service: LinkedInService) => {
    expect(service).toBeTruthy();
  }));
});
