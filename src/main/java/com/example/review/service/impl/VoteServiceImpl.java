package com.example.review.service.impl;

import com.example.review.model.Vote;
import com.example.review.repository.VoteRepository;
import com.example.review.service.VoteService;
import com.example.review.service.base.BaseServiceImpl;
import com.example.review.service.dto.vote.VoteProductManagerDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED , propagation = Propagation.REQUIRED)
public class VoteServiceImpl extends BaseServiceImpl<Vote, Integer, VoteRepository> implements VoteService {

    public VoteServiceImpl(VoteRepository repository) {
        super(repository);
    }


    @Override
    public Float averageTotalRating(Integer productId) {
        return repository.averageTotalRating(productId);
    }

    @Override
    public List<VoteProductManagerDTO> getUnCheckedVotes() {
        return repository.getVotesUnchecked();
    }

    @Override
    public void update(Vote vote) {
        Vote newVote = findById(vote.getId());
        newVote.setIsApproved(vote.getIsApproved());
        newVote.setIsChecked(true);
        super.update(newVote);
    }
}
