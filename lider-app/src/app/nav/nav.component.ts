import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  constructor() { }

  private validateProcess = /^[a-zA-Z0-9 ñÑ]{1,20}$/g;

  @Output() searchEvent: EventEmitter<string> = new EventEmitter();

  onKey(valueSearch: string) {
    if (valueSearch) {
      if (!valueSearch.match(this.validateProcess)) {
        alert("No envie simbolos, tenga presente que este buscador tiene un tamño de 20 caracteres");
      } else {
        if (valueSearch.length > 2) {
          this.searchEvent.emit(valueSearch);
        } else {
          if (parseInt(valueSearch)) {
            this.searchEvent.emit(valueSearch);
          }
        }
      }
    }

  }

  ngOnInit(): void {
  }

}
