package com.example.review.service;

import com.example.review.model.Vote;
import com.example.review.service.base.BaseService;
import com.example.review.service.dto.vote.VoteProductManagerDTO;

import java.util.List;

public interface VoteService extends BaseService<Vote,Integer> {
    Float averageTotalRating(Integer productId);

    List<VoteProductManagerDTO> getUnCheckedVotes();
}
