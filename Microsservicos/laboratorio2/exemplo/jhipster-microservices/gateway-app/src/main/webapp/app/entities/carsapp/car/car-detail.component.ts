import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ICar } from 'app/shared/model/carsapp/car.model';

@Component({
  selector: 'jhi-car-detail',
  templateUrl: './car-detail.component.html'
})
export class CarDetailComponent implements OnInit {
  car: ICar;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ car }) => {
      this.car = car;
    });
  }

  previousState() {
    window.history.back();
  }
}
