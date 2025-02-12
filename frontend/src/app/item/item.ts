export interface Item {
  id: number;
  name: string;
  description?: string;
  price: number;
  available: boolean;
  stockQuantity: number;
  categoryPath: string;
}
