package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native")
    private int id;

    @Column(name = "familyName")
    private String familyName;

    @Column(name = "userId")
    private int userId;

    @OneToMany(mappedBy = "family")
    private List<User> members;

    public Family() {

    }

    public Family(String familyName, int userId) {
        this.familyName = familyName;
        this.userId = userId;
    }

    /**
     * Getter for id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for Id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for familyName
     *
     * @return familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * Setter for familyName
     *
     * @param familyName
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * Getter for userId
     *
     * @return userId
     */
    public void getUserId(List<User> members) {
        this.members = members;
    }

    /**
     * Setter for userId
     *
     * @param userId
     */
    public void setUserId(List<User> members) {
        this.members = members;
    }

    /**
     * Getter for members
     *
     * @return members
     */
    public List<User> getMembers() {
        return members;
    }

    /**
     * Setter for members
     *
     * @param members
     */
    public void setMembers(List<User> members) {
        this.members = members;
    }
}
