package br.com.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity(name = "PATRIMONY")
public class Patrimony {

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "NUM_TUMBLE", updatable = false)
    private Long numTumble;

    @ManyToOne
    @JoinColumn(name = "ID_MARK", referencedColumnName = "ID")
    private Mark mark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumTumble() {
        return numTumble;
    }

    public void setNumTumble(Long numTumble) {
        this.numTumble = numTumble;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
