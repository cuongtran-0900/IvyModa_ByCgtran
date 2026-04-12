import { IPermission } from 'app/shared/model/permission.model';

export interface IRole {
  id?: number;
  name?: string;
  description?: string | null;
  permissions?: IPermission[] | null;
}

export const defaultValue: Readonly<IRole> = {};
