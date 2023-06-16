package com.example.review.repository;

import com.example.review.model.Vote;
import com.example.review.service.dto.vote.VoteProductManagerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Query("SELECT AVG(v.rating) FROM Vote v JOIN FETCH Product p WHERE p.id = :ProductId AND v.isApproved = true ")
    Float averageTotalRating(@Param("ProductId") Integer ProductId);

    @Query("select new com.example.review.service.dto.vote.VoteProductManagerDTO " +
            " (v.id,v.rating,pe.firstName,pe.lastName,p.name) from Vote v " +
            " join v.product p" +
            "  join v.person pe ")
    List<VoteProductManagerDTO> getVotesUnchecked();

}
