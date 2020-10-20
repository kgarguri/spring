DROP TABLE jumun_detail2 CASCADE CONSTRAINTS;
DROP TABLE jumun2 CASCADE CONSTRAINTS;
DROP TABLE cart2 CASCADE CONSTRAINTS;
DROP TABLE user2 CASCADE CONSTRAINTS;
DROP TABLE product2 CASCADE CONSTRAINTS;

CREATE TABLE product2(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_image                       		VARCHAR2(100)		 DEFAULT 'images/no_image.jpg'		 NOT NULL,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_click_count                 		VARCHAR2(10)		 DEFAULT 0		 NOT NULL
);

DROP SEQUENCE product2_p_no_SEQ;

CREATE SEQUENCE product2_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;



CREATE TABLE user2(
		userId                        		VARCHAR2(100)		 NULL ,
		password                      		VARCHAR2(100)		 NULL ,
		name                          		VARCHAR2(100)		 NULL ,
		email                         		VARCHAR2(100)		 NULL 
);


CREATE TABLE cart2(
		cart_itemno                   		NUMBER(10)		 NULL ,
		userId                        		VARCHAR2(100)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		cart_tot_price                		NUMBER(10)		 DEFAULT 0		 NOT NULL
);

DROP SEQUENCE cart2_cart_itemno_SEQ;

CREATE SEQUENCE cart2_cart_itemno_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE jumun2(
		j_no                          		NUMBER(10)		 NULL ,
		j_desc                        		VARCHAR2(100)		 NULL ,
		j_date                        		DATE		 DEFAULT sysdate		 NULL ,
		j_price                       		NUMBER(10)		 NULL ,
		userId                        		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE jumun2_j_no_SEQ;

CREATE SEQUENCE jumun2_j_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE jumun_detail2(
		jd_no                         		NUMBER(10)		 NULL ,
		jd_qty                        		NUMBER(10)		 DEFAULT 0		 NULL ,
		jd_pname                      		VARCHAR2(100)		 NULL ,
		jd_tot_price                  		NUMBER(10)		 NULL ,
		j_no                          		NUMBER(10)		 NULL ,
		p_no                          		NUMBER(10)		 NULL 
);

DROP SEQUENCE jumun_detail2_jd_no_SEQ;

CREATE SEQUENCE jumun_detail2_jd_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;





ALTER TABLE product2 ADD CONSTRAINT IDX_product2_PK PRIMARY KEY (p_no);

ALTER TABLE user2 ADD CONSTRAINT IDX_user2_PK PRIMARY KEY (userId);

ALTER TABLE cart2 ADD CONSTRAINT IDX_cart2_PK PRIMARY KEY (cart_itemno);
ALTER TABLE cart2 ADD CONSTRAINT IDX_cart2_FK0 FOREIGN KEY (p_no) REFERENCES product2 (p_no);
ALTER TABLE cart2 ADD CONSTRAINT IDX_cart2_FK1 FOREIGN KEY (userId) REFERENCES user2 (userId);

ALTER TABLE jumun2 ADD CONSTRAINT IDX_jumun2_PK PRIMARY KEY (j_no);
ALTER TABLE jumun2 ADD CONSTRAINT IDX_jumun2_FK0 FOREIGN KEY (userId) REFERENCES user2 (userId);

ALTER TABLE jumun_detail2 ADD CONSTRAINT IDX_jumun_detail2_PK PRIMARY KEY (jd_no);
ALTER TABLE jumun_detail2 ADD CONSTRAINT IDX_jumun_detail2_FK0 FOREIGN KEY (j_no) REFERENCES jumun2 (j_no);
ALTER TABLE jumun_detail2 ADD CONSTRAINT IDX_jumun_detail2_FK1 FOREIGN KEY (p_no) REFERENCES product2 (p_no);

