import { IRole } from 'app/shared/model/role.model';

export interface IUserAccount {
  id?: number;
  name?: string | null;
  email?: string;
  password?: string;
  address?: string | null;
  isActive?: boolean | null;
  role?: IRole | null;
}

export const defaultValue: Readonly<IUserAccount> = {
  isActive: false,
};
