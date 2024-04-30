package model;

public class Book {
    private String id;
    private String title;
    private String release_date;
    private Integer nr_pages;
    private Double score;

    public Book() {
    }

    public Book(String id, String title, String date, Integer duration, Double score) {
        this.id = id;
        this.title = title;
        this.release_date = date;
        this.nr_pages = duration;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return release_date;
    }

    public void setDate(String date) {
        this.release_date = date;
    }

    public Integer getNr_pages() {
        return nr_pages;
    }

    public void setNr_pages(Integer nr_pages) {
        this.nr_pages = nr_pages;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", release_date='" + release_date + '\'' +
                ", nr_pages=" + nr_pages +
                ", score=" + score +
                '}';
    }
}
