import { TestBed } from '@angular/core/testing';

import { ConSService } from './con-s.service';

describe('ConSService', () => {
  let service: ConSService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConSService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
