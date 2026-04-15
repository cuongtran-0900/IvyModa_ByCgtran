import { IProduct } from 'app/shared/model/product.model';
import { ProductSize } from 'app/shared/model/enumerations/product-size.model';
import { Color } from 'app/shared/model/enumerations/color.model';

export interface IProductVariant {
  id?: number;
  productSize?: keyof typeof ProductSize;
  color?: keyof typeof Color;
  price?: number;
  stock?: number;
  imageUrl?: string;
  isActive?: boolean;
  product?: IProduct | null;
}

export const defaultValue: Readonly<IProductVariant> = {
  isActive: false,
};
