import { TestBed } from '@angular/core/testing';

import { HistoryService } from './history.service';

describe('HistoryServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HistoryService = TestBed.get(HistoryService);
    expect(service).toBeTruthy();
  });
});
