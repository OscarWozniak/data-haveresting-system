import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkedInTabComponent } from './linked-in-tab.component';

describe('LinkedInTabComponent', () => {
  let component: LinkedInTabComponent;
  let fixture: ComponentFixture<LinkedInTabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LinkedInTabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LinkedInTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
