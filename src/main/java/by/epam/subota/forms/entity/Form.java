package by.epam.subota.forms.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "form")
public class Form implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "comment")
    private String comment;

    @Column(name = "user_token")
    private String userToken;

    @Column(name = "admin_token")
    private String adminToken;

    @Column(name = "time_created")
    private Date timeCreated;

    @OneToMany(mappedBy = "form")
    private List<Question> questions;
}
