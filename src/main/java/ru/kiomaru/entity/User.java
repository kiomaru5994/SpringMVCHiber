package ru.kiomaru.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно содержать от 2 до 30 символов")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Фамилия не должна быть пустой")
    @Column(name = "second_name")
    private String lastName;

    @Column(name = "age")
    @Min(value = 0, message = "Возраст не может быть меньше нуля")
    private int age;

    @NotEmpty(message = "Login не должен быть пустым")
    @Size(min = 5, max = 15, message = "Никнейм должен содержать от 5 до 15 символов")
    @Column(name = "user_login")
    private String userLogin;

    @NotEmpty(message = "Email не должен быть пустым")
    @Email(message = "Email некорректный")
    @Column(name = "email")
    private String email;

    public User(String firstName, String lastName, int age, String userLogin, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userLogin = userLogin;
        this.email = email;
    }

    public User() {

    }

    public @NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 30, message = "Имя должно содержать от 2 до 30 символов") String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 30, message = "Имя должно содержать от 2 до 30 символов") String firstName) {
        this.firstName = firstName;
    }

    public @NotEmpty(message = "Фамилия не должна быть пустой") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty(message = "Фамилия не должна быть пустой") String lastName) {
        this.lastName = lastName;
    }

    @Min(value = 0, message = "Возраст не может быть меньше нуля")
    public int getAge() {
        return age;
    }

    public void setAge(@Min(value = 0, message = "Возраст не может быть меньше нуля") int age) {
        this.age = age;
    }

    public @NotEmpty(message = "Login не должен быть пустым") @Size(min = 5, max = 15, message = "Никнейм должен содержать от 5 до 15 символов") String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(@NotEmpty(message = "Login не должен быть пустым") @Size(min = 5, max = 15, message = "Никнейм должен содержать от 5 до 15 символов") String userLogin) {
        this.userLogin = userLogin;
    }

    public @NotEmpty(message = "Email не должен быть пустым") @Email(message = "Email некорректный") String getEmail() {
        return email;
    }

    public void setEmail(@NotEmpty(message = "Email не должен быть пустым") @Email(message = "Email некорректный") String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
}
