import { UserDTO } from "../model/UserDTO";
import { User } from "../model/UserModel";

export interface IUserApi {
    getAllUsers(): Promise<Array<User>>;
    registerUser(user: UserDTO): Promise<User>; 
    loginUser(username: string, password: string): Promise<User>; 
    getUserById(id: string): Promise<User>; 
    updateUser(id: string, user: UserDTO): Promise<User>; 
    deleteUser(id: string): Promise<void>;
}