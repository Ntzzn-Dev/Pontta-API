import { Component, signal } from '@angular/core';
import { MainNavComponent } from './main-nav/main-nav.component';

@Component({
  selector: 'app-root',
  imports: [MainNavComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
}
