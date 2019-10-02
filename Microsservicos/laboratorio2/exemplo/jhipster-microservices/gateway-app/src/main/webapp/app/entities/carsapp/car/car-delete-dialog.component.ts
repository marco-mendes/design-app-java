import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ICar } from 'app/shared/model/carsapp/car.model';
import { CarService } from './car.service';

@Component({
  selector: 'jhi-car-delete-dialog',
  templateUrl: './car-delete-dialog.component.html'
})
export class CarDeleteDialogComponent {
  car: ICar;

  constructor(protected carService: CarService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.carService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'carListModification',
        content: 'Deleted an car'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-car-delete-popup',
  template: ''
})
export class CarDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ car }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(CarDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.car = car;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/car', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/car', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          }
        );
      }, 0);
    });
  }

  ngOnDestroy() {
    this.ngbModalRef = null;
  }
}
