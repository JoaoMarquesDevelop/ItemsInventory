import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Item} from './item';
import {ItemAdd} from './ItemAdd';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private apiUrl = 'http://localhost:8080/products';  // URL to your API

  constructor(private http: HttpClient) {}

  getItemById(itemId: number): Observable<Item> {
    return this.http.get<any>(`${this.apiUrl}/${itemId}`);
  }

  getItems(): Observable<Item[]> {
    return this.http.get<Item[]>(this.apiUrl);
  }

  deleteItem(itemId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${itemId}`);
  }

  editItem(item: Item): Observable<any> {
    return this.http.put(`${this.apiUrl}/${item.id}`, item);
  }

  addItem(item: ItemAdd): Observable<Item> {
    return this.http.post<Item>(this.apiUrl, item);
  }
}
