CREATE TABLE board_review (
    id INT NOT NULL,
    board_review_num INT AUTO_INCREMENT,
    board_review_subject VARCHAR(30) NOT NULL,
    board_review_writer VARCHAR(30) NOT NULL,
    board_review_rating INT NOT NULL,
    board_review_content VARCHAR(1000),
    board_review_regdate DATE,




    PRIMARY KEY (board_review_num)
);

board_review_isFile int(1),

       board_review_grp int not null,
        board_review_seq int not null,
        board_review_depth int not null,
    orgName varchar(255),
    savedFileName varchar(255),
    savedPathFileName varchar(255),
    savedFileSize bigint,
    folderName varchar(10),
    ext varchar(20),