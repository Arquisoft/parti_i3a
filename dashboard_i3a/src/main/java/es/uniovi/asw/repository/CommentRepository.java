package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	Comment findById(Long id);

}
