import { IUserAccount } from 'app/shared/model/user-account.model';

export interface IOrder {
  id?: number;
  totalAmount?: number;
  status?: string;
  paymentMethod?: string;
  shippingAddress?: string;
  user?: IUserAccount | null;
}

export const defaultValue: Readonly<IOrder> = {};
