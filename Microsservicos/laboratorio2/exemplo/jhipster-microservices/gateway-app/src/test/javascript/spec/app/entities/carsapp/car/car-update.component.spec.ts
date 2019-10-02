import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { CarUpdateComponent } from 'app/entities/carsapp/car/car-update.component';
import { CarService } from 'app/entities/carsapp/car/car.service';
import { Car } from 'app/shared/model/carsapp/car.model';

describe('Component Tests', () => {
  describe('Car Management Update Component', () => {
    let comp: CarUpdateComponent;
    let fixture: ComponentFixture<CarUpdateComponent>;
    let service: CarService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [GatewayTestModule],
        declarations: [CarUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(CarUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(CarUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(CarService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new Car(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new Car();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
