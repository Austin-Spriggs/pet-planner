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

    @OneToMany(mappedBy = "family")
    private List<User> members;

    public Family() {

    }

    public Family(String familyName) {
        this.familyName = familyName;
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
