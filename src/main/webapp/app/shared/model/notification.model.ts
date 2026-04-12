import dayjs from 'dayjs';
import { IOrder } from 'app/shared/model/order.model';

export interface INotification {
  id?: number;
  type?: string;
  content?: string | null;
  createAt?: dayjs.Dayjs;
  isRead?: boolean;
  order?: IOrder | null;
}

export const defaultValue: Readonly<INotification> = {
  isRead: false,
};
