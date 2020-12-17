package com.jawnz.app.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.jawnz.app.web.rest.TestUtil;

public class CommentTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Comment.class);
        Comment comment1 = new Comment();
        comment1.setId("id1");
        Comment comment2 = new Comment();
        comment2.setId(comment1.getId());
        assertThat(comment1).isEqualTo(comment2);
        comment2.setId("id2");
        assertThat(comment1).isNotEqualTo(comment2);
        comment1.setId(null);
        assertThat(comment1).isNotEqualTo(comment2);
    }
}
