import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CroverableWebsiteComponent } from './croverable-website.component';

describe('CroverableWebsiteComponent', () => {
  let component: CroverableWebsiteComponent;
  let fixture: ComponentFixture<CroverableWebsiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CroverableWebsiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CroverableWebsiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
