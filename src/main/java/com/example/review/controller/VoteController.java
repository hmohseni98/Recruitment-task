package com.example.review.controller;

import com.example.review.model.Comment;
import com.example.review.model.Vote;
import com.example.review.service.VoteService;
import com.example.review.service.dto.vote.VoteProductManagerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("api/vote")
public class VoteController {

    private final VoteService voteService;

    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping("averageTotalRating")
    @ResponseStatus(HttpStatus.OK)
    public String averageTotalRating(@RequestParam Integer productId) {
        Float number = voteService.averageTotalRating(productId);
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        return decimalFormat.format(number);
    }

    @GetMapping("getUnCheckedVotes")
    @ResponseStatus(HttpStatus.OK)
    public List<VoteProductManagerDTO> getUnCheckedVotes() {
        return voteService.getUnCheckedVotes();
    }

    @PatchMapping("changeApprovalStatus")
    @ResponseStatus(HttpStatus.OK)
    public void changeApprovalStatus(@RequestParam Integer voteId, @RequestParam Boolean approvalStatus) {
        Vote vote = new Vote();
        vote.setId(voteId);
        vote.setIsApproved(approvalStatus);
        voteService.update(vote);
    }
}
