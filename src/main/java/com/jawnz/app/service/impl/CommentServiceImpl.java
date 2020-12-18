package com.jawnz.app.service.impl;

import com.jawnz.app.service.CommentService;
import com.jawnz.app.domain.Comment;
import com.jawnz.app.repository.CommentRepository;
import com.jawnz.app.repository.search.CommentSearchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * Service Implementation for managing {@link Comment}.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

    private final CommentRepository commentRepository;

    private final CommentSearchRepository commentSearchRepository;

    public CommentServiceImpl(CommentRepository commentRepository, CommentSearchRepository commentSearchRepository) {
        this.commentRepository = commentRepository;
        this.commentSearchRepository = commentSearchRepository;
    }

    @Override
    public Comment save(Comment comment) {
        log.debug("Request to save Comment : {}", comment);
        Comment result = commentRepository.save(comment);
        commentSearchRepository.save(result);
        return result;
    }

    @Override
    public List<Comment> findAll() {
        log.debug("Request to get all Comments");
        return commentRepository.findAll();
    }


    @Override
    public Optional<Comment> findOne(String id) {
        log.debug("Request to get Comment : {}", id);
        return commentRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        log.debug("Request to delete Comment : {}", id);
        commentRepository.deleteById(id);
        commentSearchRepository.deleteById(id);
    }

    @Override
    public List<Comment> search(String query) {
        log.debug("Request to search Comments for query {}", query);
        return StreamSupport
            .stream(commentSearchRepository.search(queryStringQuery(query)).spliterator(), false)
        .collect(Collectors.toList());
    }
}
