export interface ItemAdd {
  id: number;
  name: string;
  description?: string;
  price: number;
  available: boolean;
  stockQuantity: number;
  categoryId: number;
}
