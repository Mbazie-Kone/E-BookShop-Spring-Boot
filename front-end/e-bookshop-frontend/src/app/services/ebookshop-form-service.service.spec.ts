import { TestBed } from '@angular/core/testing';

import { EbookshopFormServiceService } from './ebookshop-form-service.service';

describe('EbookshopFormServiceService', () => {
  let service: EbookshopFormServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EbookshopFormServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
