import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDealer } from 'app/shared/model/dealerapp/dealer.model';

@Component({
  selector: 'jhi-dealer-detail',
  templateUrl: './dealer-detail.component.html'
})
export class DealerDetailComponent implements OnInit {
  dealer: IDealer;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ dealer }) => {
      this.dealer = dealer;
    });
  }

  previousState() {
    window.history.back();
  }
}
