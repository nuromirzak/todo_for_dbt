import {Component, Input, Output, EventEmitter} from "@angular/core";
import {Item} from "../item";
import {HttpService} from "../http.service";
@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css']
})

export class ItemComponent {
  editable = false;

  constructor(private httpService: HttpService) {
    console.log('AppComponent constructor');
  }

  @Input() item!: Item;
  @Input() newItem!: string;
  @Output() remove = new EventEmitter<Item>();

  saveItem(description: string) {
    if (!description) return;
    this.httpService.putData(this.item.id, {description: description, done: this.item.done}).subscribe((data: any) => {
      this.editable = false;
      this.item.description = description;
    });
  }

  checkItem() {
    this.httpService.putData(this.item.id, {description: this.item.description, done: !this.item.done}).subscribe((data: any) => {
      this.item.done = !this.item.done;
    });
  }
}
