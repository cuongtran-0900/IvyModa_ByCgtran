import dayjs from 'dayjs';
import { ICategory } from 'app/shared/model/category.model';

export interface IProduct {
  id?: number;
  name?: string;
  slug?: string;
  brand?: string;
  introduce?: string | null;
  createAt?: dayjs.Dayjs;
  updateAt?: dayjs.Dayjs;
  isActive?: boolean;
  category?: ICategory | null;
}

export const defaultValue: Readonly<IProduct> = {
  isActive: false,
};
