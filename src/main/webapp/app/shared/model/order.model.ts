import { IUserAccount } from 'app/shared/model/user-account.model';
import { Status } from 'app/shared/model/enumerations/status.model';
import { PaymentMethod } from 'app/shared/model/enumerations/payment-method.model';

export interface IOrder {
  id?: number;
  totalAmount?: number;
  status?: keyof typeof Status;
  paymentMethod?: keyof typeof PaymentMethod;
  shippingAddress?: string;
  user?: IUserAccount | null;
}

export const defaultValue: Readonly<IOrder> = {};
