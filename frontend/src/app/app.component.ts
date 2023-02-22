import {Component, OnInit} from '@angular/core';
import {Item} from "./item";
import {HttpService} from "./http.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit {
  title = 'todo';

  filter: 'all' | 'active' | 'done' = 'all';

  constructor(private httpService: HttpService) {
    console.log('AppComponent constructor');
  }

  ngOnInit() {
    this.httpService.getData().subscribe((data: any) => {
      this.allItems = this.allItems.concat(data);
    });
  }

  allItems: Item[] = [
    // new Item("Initial", "This is the first item", false),
    // new Item("Initial", "This is the second item", false),
    // new Item("Initial", "This is the third item", false),
  ];

  get items() {
    if (this.filter === 'all') {
      return this.allItems;
    }
    return this.allItems.filter((item) => this.filter === 'done' ? item.done : !item.done);
  }

  addItem(description: string) {
    this.httpService.postData({description: description}).subscribe((data: any) => {
      this.allItems.unshift(new Item(data.id, description, false));
    });
  }

  remove(item: Item) {
    // this.allItems.splice(this.allItems.indexOf(item), 1);
    this.httpService.deleteData(item.id).subscribe((data: any) => {
      this.allItems.splice(this.allItems.indexOf(item), 1);
    });
  }
}
