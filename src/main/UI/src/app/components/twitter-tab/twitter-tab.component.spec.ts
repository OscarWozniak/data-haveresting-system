import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TwitterTabComponent } from './twitter-tab.component';

describe('TwitterTabComponent', () => {
  let component: TwitterTabComponent;
  let fixture: ComponentFixture<TwitterTabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TwitterTabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TwitterTabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
