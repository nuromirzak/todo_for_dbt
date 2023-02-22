export class Item {
  id: string;
  description: string;
  done: boolean;

  constructor(id: string, description: string, done: boolean) {
    this.id = id;
    this.description = description;
    this.done = done;
  }
}
