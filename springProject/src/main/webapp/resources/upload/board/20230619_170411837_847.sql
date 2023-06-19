----------------------------------------------------------------
---------------------- MEMBER TABLE --------------------------
----------------------------------------------------------------
CREATE TABLE MEMBER (
    USER_ID VARCHAR2(30) PRIMARY KEY,
    USER_PWD VARCHAR2(100) NOT NULL,
    USER_NAME VARCHAR2(15) NOT NULL,
    EMAIL VARCHAR2(100),
    BIRTHDAY DATE,
    PHONE CHAR(13),
    CREATE_DATE DATE DEFAULT SYSDATE,
    STATUS NUMBER DEFAULT 1 CHECK(STATUS IN(1, 0))
);

INSERT INTO MEMBER
VALUES ('admin', '1234', '관리자', 'admin@kh.or.kr', to_date('93-01-20','rr-mm-dd'), '010-1111-2222', DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES ('user01', '1234', '홍길동', 'user01@kh.or.kr', to_date('03-11-15','rr-mm-dd'), '010-1111-2223', DEFAULT, DEFAULT);

INSERT INTO MEMBER
VALUES ('user02', '1234', '아무개', 'user02@kh.or.kr', to_date('07-10-25','rr-mm-dd'), '010-1111-2224', DEFAULT, DEFAULT);

commit;