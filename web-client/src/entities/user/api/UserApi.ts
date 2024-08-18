import { UserDTO } from "../model/UserDTO";
import { User } from "../model/UserModel";
import { IUserApi } from "./IUserApi";

export class UserApi implements IUserApi {
    getAllUsers(): Promise<Array<User>> {
        throw new Error("Method not implemented.");
    }
    registerUser(user: UserDTO): Promise<User> {
        throw new Error("Method not implemented.");
    }
    loginUser(username: string, password: string): Promise<User> {
        throw new Error("Method not implemented.");
    }
    getUserById(id: string): Promise<User> {
        throw new Error("Method not implemented.");
    }
    updateUser(id: string, user: UserDTO): Promise<User> {
        throw new Error("Method not implemented.");
    }
    deleteUser(id: string): Promise<void> {
        throw new Error("Method not implemented.");
    }
}