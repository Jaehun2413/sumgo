package com.example.review2.Mapper;

import com.example.review2.Dto.ReviewDto;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewMapper {



    @Insert("INSERT INTO board_review VALUES(#{id}, null, #{boardReviewSubject}, #{boardReviewWriter}, #{boardReviewRating}, #{boardReviewContent}, now())")
    void setReviewWrite(ReviewDto reviewDto);


    @Select("SELECT * FROM board_review WHERE ${searchQuery} ORDER BY board_review_num DESC LIMIT #{startNum}, #{offset}")
    List<ReviewDto> getReview(Map<String, Object> map);

    @Select("SELECT COUNT(*) FROM board_review ${searchQuery}")
    int getListCount(String searchQuery);

//    @Select("SELECT * FROM board_review WHERE board_review_num = #{id}")
//    List<ReviewDto> getView(int id);

    @Select("SELECT COUNT(*) FROM board_review ${searchQuery}")
    int getBoardCount(String searchQuery);


    @Select("SELECT * FROM board_review WHERE board_review_num = #{id}")
    public List<ReviewDto> getView(int id);

    @Delete("DELETE FROM board_review WHERE board_review_num = #{boardReviewNum}")
    void setCommentDelete(int boardReviewNum);


}