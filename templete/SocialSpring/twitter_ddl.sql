-- 사용자
CREATE TABLE tw_user (
    user_id  VARCHAR2(20) PRIMARY KEY, -- 사용자아이디
    user_nm  VARCHAR2(50) NULL,     -- 이름
    email    VARCHAR2(50) NULL,     -- 이메일
    password VARCHAR2(20) NULL      -- 비밀번호
);
-- 메시지
CREATE TABLE tw_message (
    msg_id    INTEGER       PRIMARY KEY, -- 메시지아이디
    contents  VARCHAR2(2000) NULL,     -- 내용
    writer_id VARCHAR2(20)   NULL,     -- 작성자
    reg_dt    DATE     NULL      -- 작성일시
);
-- 사용자관계
CREATE TABLE tw_usertouser (
    from_id VARCHAR2(20) NOT NULL, -- 누가
    to_id   VARCHAR2(20) NOT NULL  -- 누구를
);


― primary key
ALTER TABLE tw_usertouser
  ADD CONSTRAINT PK_tw_usertouser
   PRIMARY KEY (from_id, to_id);

-- foreign key   
ALTER TABLE tw_message
  ADD CONSTRAINT FK_tw_message_to_tw_user
   FOREIGN KEY (writer_id)
   REFERENCES tw_user (user_id);
   
ALTER TABLE tw_usertouser
  ADD CONSTRAINT FK_usertouser_from_tw_user
   FOREIGN KEY (from_id)
   REFERENCES tw_user (user_id);
   
ALTER TABLE tw_usertouser
  ADD CONSTRAINT FK_usertouser_to_tw_user
   FOREIGN KEY (to_id)
   REFERENCES tw_user (user_id);
   
-- sequence
CREATE SEQUENCE TW_MESSAGE_SEQ START WITH 1 INCREMENT BY 1;
   
   