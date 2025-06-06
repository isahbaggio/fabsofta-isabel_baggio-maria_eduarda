import { Injectable } from '@angular/core';
import { Usuario } from '../model/usuario';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  apiURL = "http://localhost:880/api/v1/usuarios"
  
  constructor(private http:HttpClient) { }

  getUsuarios(){
    return this.http.get<Usuario[]>(this.apiURL)
  }
}
