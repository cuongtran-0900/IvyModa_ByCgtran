import dayjs from 'dayjs';
import { IUserAccount } from 'app/shared/model/user-account.model';

export interface ICart {
  id?: number;
  createAt?: dayjs.Dayjs | null;
  user?: IUserAccount | null;
}

export const defaultValue: Readonly<ICart> = {};
