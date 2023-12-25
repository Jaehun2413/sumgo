package com.example.review2.Service;


import com.example.review2.Dto.PageDto;
import com.example.review2.Dto.ReviewDto;
import com.example.review2.Mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {
    @Autowired
    ReviewMapper reviewMapper;

    public List<ReviewDto> getReview(int page, String searchType, String words) {
        Map<String, Object> map = new HashMap<>();
        String searchQuery = getSearch(searchType, words);
        PageDto pageDto = new PageDto();
        int startNum = (page - 1) * pageDto.getPageCount();

        map.put("searchQuery", searchQuery);
        map.put("startNum", startNum);
        map.put("offset", pageDto.getPageCount());

        return reviewMapper.getReview(map);
    }

    public String getSearch(String searchType, String words) {
        Map<String, Object> map = new HashMap<>();
        String searchQuery = "";

        if (searchType.equals("boardReviewWriter")) {
            searchQuery = "where " + searchType + " = " + "'" + words + "'";
        } else if (searchType.equals("boardReviewSubject") || searchType.equals("boardReviewContent")) {
            searchQuery = "where " + searchType + " like " + "'%" + words + "%'";
        } else {
            searchQuery = "";
        }

        return searchQuery;
    }

    public Object PageCal(int page, String searchType, String words) {
        PageDto pageDto = new PageDto();
        String searchQuery = getSearch(searchType, words);

        int totalCount = reviewMapper.getListCount(searchQuery);
        int totalPage = (int) Math.ceil((double) totalCount / pageDto.getPageCount());
        int startPage = (int) (Math.ceil((double) page / pageDto.getBlockCount()) - 1) * pageDto.getBlockCount() + 1;
        int endPage = startPage + pageDto.getBlockCount() - 1;

        if (endPage > totalPage) {
            endPage = totalPage;
        }

        pageDto.setPage(page);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        pageDto.setTotalPage(totalPage);

        return pageDto;
    }
}
