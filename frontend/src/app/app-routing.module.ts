import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ItemListComponent} from './item/item-list/item-list.component';
import {ItemEditComponent} from './item/item-edit/item-edit.component';
import {ItemAddComponent} from './item/item-add/item-add.component';

const routes: Routes = [
  { path: 'items', component: ItemListComponent },
  { path: 'item/:id', component: ItemEditComponent },
  { path: 'itemAdd', component: ItemAddComponent },
  { path: '', redirectTo: '/items', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
