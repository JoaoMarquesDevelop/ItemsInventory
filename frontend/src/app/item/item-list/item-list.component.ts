import {Component, OnInit} from '@angular/core';
import {ItemService} from '../item.service';
import {Item} from '../item';
import {Router} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-item-list',
  standalone: false,
  templateUrl: './item-list.component.html',
  styleUrl: './item-list.component.css'
})
export class ItemListComponent implements OnInit {
  items: Item[] = [];
  searchQuery: string = '';

  constructor(private itemService: ItemService,
              private router: Router,
              private location: Location) {}

  ngOnInit() {
    this.itemService.getItems().subscribe(data => {
      this.items = data;
    });
  }

  fetchItems() {
    this.itemService.getItems().subscribe(data => {
      this.items = data;
    });
  }

  deleteItem(item: Item) {
    if (confirm(`Are you sure you want to delete ${item.name}?`)) {
      this.itemService.deleteItem(item.id).subscribe(() => {
        this.fetchItems();
      });
    }
  }

  editItem(item: Item) {
    this.router.navigate(['/item/', item.id]);
  }

  filteredItems() {
    if (!this.searchQuery) {
      // If no search query, return all items
      return this.items;
    }
    return this.items.filter((item) =>
      item.name.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
  }

  addNewItem() {
    this.router.navigate(['/itemAdd']);
  }
}
