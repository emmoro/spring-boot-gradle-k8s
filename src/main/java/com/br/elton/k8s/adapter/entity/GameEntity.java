package com.br.elton.k8s.adapter.entity;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @SequenceGenerator(name = "game_idsequence", sequenceName = "game_idsequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_idsequence")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "release_year")
    private Integer releaseYear;

    @ManyToOne
    @JoinColumn(name = "console_id", referencedColumnName = "id")
    private ConsoleEntity console;

    public GameEntity() {
    }

    public static GameEntity create(String title, Integer releaseYear, ConsoleEntity console) {
        GameEntity game = new GameEntity();
        game.setTitle(title);
        game.setReleaseYear(releaseYear);
        game.setConsole(console);
        return game;
    }

    public GameEntity(Long id, String title, Integer releaseYear, ConsoleEntity console) {
        super();
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.console = console;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        if (releaseYear < 0) {
            throw new NumberFormatException("Game release year must be a positive number");
        }
        this.releaseYear = releaseYear;
    }

    public ConsoleEntity getConsole() {
        return console;
    }

    public void setConsole(ConsoleEntity console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", console=" + console +
                '}';
    }

}