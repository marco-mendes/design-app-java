import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared/shared.module';
import { DealerComponent } from './dealer.component';
import { DealerDetailComponent } from './dealer-detail.component';
import { DealerUpdateComponent } from './dealer-update.component';
import { DealerDeletePopupComponent, DealerDeleteDialogComponent } from './dealer-delete-dialog.component';
import { dealerRoute, dealerPopupRoute } from './dealer.route';

const ENTITY_STATES = [...dealerRoute, ...dealerPopupRoute];

@NgModule({
  imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [DealerComponent, DealerDetailComponent, DealerUpdateComponent, DealerDeleteDialogComponent, DealerDeletePopupComponent],
  entryComponents: [DealerDeleteDialogComponent]
})
export class DealerappDealerModule {}
