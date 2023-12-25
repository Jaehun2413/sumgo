package com.example.review2.Controller;

import com.example.review2.Dto.ReviewDto;
import com.example.review2.Mapper.ReviewMapper;
import com.example.review2.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SrvController {
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    ReviewService reviewService;

    @Value("${reviewImgDir}")
    String reviewImgDir;

    @GetMapping("/sub_review_write")
    public String getReviewWrite() {
        return "sub_review/sub_review_write";
    }

    @PostMapping("/sub_review_write")
    public String setWrite(@ModelAttribute ReviewDto reviewDto) {
        reviewMapper.setReviewWrite(reviewDto);
        return "redirect:/sub_review_list";
    }


    @GetMapping("/sub_review_list")
    public String getList(Model model,
                          @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "searchType", defaultValue = "") String searchType,
                          @RequestParam(value = "words", defaultValue = "") String words) {

        String searchQuery = reviewService.getSearch(searchType, words);
        List<ReviewDto> reviewList = reviewService.getReview(page, searchType, words);

        model.addAttribute("list", reviewList);
        model.addAttribute("cnt", reviewMapper.getListCount(searchQuery));
        model.addAttribute("page", reviewService.PageCal(page, searchType, words));

        System.out.println("Page: " + page);
        System.out.println("Search Type: " + searchType);
        System.out.println("Words: " + words);
        System.out.println("Review List: " + reviewList);

        return "sub_review/sub_review_list";
    }

    @GetMapping("/sub_review_view")
    public String getReviewView(@RequestParam int boardReviewNum, Model model) {
        // 수정: 리뷰 상세 조회 시 조회수 증가 로직 추가
        reviewMapper.getView(boardReviewNum);
        model.addAttribute("review", reviewMapper.getView(boardReviewNum));
        return "sub_review/sub_review_view";
    }

    @GetMapping("/sub_review_delete")
    public String getReviewDelete(@RequestParam int boardReviewNum) {
        reviewMapper.setCommentDelete(boardReviewNum);
        return "redirect:/sub_review_list";
    }
}


