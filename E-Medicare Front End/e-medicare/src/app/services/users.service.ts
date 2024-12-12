import { Observable, tap } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Users } from "../models/users.model";
import { Router } from "@angular/router";

@Injectable ({
    providedIn: 'root'
})

export class UsersService {
    private baseUrl = 'http://localhost:9090/user';

    private userId!: number;

    constructor(private http: HttpClient, private router: Router) { }

    getAllUsers(): Observable<Users[]> {
        return this.http.get<Users[]>(`${this.baseUrl}/`);
    }

    getUserById(userId: number): Observable<Users> {
        return this.http.get<Users>(`${this.baseUrl}/${userId}`);
    }

    addUser(user: Users): Observable<Users> {
        return this.http.post<Users>(`${this.baseUrl}`, user);
    }

    updateUser(userId: number, user: Users): Observable<Users> {
        return this.http.put<Users>(`${this.baseUrl}/${userId}`, user);
    }

    deleteUserById(userId: number): Observable<Object> {
        return this.http.delete(`${this.baseUrl}/${userId}`, {responseType: 'text'});
    }

    login(username: string, password: string): Observable<Users> {
        console.log("login method: ", username, password);
        return this.http.post<Users>(`${this.baseUrl}/login/${username}/${password}`, {}).pipe(
            tap(user => {
                if (user) {
                  sessionStorage.setItem('userId', user.userId.toString());
                }
            })
        );
    }
    
    logout() {
        sessionStorage.removeItem('userId');
        this.router.navigate(['/login']);
    }

    getUserId(): number {
        const userId = sessionStorage.getItem('userId');
        return userId ? Number(userId) : 0;
    }

}