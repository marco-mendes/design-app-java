import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDealer } from 'app/shared/model/dealerapp/dealer.model';
import { DealerService } from './dealer.service';

@Component({
  selector: 'jhi-dealer-delete-dialog',
  templateUrl: './dealer-delete-dialog.component.html'
})
export class DealerDeleteDialogComponent {
  dealer: IDealer;

  constructor(protected dealerService: DealerService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  clear() {
    this.activeModal.dismiss('cancel');
  }

  confirmDelete(id: number) {
    this.dealerService.delete(id).subscribe(response => {
      this.eventManager.broadcast({
        name: 'dealerListModification',
        content: 'Deleted an dealer'
      });
      this.activeModal.dismiss(true);
    });
  }
}

@Component({
  selector: 'jhi-dealer-delete-popup',
  template: ''
})
export class DealerDeletePopupComponent implements OnInit, OnDestroy {
  protected ngbModalRef: NgbModalRef;

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

  ngOnInit() {
    this.activatedRoute.data.subscribe(({ dealer }) => {
      setTimeout(() => {
        this.ngbModalRef = this.modalService.open(DealerDeleteDialogComponent as Component, { size: 'lg', backdrop: 'static' });
        this.ngbModalRef.componentInstance.dealer = dealer;
        this.ngbModalRef.result.then(
          result => {
            this.router.navigate(['/dealer', { outlets: { popup: null } }]);
            this.ngbModalRef = null;
          },
          reason => {
            this.router.navigate(['/dealer', { outlets: { popup: null } }]);
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
