import {Component, OnInit} from '@angular/core';
import {Item} from '../item';
import {ActivatedRoute, Router} from '@angular/router';
import {ItemService} from '../item.service';
import {Location} from '@angular/common';

@Component({
  selector: 'app-item-edit',
  standalone: false,
  templateUrl: './item-edit.component.html',
  styleUrl: './item-edit.component.css'
})
export class ItemEditComponent implements OnInit {
  itemId: number | null = null;
  item: Item = {
    id: 0,
    name: '',
    description: '',
    price: 0,
    available: false,
    categoryPath: '',
    stockQuantity: 0
  };

  constructor(
    private itemService: ItemService,
    private route: ActivatedRoute,
    private router: Router,
    private location: Location
  ) {
  }

  ngOnInit(): void {
    // Get the item ID from the URL
    this.itemId = Number(this.route.snapshot.paramMap.get('id'));

    // If itemId is valid, fetch the item data from the API
    if (this.itemId) {
      this.itemService.getItemById(this.itemId).subscribe(data => {
        this.item = data;
      });
    }
  }

  updateItem():void {
    this.itemService.editItem(this.item).subscribe(data => {
      this.goBack();
    })
  }

  goBack():void {
    this.router.navigate(['/items']);
  }
}
