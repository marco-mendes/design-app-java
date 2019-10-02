export interface IDealer {
  id?: number;
  name?: string;
  address?: string;
}

export class Dealer implements IDealer {
  constructor(public id?: number, public name?: string, public address?: string) {}
}
