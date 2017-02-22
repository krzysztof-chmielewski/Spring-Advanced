package io.kch.sda.spring.jpa15.song;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "album", catalog = "spring")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "album", nullable = false)
    @NotEmpty
    private String album;

    @NotEmpty
    @ManyToOne
    private Artist artist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
