import { Component } from '@angular/core';
import {Item} from '../item';
import {ItemService} from '../item.service';
import {Router} from '@angular/router';
import {ItemAdd} from '../ItemAdd';

@Component({
  selector: 'app-item-add',
  standalone: false,
  templateUrl: './item-add.component.html',
  styleUrl: './item-add.component.css'
})
export class ItemAddComponent {

  item: ItemAdd = {
    id: 0,
    name: '',
    description: '',
    price: 0,
    available: false,
    categoryId: 0,
    stockQuantity: 0
  };

  constructor(private itemService: ItemService, private router: Router) {}

  addItem() {
    this.itemService.addItem(this.item).subscribe(
      (response) => {
        this.goBack();
      },
      (error) => {
        console.error('Error adding item', error);
        this.goBack();
      }
    );
  }

  // Navigate back to the item list page without saving
  goBack() {
    this.router.navigate(['/']);
  }
}
