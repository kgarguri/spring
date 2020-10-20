DROP TABLE cart1 CASCADE CONSTRAINTS;
DROP TABLE user1 CASCADE CONSTRAINTS;
DROP TABLE product1 CASCADE CONSTRAINTS;
/**********************************/
/* Table Name: product1 */
/**********************************/
CREATE TABLE product1(
		p_no                          		NUMBER(10)		 NULL ,
		p_name                        		VARCHAR2(50)		 NOT NULL,
		p_price                       		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		p_image                       		VARCHAR2(100)		 DEFAULT 'images/no_image.jpg'		 NOT NULL,
		p_desc                        		VARCHAR2(200)		 NULL ,
		p_click_count                 		VARCHAR2(10)		 DEFAULT 0		 NOT NULL
);
DROP SEQUENCE product1_p_no_SEQ;
CREATE SEQUENCE product1_p_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;
/**********************************/
/* Table Name: user1 */
/**********************************/
CREATE TABLE user1(
		userId                        		VARCHAR2(100)		 NULL ,
		password                      		VARCHAR2(100)		 NULL ,
		name                          		VARCHAR2(100)		 NULL ,
		email                         		VARCHAR2(100)		 NULL 
);
/**********************************/
/* Table Name: cart1 */
/**********************************/
CREATE TABLE cart1(
		cart_itemno                   		NUMBER(10)		 NULL ,
		userId                        		VARCHAR2(100)		 NULL ,
		p_no                          		NUMBER(10)		 NULL ,
		cart_qty                      		NUMBER(10)		 DEFAULT 0		 NOT NULL,
		cart_tot_price                		NUMBER(10)		 DEFAULT 0		 NOT NULL
);
DROP SEQUENCE cart1_cart_itemno_SEQ;
CREATE SEQUENCE cart1_cart_itemno_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;
ALTER TABLE product1 ADD CONSTRAINT IDX_product1_PK PRIMARY KEY (p_no);
ALTER TABLE user1 ADD CONSTRAINT IDX_user1_PK PRIMARY KEY (userId);
ALTER TABLE cart1 ADD CONSTRAINT IDX_cart1_PK PRIMARY KEY (cart_itemno);
ALTER TABLE cart1 ADD CONSTRAINT IDX_cart1_FK0 FOREIGN KEY (p_no) REFERENCES product1 (p_no);
ALTER TABLE cart1 ADD CONSTRAINT IDX_cart1_FK1 FOREIGN KEY (userId) REFERENCES user1 (userId);

