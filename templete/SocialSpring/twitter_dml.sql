-- ����� �߰�
INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('honggildong', 'ȫ�浿', 'gdhong@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('namoosori', '�����Ҹ�', 'namoosori@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('leesunsin', '�̼���', 'sslee@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('yoogwansun', '������', 'gsyoo@nextree.co.kr', '1234');

INSERT INTO tw_user (user_id, user_nm, email, password)
VALUES ('sinsaimdang', '�Ż��Ӵ�', 'sidsin@nextree.co.kr', '1234');


-- �ȷο�
INSERT INTO tw_usertouser (from_id, to_id) 
VALUES ('honggildong', 'sinsaimdang');

INSERT INTO tw_usertouser (from_id, to_id) 
VALUES ('honggildong', 'yoogwansun');

INSERT INTO tw_usertouser (from_id, to_id) 
VALUES ('sinsaimdang', 'honggildong');

-- ���ȷο�

-- �޽��� �߰�
INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '�޽��� �߰�1', 'honggildong', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '�޽��� �߰�2', 'honggildong', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '�޽��� �߰�3', 'honggildong', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '���Ӵ��̿���1', 'sinsaimdang', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '���Ӵ��̿���2', 'sinsaimdang', sysdate);

INSERT INTO tw_message (msg_id, contents, writer_id, reg_dt)
VALUES (TW_MESSAGE_SEQ.nextval, '���Ӵ��̿���3', 'sinsaimdang', sysdate);

