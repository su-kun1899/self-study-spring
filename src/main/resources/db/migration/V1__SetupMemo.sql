CREATE TABLE MEMO (
  MEMO    VARCHAR(200)  NOT NULL,
  AUTHOR  VARCHAR(40)   NOT NULL,
  CREATED DATETIME      NOT NULL,
  PRIMARY KEY (MEMO)
);

INSERT INTO MEMO (MEMO, AUTHOR, CREATED) VALUES ('Springを学ぶ'    , '金次郎' , '2016-06-23 17:57:00.0');
INSERT INTO MEMO (MEMO, AUTHOR, CREATED) VALUES ('Thymeleafを学ぶ' , '金次郎' , '2016-06-23 17:57:00.1');
INSERT INTO MEMO (MEMO, AUTHOR, CREATED) VALUES ('Flywayを学ぶ'    , '金次郎' , '2016-06-23 17:57:00.2');
INSERT INTO MEMO (MEMO, AUTHOR, CREATED) VALUES ('AspectJを生麩'   , '金字塔' , '2016-06-23 17:57:00.3');