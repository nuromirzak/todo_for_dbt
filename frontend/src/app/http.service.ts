import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class HttpService {
  private backendUrl = 'http://localhost:4000/todo';

  constructor(private http: HttpClient) {
  }

  getData(): Observable<any> {
    return this.http.get(`${this.backendUrl}/all`);
  }

  postData(data: any): Observable<any> {
    return this.http.post(`${this.backendUrl}/save`, data);
  }

  putData(id: string, data: any): Observable<any> {
    return this.http.put(`${this.backendUrl}/${id}`, data);
  }

  deleteData(id: string): Observable<any> {
    return this.http.delete(`${this.backendUrl}/delete/${id}`);
  }
}
