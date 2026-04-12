import { IRole } from 'app/shared/model/role.model';

export interface IPermission {
  id?: number;
  name?: string;
  description?: string | null;
  roles?: IRole[] | null;
}

export const defaultValue: Readonly<IPermission> = {};
