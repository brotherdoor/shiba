-- 사용자 추가
INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('honggildong', '홍길동', 'gdhong@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('namoosori', '나무소리', 'namoosori@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('leesunsin', '이순신', 'sslee@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('yoogwansun', '유관순', 'gsyoo@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('sinsaimdang', '신사임당', 'sidsin@nextree.co.kr', '1234');


-- 팔로우
INSERT INTO tw_usertouser (from_id, to_id) 
VALUES ('honggildong', 'sinsaimdang');

INSERT INTO tw_usertouser (from_id, to_id) 
VALUES ('honggildong', 'yoogwansun');

INSERT INTO tw_usertouser (from_id, to_id) 
VALUES ('sinsaimdang', 'honggildong');

-- 언팔로우

-- 메시지 추가
INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '메시지 추가1', 'honggildong', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '메시지 추가2', 'honggildong', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '메시지 추가3', 'honggildong', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '사임당이예요1', 'sinsaimdang', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '사임당이예요2', 'sinsaimdang', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '사임당이예요3', 'sinsaimdang', sysdate);

