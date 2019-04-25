import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PhonesShowComponent } from './phones-show.component';

describe('PhonesShowComponent', () => {
  let component: PhonesShowComponent;
  let fixture: ComponentFixture<PhonesShowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PhonesShowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PhonesShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
