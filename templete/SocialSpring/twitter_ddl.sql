-- �����
CREATE TABLE tw_user (
    user_id  VARCHAR2(20) PRIMARY KEY, -- ����ھ��̵�
    user_nm  VARCHAR2(50) NULL,     -- �̸�
    email    VARCHAR2(50) NULL,     -- �̸���
    password VARCHAR2(20) NULL      -- ��й�ȣ
);
-- �޽���
CREATE TABLE tw_message (
    msg_id    INTEGER       PRIMARY KEY, -- �޽������̵�
    contents  VARCHAR2(2000) NULL,     -- ����
    writer_id VARCHAR2(20)   NULL,     -- �ۼ���
    reg_dt    DATE     NULL      -- �ۼ��Ͻ�
);
-- ����ڰ���
CREATE TABLE tw_usertouser (
    from_id VARCHAR2(20) NOT NULL, -- ����
    to_id   VARCHAR2(20) NOT NULL  -- ������
);


�� primary key
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
   
   