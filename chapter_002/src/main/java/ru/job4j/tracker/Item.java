package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

/**
 * Класс заявок
 *
 * @author Evgeny Novoselov
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long created;
    private String[] comments;

    public Item(String name, String description, long created) {
        this.name = name;
        this.description = description;
        this.created = created;
    }

    public Item(String name, String description) {
        this(name, description, new Date().getTime());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Item{"
                + "id='" + id + '\''
                + ", name='" + name + '\''
                + ", description='" + description + '\''
                + ", created=" + created
                + ", comments=" + Arrays.toString(comments)
                + '}';
    }
}
