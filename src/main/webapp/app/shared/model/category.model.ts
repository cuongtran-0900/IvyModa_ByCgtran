export interface ICategory {
  id?: number;
  name?: string;
  slug?: string;
  isActive?: boolean;
  parent?: ICategory | null;
}

export const defaultValue: Readonly<ICategory> = {
  isActive: false,
};
