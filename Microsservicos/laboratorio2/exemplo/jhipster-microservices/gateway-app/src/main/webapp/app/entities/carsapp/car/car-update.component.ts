import { Component, OnInit } from '@angular/core';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { ICar, Car } from 'app/shared/model/carsapp/car.model';
import { CarService } from './car.service';

@Component({
  selector: 'jhi-car-update',
  templateUrl: './car-update.component.html'
})
export class CarUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    make: [],
    model: [],
    price: []
  });

  constructor(protected carService: CarService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ car }) => {
      this.updateForm(car);
    });
  }

  updateForm(car: ICar) {
    this.editForm.patchValue({
      id: car.id,
      make: car.make,
      model: car.model,
      price: car.price
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const car = this.createFromForm();
    if (car.id !== undefined) {
      this.subscribeToSaveResponse(this.carService.update(car));
    } else {
      this.subscribeToSaveResponse(this.carService.create(car));
    }
  }

  private createFromForm(): ICar {
    return {
      ...new Car(),
      id: this.editForm.get(['id']).value,
      make: this.editForm.get(['make']).value,
      model: this.editForm.get(['model']).value,
      price: this.editForm.get(['price']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICar>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
}
