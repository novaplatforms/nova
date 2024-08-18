export class UserDTO {
    private username: string;
    private fullname: string;
    private email: string; 
    private password: string;

    constructor(username: string, fullname: string, email: string, password: string) {
        this.username = username;
        this.fullname = fullname;
        this.email = email; 
        this.password = password;
    } 

    public getUsername(): string {
        return this.username;
    }

    public setUsername(username: string): void {
        this.username = username;
    }

    public getFullname(): string {
        return this.fullname;
    }

    public setFullname(fullname: string): void {
        this.fullname = fullname; 
    }

    public getEmail(): string {
        return this.email; 
    }

    public setEmail(email: string): void {
        this.email = email; 
    }

    public getPassword(): string {
        return this.password;
    }

    public setPassword(password: string): void {
        this.password = password; 
    }
    
    public toString(): string {
        return `UserDTO { username: ${this.username}, fullname: ${this.fullname}, 
        email: ${this.email}, password: ${this.password} }`;
    }
}
