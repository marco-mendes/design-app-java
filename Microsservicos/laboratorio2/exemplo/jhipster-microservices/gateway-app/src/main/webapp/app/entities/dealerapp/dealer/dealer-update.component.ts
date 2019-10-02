import { Component, OnInit } from '@angular/core';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { IDealer, Dealer } from 'app/shared/model/dealerapp/dealer.model';
import { DealerService } from './dealer.service';

@Component({
  selector: 'jhi-dealer-update',
  templateUrl: './dealer-update.component.html'
})
export class DealerUpdateComponent implements OnInit {
  isSaving: boolean;

  editForm = this.fb.group({
    id: [],
    name: [],
    address: []
  });

  constructor(protected dealerService: DealerService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ dealer }) => {
      this.updateForm(dealer);
    });
  }

  updateForm(dealer: IDealer) {
    this.editForm.patchValue({
      id: dealer.id,
      name: dealer.name,
      address: dealer.address
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const dealer = this.createFromForm();
    if (dealer.id !== undefined) {
      this.subscribeToSaveResponse(this.dealerService.update(dealer));
    } else {
      this.subscribeToSaveResponse(this.dealerService.create(dealer));
    }
  }

  private createFromForm(): IDealer {
    return {
      ...new Dealer(),
      id: this.editForm.get(['id']).value,
      name: this.editForm.get(['name']).value,
      address: this.editForm.get(['address']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDealer>>) {
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
