package food.model.users;


import food.model.PantryProduct;
import food.model.Schedule;
import food.model.dishconstitutent.DishIngredientDetails;
import javafx.scene.control.PopupControlBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int id;

    @Column(name="username")
    @Length(min=4, message = "Please provide a username with at least 4 characters")
    @NotEmpty(message="Please provide an username")
    private String username;

    @Column(name="email")
    @Email(message="Please provide a valid email")
    @NotEmpty(message="Please provide an email")
    private String email;

    @Column(name="password")
    @Length(min=5, message = "Please provide a password with at least 5 character")
    @NotEmpty(message="Please provide some password")
    private String password;

    @Column(name="name")
    @NotEmpty(message = "Provide some dish_name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="active")
    private int active;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Schedule> userSchedules = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    Set<PantryProduct>  pantryProducts = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public void builder(int id, String email, String password, String name, String lastname){
        setId(id);
        setEmail(email);
        setPassword(password);
        setName(name);
        setLastname(lastname);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User() {
    }

    public Set<PantryProduct> getPantryProducts() {
        return pantryProducts;
    }

    public void setPantryProducts(Set<PantryProduct> pantryProducts) {
        this.pantryProducts = pantryProducts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Schedule> getUserSchedules() {
        return userSchedules;
    }

    public void setUserSchedules(Set<Schedule> userSchedules) {
        this.userSchedules = userSchedules;
    }
}
