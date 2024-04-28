import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SingleContactsComponent } from './single-contacts.component';

describe('SingleContactsComponent', () => {
  let component: SingleContactsComponent;
  let fixture: ComponentFixture<SingleContactsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SingleContactsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SingleContactsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
