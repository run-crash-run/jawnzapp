package com.jawnz.app.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import javax.validation.constraints.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Product.
 */
@Document(collection = "product")
@org.springframework.data.elasticsearch.annotations.Document(indexName = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull
    @Size(min = 1, max = 50)
    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @Field("description")
    private String description;

    @DBRef
    @Field("comment")
    private Set<Comment> comments = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Product description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Product comments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Product addComment(Comment comment) {
        this.comments.add(comment);
        comment.setProduct(this);
        return this;
    }

    public Product removeComment(Comment comment) {
        this.comments.remove(comment);
        comment.setProduct(null);
        return this;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        return id != null && id.equals(((Product) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Product{" +
            "id=" + getId() +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
